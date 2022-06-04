package com.cracker.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieServlet")
public class CookieServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * 创建cookie
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//服务器创建一个cookie
		Cookie cookie = new Cookie("username", "chen");
		Cookie cookie2 = new Cookie("pwd", "123456");
		//把cookie发给浏览器
		response.addCookie(cookie);
		response.addCookie(cookie2);
		
		response.getWriter().write("cookie发给你了。。。");
	}
	
	/**
	 * 获取cookie
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从请求头里获取到所有的cookie
		Cookie[] cookies = request.getCookies();
		
		//遍历取出cookie的key和value	一个cookie就是一个key-value
		for (Cookie cookie : cookies) {
			//取出cookie的名字
			String name = cookie.getName();
			//取出cookie的值
			String value = cookie.getValue();
			response.getWriter().write("cookie的name："+name+"<br/>");
			response.getWriter().write("cookie的value："+value+"<br/>");
		}
	}
	
	/**
	 * 删除某个cookie
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取所有cookie
		Cookie[] cookies = request.getCookies();
		//拿到要删除的cookie
		Cookie cookie = null;
		for (Cookie c : cookies) {
			//判断是否为要删除的cookie
			if("username".equals(c.getName())) {
				cookie = c;
			}
		}
		
		//负数 不保存cookie 即使发给浏览器也不保存
		//正数 cookie的最大存在时间		秒
		//0表示删除cookie
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		response.getWriter().write("cookie已经删除。。。");
	}


	protected void persist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取所有cookie
		Cookie[] cookies = request.getCookies();
		//拿到要删除的cookie
		Cookie cookie = null;
		for (Cookie c : cookies) {
			//判断是否为要删除的cookie
			if("username".equals(c.getName())) {
				cookie = c;
			}
		}
		//修改cookie的存活时间
		cookie.setMaxAge(60*60);
		
		//发给浏览器
		response.addCookie(cookie);
		response.getWriter().write("cookie存活一个小时");
	}
	
	//设置一个不保存的cookie
	protected void unsave(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cookie = new Cookie("cardid", "1234567");
		cookie.setMaxAge(-100);
		response.addCookie(cookie);
		response.getWriter().write("给你返回一个cookie，看看有没有");
	}
	
	/**
	 * 为cookie设置路径
	 */
	protected void setpath(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//cookie创建完成
		Cookie cookie = new Cookie("mycookie", "222");
		//表示访问hello下的资源会被带上
		//告诉浏览器访问哪些路径带上此cookie
		cookie.setPath("/hello");
		//默认访问当前项目下所有资源都会携带
		response.addCookie(cookie);
		response.getWriter().write("cookie的路径修改了。。。");
	}
	
	/**
	 * 修改cookie
	 */
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//创建一个同名cookie即可
		Cookie cookie = new Cookie("username", "phx");
		//浏览器就会将同名cookie覆盖
		response.addCookie(cookie);
		response.getWriter().write("cookie已经修改");
	}
}
