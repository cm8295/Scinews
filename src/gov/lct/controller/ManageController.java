package gov.lct.controller;

import gov.lct.model.Trole;
import gov.lct.service.TroleService;
import gov.lct.model.Trequire;
import gov.lct.service.TrequireService;
import gov.lct.model.Tpatentbasicinfo;
import gov.lct.service.TpatentbasicinfoService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping(value="/usermenu")
	public String userMenu(HttpServletRequest request) throws Exception{
		return "unauth/manage/user-menu";
	}
	
	@RequestMapping(value="/userleft")
	public String userLeft(HttpServletRequest request) throws Exception {	
        return "unauth/manage/user-left";
	}
	
	@RequestMapping(value="/userState")
	public String userState(HttpServletRequest request) throws Exception {	
        return "unauth/manage/user-state";
	}
	
	@RequestMapping(value="/pageUpload")
	public String pageUpload(HttpServletRequest request) throws Exception{

		return "unauth/manage/upload";
	}
	
}
