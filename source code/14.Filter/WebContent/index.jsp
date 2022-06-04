<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="hello.jsp">去hello.jsp，没带钱</a><br>
	<!-- 只要带上money参数就代表有钱了 -->
	<a href="hello.jsp?money=1">去hello.jsp，带上钱</a>
	<a href="TestServlet">我要去test.jsp</a>
	<%@include file="test.jsp" %>
	<jsp:include page="test.jsp"></jsp:include>
</body>
</html>