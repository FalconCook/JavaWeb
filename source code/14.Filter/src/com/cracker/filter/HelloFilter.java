package com.cracker.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 创建的Filter的实现类
 * 是来过滤所有要访问美女页面的请求
 * 服务端的三大组件，运行在服务器上，服务器调用。配置
 * 1、写一个实现
 * 2、在服务器配置filter要过滤哪些请求。web.xml
 * @author chen
 *
 * 服务器管理的filter，生命周期
 * 从创建到销毁的过程
 * 1、创建-初始化
 * 		服务器一启动，加载项目进服务器，创建Filter对象，并执行初始化。单例多线程
 * 2、每次拦截都执行
 * 		doFilter方法。。。
 * 3、销毁：
 * 		项目从服务器中卸载（destroy）
 */
public class HelloFilter implements Filter{

	
	public HelloFilter() {
		super();
		System.out.println("我是HelloFilter的构造器...");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("我是filter的初始化方法...init()...");
	}

	/**
	 * 执行过滤
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("我是filter的doFilter方法...doFilter()...");
		String money = request.getParameter("money");
		if(money!=null) {
			//带钱了，让他访问美女页面
			//请求放行
			System.out.println("我是请求放行之前...1");
			chain.doFilter(request, response);
			System.out.println("我是请求放行之后...3");
			response.getWriter().write("helloFilter。。。");
		}else {
			//没带钱，提示你回家要钱去
			response.getWriter().write("no money,no mm!");
		}
	}

	@Override
	public void destroy() {
		System.out.println("我是filter的销毁方法...destroy()...");
	}

}
