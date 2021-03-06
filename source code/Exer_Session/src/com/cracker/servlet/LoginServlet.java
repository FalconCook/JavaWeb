package com.cracker.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		if("123456".equals(pwd)) {
			//登录成功，在首页，现实高级部分
			//将登陆好的用户放在session中
			HttpSession session = request.getSession();
			session.setAttribute("user", username);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else {
			//失败，普通部分
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
		
	}

}
