package gov.lct.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Albert Lau email: albertlau84@gmail.com
 * @date 2012-6-2
 */
public class CodeFilter extends HttpServlet implements Filter {

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String code = request.getParameter("captcha");
		if(request.getParameter("j_username") == null || request.getParameter("j_username").trim().equals("")){
			response.sendRedirect("logon.html?error=name");
			return;
		}
		if(request.getParameter("j_password") == null || request.getParameter("j_password").trim().equals("")){
			response.sendRedirect("logon.html?error=psw");
			return;
		}
		Cookie[] cookie = request.getCookies();
		String codes = "";
		for (int i = 0; cookie != null && i < cookie.length; i++) {
			if ("codes".equals(cookie[i].getName())) {
				codes = cookie[i].getValue();
			}
		}
//		System.out.println(codes);
//		System.out.println(code);
		if (!"".equals(codes) && codes != null) {
			if (code.equalsIgnoreCase(codes)) {
				filterChain.doFilter(request, response);
			} else {
				response.sendRedirect("logon.html?error=captcha");
				return;
			}
		} else {
			response.sendRedirect("logon.html?error=captcha");
			return;
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
