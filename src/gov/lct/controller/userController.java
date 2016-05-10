package gov.lct.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import gov.lct.model.Tuser;
import gov.lct.service.TuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import gov.lct.model.Trole;
import gov.lct.service.TroleService;

@Controller
@SessionAttributes("sess")
public class userController {

	private SolrServer solrServer;   
	private static final String DEFAULT_URL = "http://or.clas.ac.cn/solr/";  //solr ���ַ
	@Autowired
	private TuserService tuserService;
	@Autowired
	private TroleService troleService;
	
	@RequestMapping(value="/regist")
	public String regist(HttpServletRequest request, Model model) 
	{				
		Collection availableItems = null;
		availableItems = troleService.findAll(Trole.class);
        request.setAttribute("availableItems", availableItems);
		return "unauth/user/reg";
	}
	
	@RequestMapping(value="/insertuser")
	public String InsertUser(HttpServletRequest request, Model model) 
	{			
		Tuser userinfo = new Tuser();
	    ArrayList<String> fieldnameList=new ArrayList<String>();
		ArrayList<String> valueList=new ArrayList<String>();
		ArrayList<String> conditionList=new ArrayList<String>();
		//fieldnameList.add("loginname");
		fieldnameList.add("email");
		//valueList.add(request.getParameter("loginname"));
		valueList.add(request.getParameter("email"));
		conditionList.add("=");
		int totalRow = tuserService.getRows(Tuser.class, fieldnameList, valueList, conditionList);
		if(totalRow==0)
		{			  
	      userinfo.setLoginname(request.getParameter("loginname"));
	      userinfo.setPassword(DigestUtils.md5Hex(request.getParameter("passwd")));
		  String institute = request.getParameter("institute");
		  Date currentTime = new Date();
		  java.sql.Date regtime = new java.sql.Date(currentTime.getTime());
		
	      userinfo.setRealname(request.getParameter("realname"));
	      userinfo.setEmail(request.getParameter("email"));
	      userinfo.setInstitute(institute);
	      userinfo.setRegdate(regtime);
	      
	      String[] roletype = request.getParameterValues("role");
	      String roleinfo = "";
	      if(roletype!=null)
	      {
	    	 for(int i=0; i<roletype.length; i++)
	    	 {
	    	   if(i==0)	 
	    	     roleinfo = roletype[i] + ";";
	    	   else
	    		 roleinfo = roleinfo + roletype[i] + ";";  
	    	 }
	      }
	      System.out.println(roleinfo);
	      userinfo.setRole(roleinfo);
	      tuserService.save(userinfo);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "该用户已经存在");
		}
		
		Collection availableItems = null;
		availableItems = troleService.findAll(Trole.class);
        request.setAttribute("availableItems", availableItems);
		return "unauth/user/reg";
	}	
	
	@RequestMapping(value="/login")
	public String Login(HttpServletRequest request, Model model) 
	{	
		String error = "false";
		request.setAttribute("error", error);		
		return "unauth/user/login";
	}
	
	@RequestMapping(value="/logincheck")
	public String LoginCheck(HttpServletRequest request, HttpServletResponse response) 
	{	
		HttpSession session = request.getSession();	
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		String loginname = null;
		String realname = null;
		List<Tuser> Luser = null;
		
	    ArrayList<String> fieldnameList=new ArrayList<String>();
		ArrayList<String> valueList=new ArrayList<String>();
		ArrayList<String> conditionList=new ArrayList<String>();
		fieldnameList.add("loginname");
		valueList.add(request.getParameter("loginname"));
		conditionList.add("=");
		fieldnameList.add("password");
		valueList.add(DigestUtils.md5Hex(request.getParameter("passwd")));
		conditionList.add("=");
		
		int totalRow = tuserService.getRows(Tuser.class, fieldnameList, valueList, conditionList);
		if(totalRow==0)
		{		     	
		   JOptionPane.showMessageDialog(null, "用户名密码错误！");
		   request.setAttribute("error", "false");
		   return "unauth/user/login";
		}
		else
		{
			Luser = new ArrayList<Tuser>(); 
			Luser = tuserService.queryItems(Tuser.class, fieldnameList, valueList, conditionList);
			session.setAttribute("institute", Luser.get(0).getInstitute());
			session.setAttribute("realname", Luser.get(0).getRealname());
			session.setAttribute("email", Luser.get(0).getEmail());
		    session.setAttribute("loginname", request.getParameter("loginname"));
			realname = session.getAttribute("realname").toString();
			loginname = session.getAttribute("loginname").toString();
//		    if(Luser.get(0).getRole().equals("000"))
//		       return AdminInit(request, session);	
//		    else
//		       return UserInit(request, session);	
		}
		
		return "redirect:/manage/index";
	}
	
}