package com.cracker.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PathServlet
 */
public class PathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//转发到a页面
        //相对路径:相对与当前资源的路径
        //经常可能产生一些问题,转发会导致相对路径出现问题
        //req.getRequestDispatcher("pages/a.html").forward(req,resp);
		//resp.sendRedirect("pages/a.html");
        //绝对路径:以/开如 代表的是项目的根目录 http://localhost:8080/08.Servlet
		//http://localhost:8080/08.Servlet/pages/a.html
		
		//1、转发我们以后也使用绝对路径来写，/   表示从项目的根目录开始
        //req.getRequestDispatcher("/index.html").forward(req,resp);
        
		//2. 重定向也可以写绝对路径 / tomcat的根目录-服务器的根 http://localhost:8080开始
		//动态获取项目的根目录
		ServletContext servletContext = getServletContext();
        String path = servletContext.getContextPath();
        
        String path2 = req.getContextPath();
        System.out.println("request-->"+path2);
		System.out.println(path);
        //resp.sendRedirect(req.getContextPath() + "/pages/a.html");
		req.getRequestDispatcher("/pages/a.html").forward(req,resp);
	}

	
}
