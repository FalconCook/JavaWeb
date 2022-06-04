package com.cracker.upload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String username = request.getParameter("username");
		String headerImg = request.getParameter("headerImg");
		System.out.println("用户名："+username);
		System.out.println("头像："+headerImg);*/
		
		//获取整个请求的流（表单的所有项，部件）
		/*ServletInputStream stream = request.getInputStream();
		String string = IOUtils.toString(stream);
		System.out.println("流："+string);*/
		
		//1、先创建一个工厂实例
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//2、创建一个专门用来处理Servlet文件上传的对象
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		//3、解析文件上传请求
		try {
			//返回的list,封装什么？FileItem
			//就是封装了请求流中的每个部件
			List<FileItem> list = fileUpload.parseRequest(request);
			for (FileItem fileItem : list) {
				if(fileItem.isFormField()) {
					//true代表是简单的key-value
					//getFieldName就是表单项的name值
					String fieldName = fileItem.getFieldName();
					//获取文件名（获取不到）
					String name = fileItem.getName();
					System.out.println("普通表单项：fieldName:"+fieldName);
					System.out.println("普通表单项：name:"+name);
				}else {
					//false代表一个是文件
					//getFieldName就是表单项的name值
					String fieldName = fileItem.getFieldName();
					//获取文件名,w3标准浏览器，文件名
					//ie:获取文件的路径
					String name = fileItem.getName();
					//返回-1代表不包含
					int of = name.lastIndexOf("\\");
					name = name.substring(of+1);
					System.out.println("文件表单项：fieldName:"+fieldName);
					System.out.println("文件表单项：name:"+name);
					//获取流
					InputStream stream = fileItem.getInputStream();
					//保存流
					//将文件写到项目中
					ServletContext servletContext = getServletContext();
					String realPath = servletContext.getRealPath("/uploads");
					System.out.println("uploads的实际路径"+realPath);
					//这个是文件名的前缀
					String prefix = UUID.randomUUID().toString().replaceAll("-", "");
					name = prefix+"_"+name;
					FileOutputStream outputStream = new FileOutputStream(realPath+"/"+name);
					//输入流写到输出流
					IOUtils.copy(stream, outputStream);
					//关流输出流
					outputStream.close();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

}
