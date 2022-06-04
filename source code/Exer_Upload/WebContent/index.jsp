<%@page import="com.cracker.upload.UserDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.userinfo{
		float: left;
		border: 1px solid;
		width: 300px;
		height: 200px;
	}
	
	img{
		width: 200px;
		height: 180px;
	}
</style>
</head>
<body>
<!-- 将上传的图片显示到index.jsp -->
<form action="FileUpload" method="post" enctype="multipart/form-data">
	用户名：<input name="username"/>
	头像：<input name="header" type="file"/>
	<button>上传</button>
</form>
<hr/>
<div>
<c:forEach items="<%=UserDB.getAll() %>" var="user">
<div class="userinfo">
	<div>${user.username }</div>
	<img alt="" src="${user.imgPath}">
</div>
</c:forEach>
</div>
</body>
</html>