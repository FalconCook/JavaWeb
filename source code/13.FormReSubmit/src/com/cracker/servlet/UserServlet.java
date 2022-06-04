package com.cracker.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		//在servlet中应该有一个一模一样的令牌，这样每次提交上来的数据会带上令牌，
		//服务器验证和我本地令牌是否一致
		HttpSession session = req.getSession();
		//从session中获取令牌，服务器从session中取出的令牌
		String token = (String)session.getAttribute("token");
		//再从页面取出令牌对照一下
		String pageToken = req.getParameter("token");
		
		System.out.println("服务器的令牌："+token);
		System.out.println("页面带过来的令牌："+pageToken);
		
		//如果在这里把session中的令牌变化，直接将服务器中的令牌移除。第二次请求过来，服务器中的token没值，页面会带来缓存的token
		session.removeAttribute("token");
		
		//对照令牌，如果一致，提交请求，否则不提交
		if(pageToken.equals(token)) {
			//获取用户名
			String username = req.getParameter("username");
			//保存数据
			System.out.println(username+"已经保存到数据库");
			//转发发到页面
			req.getRequestDispatcher("/success.jsp").forward(req, resp);
			//resp.sendRedirect(req.getContextPath()+"/success.jsp");
		}else {
			resp.sendRedirect(req.getContextPath()+"/error.jsp");
		}
	}
}
