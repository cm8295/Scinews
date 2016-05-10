package gov.lct.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class SqlInjectIntercepter extends HandlerInterceptorAdapter {

	public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object arg2, Exception arg3)
            throws Exception {

    }

     //控制器执行完，生成视图之前可以做的动作，向模型中添加公共成员
    public void postHandle(HttpServletRequest request, HttpServletResponse response,

            Object handler, ModelAndView modelAndView) throws Exception {

    }

    //拦截之前执行的方法
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    	Enumeration<String> names = request.getParameterNames();
    	  while (names.hasMoreElements()) 
    	  {
    	    String name = names.nextElement();
    	    String[] values = request.getParameterValues(name);
    	    for (int i = 0; i < values.length; i++) 
    	    {
    	      boolean torf = hasAttackStr(values[i],name);	
    	      if(torf)
    	      {
    	        response.setContentType("text/html;charset=utf-8");
    	        response.getWriter().print("请不要尝试注入<br>");
    	        return false;
    	      }
    	    }
    	  }
    	  return true;
    }

    
    private boolean hasAttackStr(String value, String name){
    	
    	String attackstr="frame‖<>‖\\‖src=‖</input>‖</script>‖<script>‖alert‖iframe‖cookie‖javascript‖<body>‖%27‖%23‖%6F‖%4F‖%72‖%52‖delete‖ update‖declare‖master‖chr‖truncate‖select‖update‖delete‖%20from‖insert‖master‖chr(37)‖chr(10)‖chr(13)‖=‖\'‖%‖&‖*‖#‖'‖$‖|‖;‖<‖>‖\"‖+";
    	String attackarray[] = attackstr.split("‖");
    	//for(int i=0; i<attackarray.length; i++)
    		//System.out.println("attackarray["+i+"]>>>>" + attackarray[i]);
    	for(int i=0; i<attackarray.length; i++)
    	{
    	  if(!(value.toLowerCase().trim().equals("conferencealert")))
    	  {
    	    if(value.toLowerCase().trim().indexOf(attackarray[i])!=-1)
    	    {
    		  System.out.println(name + " is equals >>>>>" + value);
    		  System.out.println("attackarray is >>>>>" + attackarray[i]);
    		  System.out.println("");
    		  return true;
    	    }
    	  }
    	}
		return false;    	
    }
	 
	}
