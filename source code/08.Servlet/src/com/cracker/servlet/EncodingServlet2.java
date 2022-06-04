package com.cracker.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EncodingServlet2")
public class EncodingServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//当我们在表达中填写中文的时候获取到也是乱码
		//1、post乱码原因
		//浏览器将数据编码并提交上来，但是服务器并不知道编码规则
		//解决方法：让服务器知道编码规则即可,重新设置请求的编码格式
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		System.out.println(username);
		
		//1、get乱码
		//原因：浏览器将地址栏也编码，服务器不知道，而且8080端口接收url请求后，按照默认的解码方法解码
		//所以request.setCharacterEncoding("utf-8");没用
		//解决办法：修改tomcat的server.xml配置文件 在8080端口配置处添加URIEncoding="utf-8"
		
	}

}
