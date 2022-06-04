package com.cracker.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/JQueryGetServlet")
public class JQueryGetServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void getUrlParam(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = new Student("张三", 20);
		Gson gson = new Gson();
		//将student对象转成json字符串
		String json = gson.toJson(student);
		response.getWriter().write(json);
	}
	
	protected void getUrlData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从请求的数据中获取学生名和学生年龄
		String stuName = request.getParameter("name");
		String stuAge = request.getParameter("age");
		System.out.println("获取到的学生名："+stuName);
		System.out.println("获取到的学生年龄："+stuAge);
		Student student = new Student(stuName, Integer.parseInt(stuAge));
		Gson gson = new Gson();
		//将student对象转成json字符串
		String json = gson.toJson(student);
		response.getWriter().write(json);
	}
}
