package gov.lct.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.solr.client.solrj.SolrServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import gov.lct.model.Tip;
import gov.lct.service.TipService;
import gov.lct.util.PropUtil;

@Controller
@SessionAttributes("session")
public class ipexchangeController {
	@Autowired	
	private TipService tipService;	
	
	@RequestMapping(value = "/ipexchangeform")  
	public String ExpertInstdisplay(HttpServletRequest request, HttpSession session) {
		
      String username = (String)session.getAttribute("loginname");
      String email = (String)session.getAttribute("email");
	  if(username==null)
	  {
         request.setAttribute("from", "ipform");
		 return "unauth/user/login";
	  }
	  else
	  {		  
         System.out.println(username);
         System.out.println(email);                 
		 return "unauth/ipexchange/form";
	  }
	}
		
	@RequestMapping(value="/iprequestadd")
	public String InserTip(HttpServletRequest request, Model model) 
	{			
		Tip ip = new Tip();
	      ip.setTitle(request.getParameter("title"));
	      ip.setClient(request.getParameter("client"));
	      ip.setAgent(request.getParameter("agent"));
	      ip.setPerson(request.getParameter("person"));
	      ip.setEmail(request.getParameter("email"));
	      ip.setTelephone(request.getParameter("telephone"));
	      ip.setRequest(request.getParameter("request"));

		  Date currentTime = new Date();
		  java.sql.Date delievedate = new java.sql.Date(currentTime.getTime());		
	      ip.setDeliverdate(delievedate);
	      	      
		  //处理上传的文件
          String path="",storepath="";          
	      CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
	      if(multipartResolver.isMultipart(request))
	      {
             MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
             Iterator iter=multiRequest.getFileNames();
	         Date date=new Date();
	         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");     
	         String datestr=format.format(date);
	            
	         while(iter.hasNext())
	         {
	             //一次遍历所有文件
	           	String uploadname = iter.next().toString();
	            MultipartFile file=multiRequest.getFile(uploadname);
	           	String initfilename = file.getOriginalFilename();
	                
	            if(file!=null && (initfilename.indexOf(".doc")!=-1 || initfilename.indexOf(".docx")!=-1) || initfilename.indexOf(".pdf")!=-1 || initfilename.indexOf(".xls")!=-1 || initfilename.indexOf(".xlsx")!=-1 || initfilename.indexOf(".doc")!=-1 || initfilename.indexOf(".docx")!=-1 || initfilename.indexOf(".PDF")!=-1 || initfilename.indexOf(".XLS")!=-1 || initfilename.indexOf(".XLSX")!=-1)
	            {
	               storepath = "(" + datestr + ")" + initfilename;
	               System.out.println(storepath);
	               if(uploadname.equals("attachment"))
	            	   ip.setAttachment(storepath);	  
	                	
				   try 
				   {
						path = PropUtil.getParseKey("sysconfig", "File.Upload.Dir") + "/" + storepath;						
						file.transferTo(new File(path));
					} catch (UnsupportedEncodingException e) {								
								e.printStackTrace();
					} catch (IllegalStateException e) {								
								e.printStackTrace();
					} catch (IOException e) {								
								e.printStackTrace();
					}	                    
	              }	
	            else
	            {
	               JOptionPane.showMessageDialog(null, "系统只支持WORD、PDF、EXCEL文件的上传");
	               return "unauth/ipexchange/form";
	            }
             }	           
         }
	      
	      ip.setStatus("0");
	      tipService.save(ip);
	      
		return "unauth/user/reg";
	}	
	
	
	}
