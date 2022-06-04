package com.cracker.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class ListStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListStudentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//查出所有学生数据
		List<Student> list = new ArrayList<Student>();
		list.add(new Student(1, "小明", "男", "一年级", new Date()));
		list.add(new Student(2, "小红", "女", "一年级", new Date()));
		list.add(new Student(3, "小红2", "女", "一年级", new Date()));
		list.add(new Student(4, "小红3", "女", "一年级", new Date()));
		list.add(new Student(5, "小红4", "女", "一年级", new Date()));
		list.add(new Student(6, "小明2", "男", "一年级", new Date()));
		
		//能用小的域对象就用小的，把数据放在request域中
		request.setAttribute("list", list);
		//转发到页面
		request.getRequestDispatcher("/WEB-INF/list.jsp").forward(request, response);
	}

}
