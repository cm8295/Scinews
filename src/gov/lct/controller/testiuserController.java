package gov.lct.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import gov.lct.model.Trole;
import gov.lct.model.Tuser;
import gov.lct.service.TroleService;
import gov.lct.service.TuserService;

@Controller
public class testiuserController {
	@Autowired
	private TuserService tuserService;
	@Autowired
	private TroleService troleService;
	@RequestMapping(value="/iuser")
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

}
