package gov.lct.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("demo1")
public class test {
	
	@RequestMapping("/test1")
	public String test1(HttpServletRequest request) throws Exception {
		System.err.println("nihao");
		return "/index";
	}
	
	@RequestMapping("/test11")
	public String test11(){
		System.err.println("nihao");
		return "/index";
	}

}
