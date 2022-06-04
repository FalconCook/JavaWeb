package com.cracker.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cracker.bean.User;
import com.cracker.service.UserService;
import com.cracker.service.impl.UserServiceImpl;
import com.cracker.utils.WebUtils;

import jdk.nashorn.internal.ir.RuntimeNode.Request;


/**
 * 处理用户相关请求的Servlet
 * 抽取出BaseServlet以后
 * UserServlet里面只需要编写相应的处理逻辑即可
 * @author 
 */
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
	
	private UserService us = new UserServiceImpl();
	private static final long serialVersionUID = 1L;
	
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户填写用户名、密码、电子邮件
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		User user = WebUtils.param2bean(request, new User());
		
		//用户注册
		boolean b = us.regist(user);
		
		if(b){
			//注册成功，重定向到成功页面
			response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.jsp");
		}else{
			//注册失败 返回注册页面，转发
			request.setAttribute("msg", "用户已存在");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
			
		}
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取用户填写用户名和密码
		//String username = request.getParameter("username");
		//String password = request.getParameter("password");
		User user2 = WebUtils.param2bean2(request, new User());
		//调用Service验证用户名和密码
		User user = us.login(user2);
		
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
