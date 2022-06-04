package com.cracker.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EncodingServlet")
public class EncodingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//在第一次操作response之前，设置好内容类型和字符编码
		//告诉浏览器我传输的数据的内容类型
		//第一种方式
		//response.setContentType("text/html");
		//告诉浏览器编码
		//response.setCharacterEncoding("utf-8");
		
		//第二种方式，直接设置响应头
		//response.setHeader("Content-Type","text/html;charset=utf-8");
		
		//第三种方式，设置Content-type字段的值
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.write("请求成功！");
		
		//字符乱码存在与以下地方
		//1）、响应给浏览器的数据是乱码
		//		原因：是浏览器不知道数据的类型及编码格式
		//		解决：告诉浏览器内容类型及编码格式。在响应头里"Content-Type","text/html;charset=utf-8"
		//		方法：推荐第三种
	}

}
