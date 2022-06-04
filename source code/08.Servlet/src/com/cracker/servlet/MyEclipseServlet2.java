package com.cracker.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { "/MyEclipseServlet2" }, 
		initParams = { 
				@WebInitParam(name = "username", value = "chen")
		})
public class MyEclipseServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MyEclipseServlet2() {
        super();
        System.out.println("我是构造器。。。");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 就是用来处理get请求。get是一种请求方式。
	 * 
	 * post目前就只有一种：表单提交的时候指定method="post"
	 * 回车，超链接，img src="图片路径" ......都是get请求
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//正常不区分请求方式
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // HttpServletRequest request 代表浏览器发送给服务器的请求信息
        // http请求 请求首行  空行  请求体(封装的请求数据)
        // get将所有的参数放在url后
        // 1、获取请求数据，get放在url后面，post放在请求体中。
        String username = request.getParameter("username");
        System.out.println("username = " + username);
        //String aihao = request.getParameter("aihao");

        //使用getParameterValues多选框的内容
        String[] aihao = request.getParameterValues("aihao");
        if(aihao!=null) {
        	for(String string : aihao) {
            	System.out.println(string);
            }
        }
        System.out.println("爱好：" + aihao);

        // 2、获取请求头信息
        String userAgent = request.getHeader("User-Agent");
        System.out.println("userAgent = " + userAgent);
        
        // 3、转发一个页面、资源
        // 先获取一个请求转发器
        RequestDispatcher dispatcher = request.getRequestDispatcher("success.html");
        // 将请求转发出去
        dispatcher.forward(request, response);

        // 4、作为域对象共享数据	4个application	request
	}

}
