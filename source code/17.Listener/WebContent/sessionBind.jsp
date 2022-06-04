<%@page import="com.cracker.listener.session.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	User user = new User("apache");
	//给session中保存user对象（绑定）
	session.setAttribute("user", user);
	//移除
	Thread.sleep(1000);
	session.removeAttribute("user");
	//立即失效
	//session.invalidate();
%>
</body>
</html>