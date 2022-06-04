package com.cracker.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		if(username!=null && pwd!=null) {
			//登陆成功
			Cookie cookie = new Cookie("username", username);
			cookie.setMaxAge(60*60*24*7);
			response.addCookie(cookie);
			response.sendRedirect(request.getContextPath()+"/success.jsp");
		}
	}

}
