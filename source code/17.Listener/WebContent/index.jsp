<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%=
	application
%>
<br>
<%
	Thread.sleep(1000);
	//销毁
	session.invalidate();
%>
<body>
<a href="note.txt">发请求</a><br>
<a href="reqAttr.jsp">req域属性监听</a><br>
</body>
</html>