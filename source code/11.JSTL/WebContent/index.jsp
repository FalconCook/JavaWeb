<%@page import="com.cracker.bean.Student"%>
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
	pageContext.setAttribute("msg", "<h1>你好</h1>");
%>
<c:out value="${msg }" default="hello" escapeXml="false"></c:out>
<c:set var="tip" scope="page" value="${msg }"></c:set>
${pageScope.tip }
<hr/>
<%
	Student stu = new Student("tomcat",18);
	pageContext.setAttribute("stu", stu);
	request.setAttribute("stu", stu);
	session.setAttribute("stu", stu);
	application.setAttribute("stu", stu);
%>
<c:set property="name" value="apache2" target="${stu }"></c:set>
<%=stu.getName() %>
<!-- 使用标签移除域中属性 scope指定域-->
<c:remove var="stu" scope="page"/>
page:${pageScope.stu.name }<br/>
request:${requestScope.stu.name }<br/>
session:${sessionScope.stu.name }<br/>
application:${applicationScope.stu.name }<br/>
<hr/>
<!-- c:if -->
<c:if test="${stu.name != null }" scope="page" var="flag">
	<h1>我是c:if</h1>
</c:if>
<!-- 判断年龄是否大于18岁 -->
<c:if test="${stu.age > 18}">
	<h2>身份证</h2>
</c:if>
<c:if test="${stu.age <= 18}">
	<h2>上学</h2>
</c:if>
<br/><br/><br/>
<c:choose>
	<c:when test="${stu.age > 18 }">
		<h2>身份证</h2>
	</c:when>
	<c:when test="${stu.age == 18 }">
		<h2>办证</h2>
	</c:when>
	<c:when test="${stu.age < 18 && stu.age>10}">
		<h2>身份证</h2>
	</c:when>
	<c:otherwise>
		<h2>上学</h2>
	</c:otherwise>
</c:choose>
</body>
</html>