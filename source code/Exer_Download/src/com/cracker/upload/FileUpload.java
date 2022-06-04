package com.cracker.upload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;


@WebServlet("/FileUpload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文件上传
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List<FileItem> parseRequest = upload.parseRequest(request);
			User user = new User();
			for (FileItem fileItem : parseRequest) {
				if(fileItem.isFormField()) {
					//普通表单项
					String name = fileItem.getFieldName();
					if("username".equals(name)) {
						user.setUsername(fileItem.getString("utf-8"));
					}
				}else {
					//文件项 文件名
					String name = UUID.randomUUID().toString().replaceAll("-", "")+"_"+fileItem.getName();
					//获取路径
					String location = getServletContext().getRealPath("/imgs");
					FileOutputStream os = new FileOutputStream(location+"/"+name);
					IOUtils.copy(fileItem.getInputStream(), os);
					os.close();
					//用户头像是一个当前项目下的虚拟地址 
					String vPath = "imgs/"+name;
					user.setImgPath(vPath);
				}
			}
			//保存到数据库
			UserDB.save(user);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
}
