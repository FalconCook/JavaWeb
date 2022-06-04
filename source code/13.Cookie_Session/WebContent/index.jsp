<%@page import="com.cracker.cookie.User"%>
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
	session.setAttribute("sessAttr", "sessionValue");
	session.setAttribute("user", new User("张三"));
%>
<!-- 重写url -->
<%-- <%=
response.encodeRedirectUrl(request.getContextPath()+"/s.jsp")
%> --%>
<!-- jstl可以替代value指定要重写哪个url		/代表当前 -->
<c:url value="/s.jsp"></c:url>
<a href="<c:url value="/s.jsp"></c:url>">去其他页面获取数据</a>
</body>
</html>