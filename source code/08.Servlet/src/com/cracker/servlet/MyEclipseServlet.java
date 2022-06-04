package com.cracker.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HttpServlet专门为处理Http请求定制的Servlet	web应用
 */
@WebServlet(
		urlPatterns = { "/MyEclipseServlet" }, 
		initParams = { 
				@WebInitParam(name = "username", value = "chen")
		})
public class MyEclipseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyEclipseServlet() {
        super();
        System.out.println("我是构造器。。。");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 就是用来处理get请求。get是一种请求方式。
	 * 
	 * post目前就只有一种：表单提交的时候指定method="post"
	 * 回车，超链接，img src="图片路径" ......都是get请求
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//正常不区分请求方式
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HttpServletRequest request 代表的是封装浏览器请求信息对象，收到的浏览器的请求
        // HttpServletResponse response 代表就是要发送给浏览器的响应对象，封装我们的响应信息
        
		//一个请求对应一个响应
		// 1、可以给浏览器响应字符串
		//response.getWriter().println("Hello HttpServlet....");

        // 2、可以重定向到一个页面或者其他资源，重定向就是服务器告诉浏览器重新请求别的资源
		// 已经对之前的request响应完了。
		response.sendRedirect("success.html");
		
	}

}
