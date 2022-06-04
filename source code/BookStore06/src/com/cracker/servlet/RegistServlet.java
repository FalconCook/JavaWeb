package com.cracker.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cracker.bean.User;
import com.cracker.service.UserService;
import com.cracker.service.impl.UserServiceImpl;
/**
 * 处理用注册功能的Servlet
 * @author
 *
 */
@WebServlet("/user/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//创建一个UserService
	private UserService userService = new UserServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户填写用户名、密码、电子邮件
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		//封装User对象
		User user = new User(null, username, password, email);
		
		//调用Service将User插入进数据库
		boolean b = userService.regist(user);
		
		//注册成功，重定向到regist_success.html
		if(b){
			response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.jsp");
		}else{
			//注册失败 返回注册页面，转发
			request.setAttribute("msg", "用户已存在");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
			
		}
	}

}
