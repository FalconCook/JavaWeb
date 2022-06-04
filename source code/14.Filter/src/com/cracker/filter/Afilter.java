package com.cracker.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class Afilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//filterConfig是用来封装filter配置信息的对象
		String filterName = filterConfig.getFilterName();//filter别名
		//filter初始化参数
		String filterinitParameter = filterConfig.getInitParameter("username");
		//对应我们的web应用
		ServletContext servletContext = filterConfig.getServletContext();
		//获取web初始化参数
		String initParameter = servletContext.getInitParameter("user");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/*HttpServletRequest req = (HttpServletRequest)request;
		String uri = req.getRequestURI();
		StringBuffer url = req.getRequestURL();
		System.out.println("过来的请求uri："+uri);
		System.out.println("过来的请求url："+url.toString());
		if(uri.endsWith("jsp")) {
			System.out.println("jsp结尾，拦截");
		}else {
			chain.doFilter(request, response);
		}*/
		//预处理
		//响应乱码怎么解决的，一定在response写东西之前设置
		//response.setContentType("text/html;charset=utf-8");
		//response.getWriter().write("你好");//坏的
		//chain就是用来放行请求，只要不显示的调用放行方法，请求就不会被放行
		System.out.println("我是aFilter...1");
		chain.doFilter(request, response);
		System.out.println("我是aFilter...2");
		//response.getWriter().write("你好");//好的
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
