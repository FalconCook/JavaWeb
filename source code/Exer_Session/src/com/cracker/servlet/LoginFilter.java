package com.cracker.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//判断用户是否登陆，如果登陆，放行请求。否则，回到登陆页面
		HttpServletRequest req = (HttpServletRequest) request;
		//获取到session
		HttpSession session = req.getSession();
		
		String user = (String) session.getAttribute("user");
		if(user==null) {
			//用户未登录，返回index.jsp页面
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.sendRedirect(req.getContextPath()+"/index.jsp");
		}else {
			//用户已登录，放行请求
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		
	}

}
