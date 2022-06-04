package com.cracker.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { "/MyServlet2" }, 
		initParams = { 
				@WebInitParam(name = "username", value = "chen")
		})
public class MyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyServlet2() {
        super();
        System.out.println("我是构造器。。。");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//写代码
		//经过MyEclipseServlet3处理后，获取请求头信息，在控制台打印
		String header = request.getHeader("User-Agent");
		System.out.println("用户浏览器信息："+header);
		//返回success.html页面，只能取一个
		//1.重定向到页面，就是告诉浏览器重新请求一个资源
		//http://localhost:8080/08.Servlet/success.html
		//http://localhost:8080/08.Servlet/MyServlet2
		//response.sendRedirect("success.html");
		
		//2.转发到页面
		//转发：服务器处理完成以后转交到另外一个资源。当我们转发的资源是一个页面资源
		//（静态资源），服务器会给浏览器返回这个资源
		//当转交给下一个servlet的时候，可以继续处理，直到最后一个servlet完成响应
		request.getRequestDispatcher("pages/success.html").forward(request, response);
	
		//3、转发和重定向的区别
		
	}
}
