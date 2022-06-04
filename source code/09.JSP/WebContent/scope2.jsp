<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>scope2页面，各个域中的数据</h1>
pageContext：<%=pageContext.getAttribute("pageUser") %><br/>
request：<%=request.getAttribute("reqUser") %><br/>
session：<%=session.getAttribute("sessUser") %><br/>
application：<%=application.getAttribute("appUser") %><br/>
</body>
</html>