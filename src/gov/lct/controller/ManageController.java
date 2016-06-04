package gov.lct.controller;

import gov.lct.model.Trole;
import gov.lct.model.Ttimeset;
import gov.lct.model.Tupload;
import gov.lct.model.Tuser;
import gov.lct.service.TroleService;
import gov.lct.service.TtimesetService;
import gov.lct.service.TuploadService;
import gov.lct.service.TuserService;
import gov.lct.util.StringProcess;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import gov.lct.model.Trequire;
import gov.lct.service.TrequireService;
import gov.lct.model.Tevaluation;
import gov.lct.model.Tpatentbasicinfo;
import gov.lct.service.TevaluationService;
import gov.lct.service.TpatentbasicinfoService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;



import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.taglibs.standard.tag.common.fmt.SetTimeZoneSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


import gov.lct.util.*;
import com.hp.hpl.jena.n3.RelativeURIException;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.sparql.core.Var;
import com.hp.hpl.jena.sparql.expr.E_StrEndsWith;
import com.hp.hpl.jena.sparql.util.Convert;


/**
 * @date 2016-04-22
 * 联创通后台管理代码
 */
@Controller
@RequestMapping(value = "manage")
public class ManageController {

	@Autowired
	private TroleService troleService;
	@Autowired
	private TrequireService trequireService;
	@Autowired
	private TpatentbasicinfoService patentService;
	@Autowired
	private TuploadService tuploadService;
	@Autowired
	private TtimesetService ttimesetServer;
	@Autowired
	private TevaluationService tevaluationService;
	@Autowired
	private TuserService tuserservice;
	
	
	@RequestMapping(value="/index")
	public String Manage(HttpServletRequest request) throws Exception {	
		HttpSession session = request.getSession();	
		if(session==null)
		{
		   request.setAttribute("reason", "NOSESSION");
			return "unauth/error";		  
		}
		else
		{
		   String realname = session.getAttribute("realname").toString();
		   String loginname = session.getAttribute("loginname").toString();		
		   System.out.println(realname);
		   System.out.println(loginname);
           return "unauth/manage/manage";
		}
	}
	
	@RequestMapping(value="/left")
	public String Left(HttpServletRequest request) throws Exception {	
        return "unauth/manage/adm-left-menu";
	}
	
	@RequestMapping(value="/expertleft")
	public String ExpertLeft(HttpServletRequest request) throws Exception {	
        return "unauth/manage/expert-left";
	}
	
	@RequestMapping(value="/expert1")
	public String Expert1(HttpServletRequest request) throws Exception {	
        return "unauth/manage/expert1";
	}
	
	@RequestMapping(value="/top")
	public String Top(HttpServletRequest request) throws Exception {	
        return "unauth/manage/top";
	}

	@RequestMapping(value="/split")
	public String Split(HttpServletRequest request) throws Exception {	
        return "unauth/manage/split";
	}

	@RequestMapping(value="/main")
	public String Main(HttpServletRequest request) throws Exception {	
        return "unauth/manage/main";
	}
	
	@RequestMapping(value="/bottom")
	public String Bottom(HttpServletRequest request) throws Exception {	
        return "unauth/manage/bottom";
	}
	
	@RequestMapping(value="/roleadd")
	public String Roleinsert(HttpServletRequest request) throws Exception {	
		System.out.println("roleinsert：显示角色添加页面");
		request.setAttribute("ifAdd", "0");
        return "unauth/manage/role";
	}
	
	@RequestMapping(value="/rolesave")
	public String Rolesave(HttpServletRequest request) throws Exception {	
		System.out.println("rolesave：角色保存");
		Trole roleinfo = new Trole();
	    ArrayList<String> fieldnameList=new ArrayList<String>();
		ArrayList<String> valueList=new ArrayList<String>();
		ArrayList<String> conditionList=new ArrayList<String>();
		fieldnameList.add("rolename");
		valueList.add(request.getParameter("rolecode"));
		conditionList.add("=");
		int totalRow = troleService.getRows(Trole.class, fieldnameList, valueList, conditionList);
		if(totalRow==0)
		{			  
	      roleinfo.setRolename(request.getParameter("rolename"));
	      roleinfo.setRolecode(request.getParameter("rolecode"));
	      roleinfo.setRoledesc(request.getParameter("roledesc"));
	      troleService.save(roleinfo);
		  request.setAttribute("ifAdd", request.getParameter("rolename")); //返回值如果不是0，则表示角色添加成功
		}		
        return "unauth/manage/role";
	}

	
	@RequestMapping(value="/require")
	public String Require(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();			
		if(session==null)
		{
		   request.setAttribute("reason", "NOSESSION");
			return "unauth/error";		  
		}
		else
		{
		   String realname = session.getAttribute("realname").toString();
		   String loginname = session.getAttribute("loginname").toString();		
		   System.out.println(realname);
		   System.out.println(loginname);
		   return "unauth/manage/require";
		}				
	}

	@RequestMapping(value="/requiresave")
	public String Requireadd(HttpServletRequest request) throws Exception {
		System.out.println("requiresave：需求信息保存");
		Trequire requireinfo = new Trequire();
	    Date curDate = new Date(System.currentTimeMillis());//获取当前时间 
	    SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    String createdate=formatter.format(curDate);  
	    System.out.println(request.getParameter("name"));
		requireinfo.setName(request.getParameter("name"));
		requireinfo.setIndustry(request.getParameter("industry"));
		requireinfo.setContent(request.getParameter("content"));
		requireinfo.setProblem(request.getParameter("problem"));
		requireinfo.setHavaCondition(request.getParameter("haveCondition"));		
		requireinfo.setCooperation(request.getParameter("cooperation"));
		requireinfo.setUnitName(request.getParameter("unitName"));
		requireinfo.setLinkman(request.getParameter("linkman"));
		requireinfo.setPhone(request.getParameter("phone"));
		requireinfo.setAddress(request.getParameter("address"));
		requireinfo.setZipcode(request.getParameter("zipcode"));
		requireinfo.setEmail(request.getParameter("email"));
		requireinfo.setCreateDate(createdate);
		requireinfo.setCreatePerson(request.getParameter("createPerson"));
		requireinfo.setStatus("0");

		trequireService.save(requireinfo);
		return "unauth/manage/require";
	}
	

	@RequestMapping(value="/requireauth")
	public String Requireauth(HttpServletRequest request) throws Exception {
		System.out.println("requiresave：需求信息管理员审核");
		HttpSession session = request.getSession();			
		if(session==null)
		{
		   request.setAttribute("reason", "NOSESSION");
			return "unauth/error";		  
		}
		else
		{		 
		   String loginname = session.getAttribute("loginname").toString();
		   if(loginname.equals("guest"))
		   {
			  Collection availableItems = null;
			  availableItems = trequireService.queryItems(Trequire.class, "status", "0", "=", "id", 50, 0);
			  //availableItems = trequireService.findAll(Trequire.class);
		      request.setAttribute("availableItems", availableItems); 
		   }
		}
		
		return "unauth/manage/requireauth";
	}
	
	@RequestMapping(value="/requireauthsave")
	public String Requireauthsave(HttpServletRequest request) throws Exception {

		String[] reqradios = request.getParameterValues("reqradio");
		for(int i=0; i<reqradios.length; i++)
		{
		   System.out.println("The" + i + "record is  " + reqradios[i]);	
		   Trequire require = new Trequire();
		   Collection availableItems = trequireService.queryItems(Trequire.class, "id", reqradios[i], "=", "id", 1, 0);
		   require = (Trequire)availableItems.iterator().next();
		   require.setStatus("1");
		   trequireService.update(require);
		}
		return "unauth/manage/requireauth";
	}

	@RequestMapping(value="/patentrecommend")
	public String Patentrecommend(HttpServletRequest request) throws Exception {
		System.out.println("patentrecommend：重点专利推荐");
		HttpSession session = request.getSession();			
		if(session==null)
		{
		   request.setAttribute("reason", "NOSESSION");
			return "unauth/error";		  
		}
		else
		{		 
		   String loginname = session.getAttribute("loginname").toString();
		   if(loginname.equals("guest"))
		   {
			  Collection availableItems = null;
			  availableItems = patentService.queryItems(Tpatentbasicinfo.class, "status", "null", "is", "patent_an", 20, 0);
		      request.setAttribute("availableItems", availableItems); 
		   }
		}	    
		
		return "unauth/manage/patentrecommend";
	}
		
	@RequestMapping(value="/patentrecommendsave")
	public String Patentrecommendsave(HttpServletRequest request) throws Exception {

		String[] patentchecks = request.getParameterValues("patentcheck");
		for(int i=0; i<patentchecks.length; i++)
		{
		   System.out.println("The  " + i + "  record is  " + patentchecks[i]);	
		   Tpatentbasicinfo patentinfo = new Tpatentbasicinfo();
		   Collection availableItems = patentService.queryItems(Tpatentbasicinfo.class, "id", patentchecks[i], "=", "id", 1, 0);
		   patentinfo = (Tpatentbasicinfo)availableItems.iterator().next();
		   patentinfo.setStatus("1");
		   patentService.update(patentinfo);
		}
		
		  Collection availableItems = null;
		  availableItems = patentService.queryItems(Tpatentbasicinfo.class, "status", "null", "is", "patent_an", 20, 0);
	      request.setAttribute("availableItems", availableItems); 

		return "unauth/manage/patentrecommend";
	}
	
	@RequestMapping(value="/patentsearch")
	public String Patentsearch(HttpServletRequest request) throws Exception {
		System.out.println("patentrecommend：重点专利推荐保存");
		String item = request.getParameter("item");
		String content = request.getParameter("content");
		if(item.equals("patentan"))
		   item = "patent_an";
		else if(item.equals("patentti"))
		   item = "patent_ti";
		else
		   item = "patent_fpa";
		
	    Collection availableItems = null;
		availableItems = patentService.queryItems(Tpatentbasicinfo.class, item, content, "like", "patent_an", 20, 0);
	    request.setAttribute("availableItems", availableItems);
	    
		return "unauth/manage/patentresult";
	}	
	
	
	@RequestMapping(value="/patentmanage")
	public String Patentmanage(HttpServletRequest request) throws Exception {
		System.out.println("patentrecommend：重点专利推荐查看");
		HttpSession session = request.getSession();			
		if(session==null)
		{
		   request.setAttribute("reason", "NOSESSION");
			return "unauth/error";		  
		}
		else
		{		 
		   String loginname = session.getAttribute("loginname").toString();
		   if(loginname.equals("guest"))
		  {
			  Collection availableItems = null;
			  availableItems = patentService.queryItems(Tpatentbasicinfo.class, "status", "1", "=", "patent_an", 50, 0);
		      request.setAttribute("availableItems", availableItems); 
		  }
		}	    
		return "unauth/manage/patentmanage";
	}
	
	
	@RequestMapping(value="/patentnorecommendsave")
	public String Patentnorecommendsave(HttpServletRequest request) throws Exception {
			
		String[] patentchecks = request.getParameterValues("patentcheck");
		for(int i=0; i<patentchecks.length; i++)
		{
		   System.out.println("The  " + i + "  record is  " + patentchecks[i]);	
		   Tpatentbasicinfo patentinfo = new Tpatentbasicinfo();
		   Collection availableItems = patentService.queryItems(Tpatentbasicinfo.class, "id", patentchecks[i], "=", "id", 1, 0);
		   patentinfo = (Tpatentbasicinfo)availableItems.iterator().next();
		   patentinfo.setStatus(null);
		   patentService.update(patentinfo);
		}

		  Collection availableItems = null;
		  availableItems = patentService.queryItems(Tpatentbasicinfo.class, "status", "1", "=", "patent_an", 20, 0);
	      request.setAttribute("availableItems", availableItems); 

		return "unauth/manage/patentmanage";
	}
	
	@RequestMapping(value="/information")
	public String subInformation(HttpServletRequest request){
		return "unauth/manage/information";
	}
	
	@RequestMapping(value="/admuserdata")
	public String admuserdata(HttpServletRequest request) throws Exception{
		return "unauth/manage/adm-userdata";
	}
	
	@RequestMapping(value="/usermenu")
	public String userMenu(HttpServletRequest request) throws Exception{
		return "unauth/manage/user-menu";
	}
	
	@RequestMapping(value="/userleft")
	public String userLeft(HttpServletRequest request) throws Exception {	
        return "unauth/manage/user-left";
	}
	
	@RequestMapping(value="/userstate")
	public String userState(HttpServletRequest request) throws Exception {	
		String loginname = null;
		try {
			HttpSession session = request.getSession();	
			//String realname = session.getAttribute("realname").toString();
			loginname = session.getAttribute("loginname").toString();	
			//System.out.println(realname);
			System.out.println(loginname);
			if (loginname.equals(null)) {
				return "/error";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "/error";
		}
		//设置时间
        request.setAttribute("endtime", "2015-05-05 21:12:12");
        //
        
        Collection availableItems = null;
		availableItems = tuploadService.queryItems(Tupload.class, "loginname", loginname, "=", "id", 50, 0);
		Iterator patents = null;
		if(availableItems!=null)
		{
			patents = availableItems.iterator();
			while(patents.hasNext())
			{
				 Tupload upload = (Tupload)patents.next();
				 request.setAttribute("file1", StringProcess.getString(upload.getFile1()));
				 request.setAttribute("file2", StringProcess.getString(upload.getFile2()));
				 request.setAttribute("file3", StringProcess.getString(upload.getFile3()));
				 request.setAttribute("file4", StringProcess.getString(upload.getFile4()));
				 request.setAttribute("file5", StringProcess.getString(upload.getFile5()));
				 request.setAttribute("file6", StringProcess.getString(upload.getFile6()));
				 request.setAttribute("file7", StringProcess.getString(upload.getFile7()));
				 request.setAttribute("file8", StringProcess.getString(upload.getFile8()));
				 request.setAttribute("file9", StringProcess.getString(upload.getFile9()));
				 request.setAttribute("file10", StringProcess.getString(upload.getFile10()));
				 request.setAttribute("file11", StringProcess.getString(upload.getFile11()));
				 request.setAttribute("file12", StringProcess.getString(upload.getFile12()));
				 request.setAttribute("file13", StringProcess.getString(upload.getFile13()));
				 request.setAttribute("file14", StringProcess.getString(upload.getFile14()));
				 request.setAttribute("uploadtime", StringProcess.getString(upload.getUploadtime()));
				 request.setAttribute("suggestion", StringProcess.getString(upload.getSuggestion()));
			}
		}else{
			request.setAttribute("file1", StringProcess.getString(""));
			 request.setAttribute("file2", StringProcess.getString(""));
			 request.setAttribute("file3", StringProcess.getString(""));
			 request.setAttribute("file4", StringProcess.getString(""));
			 request.setAttribute("file5", StringProcess.getString(""));
			 request.setAttribute("file6", StringProcess.getString(""));
			 request.setAttribute("file7", StringProcess.getString(""));
			 request.setAttribute("file8", StringProcess.getString(""));
			 request.setAttribute("file9", StringProcess.getString(""));
			 request.setAttribute("file10", StringProcess.getString(""));
			 request.setAttribute("file11", StringProcess.getString(""));
			 request.setAttribute("file12", StringProcess.getString(""));
			 request.setAttribute("file13", StringProcess.getString(""));
			 request.setAttribute("file14", StringProcess.getString(""));
			 request.setAttribute("uploadtime", StringProcess.getString(""));
			 request.setAttribute("suggestion", StringProcess.getString(""));
		}
        return "unauth/manage/user-state";
	}
	
	@RequestMapping(value="/userupload")
	public String pageUpload(HttpServletRequest request) throws Exception{
		String loginname = null;
		try {
			HttpSession session = request.getSession();	
			//String realname = session.getAttribute("realname").toString();
			loginname = session.getAttribute("loginname").toString();	
			//System.out.println(realname);
			System.out.println(loginname);
			if (loginname.equals(null)) {
				return "/error";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "/error";
		}
		//设置时间
        request.setAttribute("endtime", "2015-05-05 21:12:12");
        //
        
        Collection availableItems = null;
		availableItems = tuploadService.queryItems(Tupload.class, "loginname", loginname, "=", "id", 50, 0);
		Iterator patents = null;
		if(availableItems!=null)
		{
			patents = availableItems.iterator();
			while(patents.hasNext())
			{
				 Tupload upload = (Tupload)patents.next();
				 request.setAttribute("file1", StringProcess.getString(upload.getFile1()));
				 request.setAttribute("file2", StringProcess.getString(upload.getFile2()));
				 request.setAttribute("file3", StringProcess.getString(upload.getFile3()));
				 request.setAttribute("file4", StringProcess.getString(upload.getFile4()));
				 request.setAttribute("file5", StringProcess.getString(upload.getFile5()));
				 request.setAttribute("file6", StringProcess.getString(upload.getFile6()));
				 request.setAttribute("file7", StringProcess.getString(upload.getFile7()));
				 request.setAttribute("file8", StringProcess.getString(upload.getFile8()));
				 request.setAttribute("file9", StringProcess.getString(upload.getFile9()));
				 request.setAttribute("file10", StringProcess.getString(upload.getFile10()));
				 request.setAttribute("file11", StringProcess.getString(upload.getFile11()));
				 request.setAttribute("file12", StringProcess.getString(upload.getFile12()));
				 request.setAttribute("file13", StringProcess.getString(upload.getFile13()));
				 request.setAttribute("file14", StringProcess.getString(upload.getFile14()));
				 request.setAttribute("uploadtime", StringProcess.getString(upload.getUploadtime()));
				 request.setAttribute("suggestion", StringProcess.getString(upload.getSuggestion()));
			}
		}else{
			request.setAttribute("file1", StringProcess.getString(""));
			 request.setAttribute("file2", StringProcess.getString(""));
			 request.setAttribute("file3", StringProcess.getString(""));
			 request.setAttribute("file4", StringProcess.getString(""));
			 request.setAttribute("file5", StringProcess.getString(""));
			 request.setAttribute("file6", StringProcess.getString(""));
			 request.setAttribute("file7", StringProcess.getString(""));
			 request.setAttribute("file8", StringProcess.getString(""));
			 request.setAttribute("file9", StringProcess.getString(""));
			 request.setAttribute("file10", StringProcess.getString(""));
			 request.setAttribute("file11", StringProcess.getString(""));
			 request.setAttribute("file12", StringProcess.getString(""));
			 request.setAttribute("file13", StringProcess.getString(""));
			 request.setAttribute("file14", StringProcess.getString(""));
			 request.setAttribute("uploadtime", StringProcess.getString(""));
			 request.setAttribute("suggestion", StringProcess.getString(""));
		}
	    //request.setAttribute("availableItems", availableItems); 
		return "unauth/manage/user-upload";
	}
	
	@RequestMapping("/upload")
	public String upload(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
		String loginname = null;
		try {
			HttpSession session = request.getSession();	
			//String realname = session.getAttribute("realname").toString();
			loginname = session.getAttribute("loginname").toString();	
			//System.out.println(realname);
			System.out.println(loginname);
			if (loginname.equals(null)) {
				return "/error";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "/error";
		}
		
		//保存所有文件名
		ArrayList<String> files = new ArrayList<String>();
		//创建一个通用的多部分解析器  
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
        //判断 request 是否有文件上传,即多部分请求  
        if(multipartResolver.isMultipart(request)){  
            //转换成多部分request    
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
            //取得request中的所有文件名  
            Iterator<String> iter = multiRequest.getFileNames(); 
            //存储上传文件
            Tupload tupload = new Tupload();
            if (tuploadService.getRows(Tupload.class, "loginname", loginname, "=") != 0){
            	Collection availableItems = tuploadService.queryItems(Tupload.class, "loginname", loginname, "=", "id", 1, 0);
     		    tupload = (Tupload)availableItems.iterator().next();
            }
            tupload.setLoginname(loginname);
            while(iter.hasNext()){  
                //记录上传过程起始时的时间，用来计算上传时间  
                int pre = (int) System.currentTimeMillis(); 
                //取得上传文件  
                MultipartFile file = multiRequest.getFile(iter.next());
                //校验文件是否合法
                String[] formatCheck = {".doc",".docx",".pdf",".xls",".jpg",".png",".jpeg"};
                String tempCheck = file.getOriginalFilename();
                String fix="." + tempCheck.substring(tempCheck.lastIndexOf(".")+1);
                boolean isRightFile = false;
                for(int i = 0; i < formatCheck.length; i++){
                	if (formatCheck[0] != fix) {
						continue;
					} else {
						isRightFile = true;
						break;
					}
                }
                if (!isRightFile) {
					continue;
				}
                //临时存储路径
                String path = null; 
                //更新的文件名
                String newFileName = null;
                if(file != null){  
                    //取得当前上传文件的文件名称  
                    String myFileName = file.getOriginalFilename();  
                    //如果名称不为"",说明该文件存在，否则说明该文件不存在  
                    if(myFileName.trim() !=""){  
                        System.out.println(myFileName);  
                        //重命名上传后的文件名  
                        String fileName = file.getOriginalFilename();
                        
                        switch (file.getName()) {
        				case "file1":
        					newFileName = "科技查新报告";
        					break;
        				case "file2":
        					newFileName = "研制报告";
        					break;
        				case "file3":
        					newFileName = "背景材料";
        					break;
        				case "file4":
        					newFileName = "成果的审批文件";
        					break;
        				case "file5":
        					newFileName = "论文发表收录及引用证明";
        					break;
        				case "file6":
        					newFileName = "知识产权证明";
        					break;
        				case "file7":
        					newFileName = "推广应用产生的经济效益或者社会效益";
        					break;
        				case "file8":
        					newFileName = "奖项证明";
        					break;
        				case "file9":
        					newFileName = "著作证明";
        					break;
        				case "file10":
        					newFileName = "测试分析报告";
        					break;
        				case "file11":
        					newFileName = "主要实验";
        					break;
        				case "file12":
        					newFileName = "测试记录报告";
        					break;
        				case "file13":
        					newFileName = "产品检测报告";
        					break;
        				case "file14":
        					newFileName = "环境生态效益证明";
        					break;
        				default:
        					break;
        				}
                        System.out.println(file.getName());
                        //定义上传路径 
                        String dir = request.getSession().getServletContext().getRealPath("/WEB-INF/upload/" + loginname);
                        File fileDir = new File(dir);
                        if (!fileDir.exists() && !fileDir.isDirectory()) {
							fileDir.mkdirs();
						}
                        path = dir + File.separator + fileName;
                        System.out.println(path);
                        File localFile = new File(path);  
                        file.transferTo(localFile); 
                        //获取后缀名
                        String tempName = localFile.getName();
                        String prefix=tempName.substring(tempName.lastIndexOf(".")+1);
                        newFileName += "." + prefix;
                        localFile.renameTo(new File(dir + File.separator + newFileName));
                        System.out.println(dir + File.separator + newFileName);
                    }else{
                    	continue;
                    }
                }
                
                //记录上传该文件后的时间  
                int finaltime = (int) System.currentTimeMillis();  
                System.out.println(finaltime - pre);
                switch (file.getName()) {
				case "file1":
					tupload.setFile1(newFileName);
					break;
				case "file2":
					tupload.setFile2(newFileName);
					break;
				case "file3":
					tupload.setFile3(newFileName);
					break;
				case "file4":
					tupload.setFile4(newFileName);
					break;
				case "file5":
					tupload.setFile5(newFileName);
					break;
				case "file6":
					tupload.setFile6(newFileName);
					break;
				case "file7":
					tupload.setFile7(newFileName);
					break;
				case "file8":
					tupload.setFile8(newFileName);
					break;
				case "file9":
					tupload.setFile9(newFileName);
					break;
				case "file10":
					tupload.setFile10(newFileName);
					break;
				case "file11":
					tupload.setFile11(newFileName);
					break;
				case "file12":
					tupload.setFile12(newFileName);
					break;
				case "file13":
					tupload.setFile13(newFileName);
					break;
				case "file14":
					tupload.setFile14(newFileName);
					break;
				default:
					break;
				}
            } 
            Date nowTime = new Date(System.currentTimeMillis());
            SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String retStrFormatNowDate = sdFormatter.format(nowTime);
            tupload.setUploadtime(retStrFormatNowDate);
            if (tuploadService.getRows(Tupload.class, "loginname", loginname, "=") != 0) {
            	tuploadService.update(tupload);
			}else{
				tuploadService.save(tupload);
			}
        }  
        System.out.println(String.valueOf(System.currentTimeMillis()));
        //设置时间
        request.setAttribute("endtime", "2015-05-05 21:12:12");
        //
        Collection availableItems = null;
		availableItems = tuploadService.queryItems(Tupload.class, "loginname", loginname, "=", "id", 50, 0);
		Iterator patents = null;
		if(availableItems!=null)
		{
			patents = availableItems.iterator();
			while(patents.hasNext())
			{
				 Tupload upload = (Tupload)patents.next();
				 request.setAttribute("file1", StringProcess.getString(upload.getFile1()));
				 request.setAttribute("file2", StringProcess.getString(upload.getFile2()));
				 request.setAttribute("file3", StringProcess.getString(upload.getFile3()));
				 request.setAttribute("file4", StringProcess.getString(upload.getFile4()));
				 request.setAttribute("file5", StringProcess.getString(upload.getFile5()));
				 request.setAttribute("file6", StringProcess.getString(upload.getFile6()));
				 request.setAttribute("file7", StringProcess.getString(upload.getFile7()));
				 request.setAttribute("file8", StringProcess.getString(upload.getFile8()));
				 request.setAttribute("file9", StringProcess.getString(upload.getFile9()));
				 request.setAttribute("file10", StringProcess.getString(upload.getFile10()));
				 request.setAttribute("file11", StringProcess.getString(upload.getFile11()));
				 request.setAttribute("file12", StringProcess.getString(upload.getFile12()));
				 request.setAttribute("file13", StringProcess.getString(upload.getFile13()));
				 request.setAttribute("file14", StringProcess.getString(upload.getFile14()));
				 request.setAttribute("uploadtime", StringProcess.getString(upload.getUploadtime()));
			}
		}else{
			request.setAttribute("file1", StringProcess.getString(""));
			 request.setAttribute("file2", StringProcess.getString(""));
			 request.setAttribute("file3", StringProcess.getString(""));
			 request.setAttribute("file4", StringProcess.getString(""));
			 request.setAttribute("file5", StringProcess.getString(""));
			 request.setAttribute("file6", StringProcess.getString(""));
			 request.setAttribute("file7", StringProcess.getString(""));
			 request.setAttribute("file8", StringProcess.getString(""));
			 request.setAttribute("file9", StringProcess.getString(""));
			 request.setAttribute("file10", StringProcess.getString(""));
			 request.setAttribute("file11", StringProcess.getString(""));
			 request.setAttribute("file12", StringProcess.getString(""));
			 request.setAttribute("file13", StringProcess.getString(""));
			 request.setAttribute("file14", StringProcess.getString(""));
			 request.setAttribute("uploadtime", StringProcess.getString(""));
			 request.setAttribute("suggestion", StringProcess.getString(""));
		}
        return "unauth/manage/user-upload";
	}
	
	@RequestMapping("toupload")
	public String toupload(){
		return "unauth/manage/upload";
	}
	
	@RequestMapping({ "/template" })
	      public void downloadTemplate(HttpServletRequest request, HttpServletResponse response)
	              throws UnsupportedEncodingException {
	          String path = request.getSession().getServletContext().getRealPath("");
	          String filename = "模板文件.xls";
	          File file = new File(path +  "\\file\\templagte\\" + filename);
	         String userAgent = request.getHeader("User-Agent");
	         byte[] bytes = userAgent.contains("MSIE") ? filename.getBytes() : filename.getBytes("UTF-8"); // fileName.getBytes("UTF-8")处理safari的乱码问题
	         String fileName = new String(bytes, "ISO-8859-1"); 
	         // 设置输出的格式
	         response.setContentType("multipart/form-data");
	         response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
	         
	         InputStream inStream = null;
	         try {
	             inStream = new FileInputStream(file);
	             IOUtils.copy(inStream, response.getOutputStream());//使用commons-io组件进行文件流的处理
	         } catch (IOException e) {
	             e.printStackTrace();
	         }finally{
	             IOUtils.closeQuietly(inStream);
	         }
	}
	
	@RequestMapping("/download")
	public void download(HttpServletRequest request,
            HttpServletResponse response){
		String loginname = null;
		response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        try {
			HttpSession session = request.getSession();	
			loginname = session.getAttribute("loginname").toString();	
			System.out.println(loginname);
			if (loginname.equals(null)) {
			}
		} catch (Exception e) {
			System.out.println(e);
		}
        String fileName = request.getParameter("fileName");
        response.setHeader("Content-Disposition", "attachment;fileName="
                + fileName + ".zip");
        try {
           // String path = Thread.currentThread().getContextClassLoader()
           //         .getResource("").getPath()
           //         + "download";//这个download目录为啥建立在classes下的
        	String path = request.getSession().getServletContext().getRealPath("/WEB-INF/upload/");
            /*InputStream inputStream = new FileInputStream(new File(path
                    + File.separator + fileName));*/
        	path += File.separator + fileName;
        	File file = new File(path);
        	if (!file.exists()) {
				response.getWriter().write(0);
				return;
			}
        	ZipCompressor zc = new  ZipCompressor(path + ".zip");  
            zc.compressExe(path); 
        	InputStream inputStream = new FileInputStream(new File(path + ".zip"));
            System.out.println(path);
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
             // 这里主要关闭。
            os.close();
            inputStream.close();
            //下载成功
            response.getWriter().write(1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@RequestMapping("todownload")
	public String todownload(){
		return "unauth/manage/download";
	}
	
	/*
	 * 发送邮件
	 * author:chenming
	 * */
	@RequestMapping("sendEmail")
	public void sendEmail(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String loginname = null;
		try {
			HttpSession session = request.getSession();	
			loginname = session.getAttribute("loginname").toString();	
			System.out.println(loginname);
			if (loginname.equals(null)) {
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		String email = "cm8295@163.com";//request.getParameter("email");获取管理员邮箱
		String msg = null;
		try {
			msg=request.getParameter("msg");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//发送邮件
		mailSend mSend = new mailSend();
		if(msg==null){
			msg = "管理员，您好！\r\n\r\n\r\n\r\n"
					+ "有新提交的资料需要你查看。\r\n\r\n"
					+ loginname + ":\r\n\r\n";
		}
		if (mSend.sendMail(email, "系统邮件", msg)) {
			response.getWriter().append("1");   //状态：1:发送成功
		} else {
			response.getWriter().append("0");   //状态：0:发送失败
		}
		System.out.println("1"); 
	}
	
	/*
	 * 获取评审文件
	 * */
	@RequestMapping("/patentmanagement")
	public void patentmanagement(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Tupload> list = tuploadService.findAll(Tupload.class);
		int len = tuploadService.getRows(Tupload.class);
		String jsonStr = JSONUtil.listToJsonString(list, len);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/text");
		response.getWriter().write(jsonStr);
	}
	
	/*
	 * 成果转化应用评审任务
	 * 
	 * */
	@RequestMapping("/expert2")
	public String cgzhyyTask(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String loginname = null;
		try {
			HttpSession session = request.getSession();	
			loginname = session.getAttribute("loginname").toString();	
			System.out.println(loginname);
			if (loginname.equals(null)) {
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		//获取符合条件的行数
		ArrayList<String> fieldnameList=new ArrayList<String>();
		ArrayList<String> valueList=new ArrayList<String>();
		ArrayList<String> conditionList=new ArrayList<String>();
		fieldnameList.add("expert");
		fieldnameList.add("no");
		fieldnameList.add("state");
		valueList.add(loginname);
		valueList.add("1");
		valueList.add("0");
		conditionList.add("=");
		conditionList.add("=");
		conditionList.add("=");
		int num = tevaluationService.getRows(Tevaluation.class, fieldnameList, valueList, conditionList);
		List<Tevaluation> list = tevaluationService.queryItems(Tevaluation.class, fieldnameList, valueList, conditionList);
		String kkk = JSONUtil.listToJsonString(list,num);
		JSONObject jsonData = JSONObject.fromObject(kkk);
		request.setAttribute("jsonData", jsonData);
		return "unauth/manage/expert2";
	}
	
	/*
	 * 提交任务
	 * 
	 * */
	@RequestMapping("/subTask")
	public void subTask(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String loginname = null;
		try {
			HttpSession session = request.getSession();	
			loginname = session.getAttribute("loginname").toString();	
			System.out.println(loginname);
			if (loginname.equals(null)) {
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String jsonT = request.getParameter("jsonT");
		String no = request.getParameter("no");
		JSONObject jb = JSONObject.fromObject(jsonT);
	    JSONArray ja = jb.getJSONArray("rows");
	    Tevaluation tevaluation = new Tevaluation();
	    //System.out.println(Integer.valueOf(ja.getJSONObject(0).size()));
	    tevaluation.setUser(ja.getJSONObject(0).getString("user"));
	    //System.out.println(ja.getJSONObject(0).getString("item1"));
	    //tevaluation.setItem1(Integer.valueOf(ja.getJSONObject(0).getString("item1")).intValue());
	    if (!"".equals(ja.getJSONObject(0).getString("item1"))) {
	    	tevaluation.setItem1(ja.getJSONObject(0).getInt("item1"));
		}
		if (!"".equals(ja.getJSONObject(0).getString("item1"))) {
			tevaluation.setItem1(ja.getJSONObject(0).getInt("item1"));
		}
		if (!"".equals(ja.getJSONObject(0).getString("item2"))) {
			tevaluation.setItem2(ja.getJSONObject(0).getInt("item2"));
		}
		if (!"".equals(ja.getJSONObject(0).getString("item3"))) {
			tevaluation.setItem3(ja.getJSONObject(0).getInt("item3"));
		}
		if (!"".equals(ja.getJSONObject(0).getString("item4"))) {
			tevaluation.setItem4(ja.getJSONObject(0).getInt("item4"));
		}
		if (!"".equals(ja.getJSONObject(0).getString("item5"))) {
			tevaluation.setItem5(ja.getJSONObject(0).getInt("item5"));
		}
		if (!"".equals(ja.getJSONObject(0).getString("item6"))) {
			tevaluation.setItem6(ja.getJSONObject(0).getInt("item6"));
		}
		if (!"".equals(ja.getJSONObject(0).getString("item7"))) {
			tevaluation.setItem7(ja.getJSONObject(0).getInt("item7"));
		}
		if (!"".equals(ja.getJSONObject(0).getString("item8"))) {
			tevaluation.setItem8(ja.getJSONObject(0).getInt("item8"));
		}
		if (!"".equals(ja.getJSONObject(0).getString("item9"))) {
			tevaluation.setItem9(ja.getJSONObject(0).getInt("item9"));
		}
		if (!"".equals(ja.getJSONObject(0).getString("item10"))) {
			tevaluation.setItem10(ja.getJSONObject(0).getInt("item10"));
		}
		if (!"".equals(ja.getJSONObject(0).getString("item11"))) {
			tevaluation.setItem11(ja.getJSONObject(0).getInt("item11"));
		}
		if (!"".equals(ja.getJSONObject(0).getString("item12"))) {
			tevaluation.setItem12(ja.getJSONObject(0).getInt("item12"));
		}
		if (!"".equals(ja.getJSONObject(0).getString("item13"))) {
			tevaluation.setItem13(ja.getJSONObject(0).getInt("item13"));
		}
		if (!"".equals(ja.getJSONObject(0).getString("item14"))) {
			tevaluation.setItem14(ja.getJSONObject(0).getInt("item14"));
		}
		if (!"".equals(ja.getJSONObject(0).getString("item15"))) {
			tevaluation.setItem15(ja.getJSONObject(0).getInt("item15"));
		}
		if (!"".equals(ja.getJSONObject(0).getString("item16"))) {
			tevaluation.setItem16(ja.getJSONObject(0).getInt("item16"));
		}
		if (!"".equals(ja.getJSONObject(0).getString("item17"))) {
			tevaluation.setItem17(ja.getJSONObject(0).getInt("item17"));
		}
		if (!"".equals(ja.getJSONObject(0).getString("item18"))) {
			tevaluation.setItem18(ja.getJSONObject(0).getInt("item18"));
		}
		if (!"".equals(ja.getJSONObject(0).getString("item19"))) {
			tevaluation.setItem19(ja.getJSONObject(0).getInt("item19"));
		}
		if (!"".equals(ja.getJSONObject(0).getString("item20"))) {
			tevaluation.setItem20(ja.getJSONObject(0).getInt("item20"));
		}
		if (!"".equals(ja.getJSONObject(0).getString("item21"))) {
			tevaluation.setItem21(ja.getJSONObject(0).getInt("item21"));
		}
		if (!"".equals(ja.getJSONObject(0).getString("item22"))) {
			tevaluation.setItem22(ja.getJSONObject(0).getInt("item22"));
		}
	    tevaluation.setSuggestion(ja.getJSONObject(0).getString("suggestion"));
	    tevaluation.setTime(dateFormat.format(now));
	    tevaluation.setState(1);
	    tevaluation.setId(Integer.valueOf(no).intValue());
	    tevaluation.setExpert(loginname);
	    tevaluationService.update(tevaluation);
	    System.out.println(ja.getJSONObject(0).getString("user"));
	    response.getWriter().write("1");
	    
	}
		
	//测试
	@RequestMapping("/patentmanagement1")
	public void patentmanagement1(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String kkks = request.getParameter("name");
		List<Tupload> list = tuploadService.findAll(Tupload.class);
		int len = tuploadService.getRows(Tupload.class);
		String kkk = JSONUtil.listToJsonString(list, len);
		PrintWriter out=null;
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		//response.getWriter().write(kkk);
		//response.getWriter().write("{\"Area\"：[{\"AreaId\":\"123\"},{\"AreaId\":\"345\"}]}");
		try {
			out = response.getWriter();
			out.write(kkk);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//测试1,两个参数
	@RequestMapping(value="/userupload1")
	public String test(@RequestParam("param1") String param1,@RequestParam("param2") String param2,HttpServletRequest request){
		return "unauth/manage/user-upload"; 
	}
	
	/*
	 * 成果转化应用评审结果
	 * */
	@RequestMapping(value="/evluation1")
	public void evaluation1(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String loginname = null;
		try {
			HttpSession session = request.getSession();	
			loginname = session.getAttribute("loginname").toString();	
			if (loginname.equals(null)) {
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		//获取符合条件的行数
		ArrayList<String> fieldnameList=new ArrayList<String>();
		ArrayList<String> valueList=new ArrayList<String>();
		ArrayList<String> conditionList=new ArrayList<String>();
		fieldnameList.add("expert");
		fieldnameList.add("state");
		valueList.add(loginname);
		valueList.add("1");
		conditionList.add("=");
		conditionList.add("=");
		int num = tevaluationService.getRows(Tevaluation.class, fieldnameList, valueList, conditionList);
		List<Tevaluation> list = tevaluationService.queryItems(Tevaluation.class, fieldnameList, valueList, conditionList);
		String kkk = JSONUtil.listToJsonString(list,num);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/text");
		response.getWriter().write(kkk);
	}
	
	@RequestMapping(value="/toExpert")
	public String toExpert(HttpServletRequest request, HttpServletResponse response) throws IOException{
		return "unauth/manage/expert";
	}
	
	/*
	 * 资料提交时间设置
	 * author：chenming
	 * */
	@RequestMapping(value="/setTime")
	public void SetTime(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		System.out.println("setTime");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/text");
		response.getWriter().write("1");
	}
	
	/**
	 * 测试
	*/
	@RequestMapping(value="/getData")
	public String getData(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//获取符合条件的行数
		ArrayList<String> fieldnameList=new ArrayList<String>();
		ArrayList<String> valueList=new ArrayList<String>();
		ArrayList<String> conditionList=new ArrayList<String>();
		fieldnameList.add("expert");
		fieldnameList.add("no");
		valueList.add("expert1");
		valueList.add("1");
		conditionList.add("=");
		conditionList.add("=");
		int num = tevaluationService.getRows(Tevaluation.class, fieldnameList, valueList, conditionList);
		List<Tevaluation> list = tevaluationService.queryItems(Tevaluation.class, fieldnameList, valueList, conditionList);
		String kkk = JSONUtil.listToJsonString(list,num);
		JSONObject jsonData = JSONObject.fromObject(kkk);
		request.setAttribute("jsonData", jsonData);
		return "unauth/manage/expert-left";

	}
	
	/**
	 * 测试
	*/
	@RequestMapping(value="/togetData")
	public String togetData(HttpServletRequest request, HttpServletResponse response){
		return "unauth/manage/expert-left";
	}
}
