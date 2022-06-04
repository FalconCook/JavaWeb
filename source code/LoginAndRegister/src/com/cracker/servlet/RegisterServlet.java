package com.cracker.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户填写信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repwd = request.getParameter("repwd");
		String email = request.getParameter("email");
		
		//判断用户是否可以注册
		if(!"admin".equals(username)) {
			//注册成功 转发到成功页面
			request.getRequestDispatcher("success/register-success.html").forward(request, response);;
		}else {
			//重定向到失败页面
			response.sendRedirect("success/register-error.html");
		}
	}
}
