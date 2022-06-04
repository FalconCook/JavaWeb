package com.cracker.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cracker.bean.User;
import com.cracker.service.UserService;
import com.cracker.service.impl.UserServiceImpl;


/**
 * 处理用户登录的Servlet
 * @author
 *
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//创建一个UserService
	private UserService us = new UserServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取用户填写用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
				
		//调用Service验证用户名和密码
		User user = us.login(new User(null, username, password, null));
		
		//如果loginUser为null，用户名或密码错误，转发到login.html
		if(user == null){
			//登录失败，转发到登录页面
			request.setAttribute("msg", "用户名密码错误");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}else{
			//用户名和密码正确登录成功,重定向到login-success.html
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success.jsp");
		}
		
	}

}
