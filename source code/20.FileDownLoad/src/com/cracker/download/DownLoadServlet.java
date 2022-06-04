package com.cracker.download;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.util.URLEncoder;
import org.apache.commons.io.IOUtils;

@WebServlet("/DownLoadServlet")
public class DownLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//本质就是告诉浏览器我给你的资源不能直接打开，给我下载
		
		//把要下载的资源的流传给浏览器
		//1、设置响应的文件类型	，文件是什么类型就设置什么类型
		//response.setContentType("");
		//获取要下载资源的文件类型
		String mimeType = getServletContext().getMimeType("/62566.jpg");
		System.out.println("要下载的文件类型："+mimeType);
		//2、设置资源的处理方式，设置处理方式响应头
		String encode = new URLEncoder().encode("你好.jpg");
		//第一个参数就是文件名的字节数组,
		String string = new String("你好.jpg".getBytes("gbk"), "iso8859-1");
		response.setHeader("Content-Disposition", "attachment;filename="+string);
		//3、可选的设置，设置文件大小response.setContentLength(len);
		
		//解决中文文件名问题
		String realPath = getServletContext().getRealPath("/62566.jpg");
		FileInputStream is = new FileInputStream(realPath);
		ServletOutputStream os = response.getOutputStream();
		IOUtils.copy(is, os);
		is.close();
		os.close();
	}
}
