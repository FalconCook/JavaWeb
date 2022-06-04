<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 传区域全名 语言_国家 -->
<fmt:setLocale value="${param.c }"/>
<!-- 设置资源的基础名 -->
<fmt:setBundle basename="bookstore"/>

<h1>
	<!-- 获取资源文件中的信息 -->
	<fmt:message key="info">
		<fmt:param>张三</fmt:param>
		<fmt:param>
			<fmt:formatDate value="<%=new Date() %>" type="both" dateStyle="full"/>
		</fmt:param>
	</fmt:message>
</h1>
<form action="">
	<fmt:message key="username"/>：<input name="username"/><br/>
	<fmt:message key="password"/>：<input name="password" type="password"/><br/>
	<button><fmt:message key="login"/></button>
</form>
<a href="index2.jsp?c=zh_CN">中文</a>	| <a href="index2.jsp?c=en_US">English</a>
</body>
</html>