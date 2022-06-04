package com.cracker.cookie;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SessionServlet")
public class SessionServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取
		HttpSession session = request.getSession();
		//判断session是否是新创建的
		boolean new1 = session.isNew();
		//表示我这个session的唯一标识
		String id = session.getId();
		response.getWriter().write("已经获取到session对象..."+new1);
		response.getWriter().write("<br/>sessionId："+id);
	}
	
	protected void save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取session
		HttpSession session = request.getSession();
		//给session域中保存数据
		String string = UUID.randomUUID().toString().substring(0, 8);
		session.setAttribute("user", string);
		
		response.getWriter().write("session域中保存了数据："+string);
	}
	
	protected void getValue(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取session中的内容
		HttpSession session = request.getSession();
		String attribute = (String)session.getAttribute("user");
		response.getWriter().write("session域中取出的数据"+attribute);
	}
	
	protected void time(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取session
		HttpSession session = request.getSession();
		//获取session的最大存活时间 以秒为单位
		//session默认是30分钟，为什么开始新的会话会返回新的session
		//因为获取session根据cookie带来的jsessionid。浏览器关闭cookie就没了
		//再来获取session，返回新的session，旧的session还在。只是找不到
		int interval = session.getMaxInactiveInterval();
		response.getWriter().write("session存活时间："+interval);
	}
	
	protected void updatetime(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		//1、传入负数：代表永不过期
		//2、传入正数：代表多少秒后过期，距离最后一次使用session的时间
		session.setMaxInactiveInterval(3);
		response.getWriter().write("session将于3秒后过期");
	}
	
	protected void invalid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		//使session立即失效
		session.invalidate();
		response.getWriter().write("session已经失效");
	}
	
	protected void persist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//浏览器关闭也可以保持session，下次访问还能访问到之前的session
		//将jsessionid这个cookie持久化	 jsessionid=xxxxxx
		HttpSession session = request.getSession();
		String id = session.getId();
		Cookie cookie = new Cookie("JSESSIONID", id);
		//设置cookie的持久时间
		cookie.setMaxAge(60*60);
		response.addCookie(cookie);
		response.getWriter().write("session已经保持住了。。。");
	}
}
