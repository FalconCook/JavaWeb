<%@page import="com.cracker.bean.OnlineUser"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
<%@page import="org.apache.tomcat.jni.Local"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//应该判断用户从哪个国家来。request中封装了
	//可以通过request对象来获取用户的区域信息
	Locale locale = request.getLocale();
	ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);
%>
<c:if test="${empty user }">
<form action="UserServlet?method=login" method="post">
	<%=bundle.getString("username") %>：<input name="username"/>
	<button><%=bundle.getString("login") %></button>
</form>
</c:if>
<c:if test="${!empty user }">
	<%=bundle.getString("welcome") %>，${user.username }<a href="UserServlet?method=logout"><%=bundle.getString("logout") %></a>
</c:if>
<hr/>
<h1><%=bundle.getString("onlines") %></h1>
<c:forEach items="<%=OnlineUser.getUsers() %>" var="onlineUser">
	${onlineUser.username }&nbsp;&nbsp;&nbsp;
</c:forEach>
</body>
</html>