package com.cracker.upload;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

@WebServlet("/FileDownLoad")
public class FileDownLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//要下载资源的虚拟路径
		String res = request.getParameter("res");
		//1、找到要下载资源的真实地址
		String realPath = getServletContext().getRealPath("/"+res);
		//2、设置content-type
		String mimeType = getServletContext().getMimeType(res);
		response.setContentType(mimeType);
		//3、设置Content-Disposition
		int indexOf = res.lastIndexOf("/");
		String filename = res.substring(indexOf+1);
		filename = filename.substring(filename.lastIndexOf("_")+1);
		//解决中文乱码
		String string = new String(filename.getBytes("gbk"), "iso8859-1");
		response.setHeader("Content-Disposition", "attachment;filename="+string);
		//4、文件流写出去
		FileInputStream is = new FileInputStream(realPath);
		ServletOutputStream os = response.getOutputStream();
		IOUtils.copy(is, os);
		is.close();
		os.close();
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
}
