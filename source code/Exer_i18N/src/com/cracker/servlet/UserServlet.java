package com.cracker.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cracker.bean.User;

@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
      
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取用户对象
		String username = request.getParameter("username");
		User user = new User(username);
		//放进域中
		request.getSession().setAttribute("user", user);
		//重定向
		response.sendRedirect("index.jsp");
	}
	
	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取用户对象
		String username = request.getParameter("username");
		User user = new User(username);
		//放进域中
		request.getServletContext().setAttribute("user", user);
		//重定向
		response.sendRedirect("index.jsp");
	}
}
