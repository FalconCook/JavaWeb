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
import javax.servlet.http.HttpSession;

import com.cracker.bean.User;
import com.cracker.service.UserService;
import com.cracker.service.impl.UserServiceImpl;
import com.cracker.utils.WebUtils;
import com.google.code.kaptcha.Constants;

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
		//获取用户输入的验证码，获取session中的验证码
		//页面的验证码
		String code = request.getParameter("code");
		HttpSession session = request.getSession();
		String sessionCode = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		System.out.println("页面的验证码："+code);
		System.out.println("session中的验证码："+sessionCode);
		//如果验证码一致则注册，否则回到注册页面并提示验证码错误
		if(!sessionCode.equals(code)){
			request.setAttribute("msg", "验证码错误");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
			return;
		}
		
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
		
		User user2 = WebUtils.param2bean2(request, new User());
		//用户登陆，用户详情
		User user = us.login(user2);
		System.out.println(user);
		//将用户保存到session中
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		if(user == null){
			//登录失败，转发到登录页面
			request.setAttribute("msg", "用户名密码错误");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}else{
			//用户名和密码正确登录成功,重定向到login-success.html
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success.jsp");
		}
		
	}
	
	/**
	 * 用户登出操作
	 */
	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		//销毁session即可
		session.invalidate();
		//点击登出返回首页
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
	
	/**
	 * 检查用户是否可用
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void checkuser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//页面应该把用户名传过来 key应该是username
		User user = WebUtils.param2bean2(request, new User());
		
		//检查用户是否可用
		boolean b = us.checkuser(user);
		
		if(b) {
			//可以注册，写数据就是给客户端响应
			response.getWriter().write("用户名可用");
		}else {
			//不可以注册
			response.getWriter().write("用户已存在");
			
		}
	}
}
