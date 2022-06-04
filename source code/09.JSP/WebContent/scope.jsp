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
	//给pageContext域中设置内容
	pageContext.setAttribute("pageUser", "chen");
	//给request域中设置内容
	request.setAttribute("reqUser", "reqName");
	//给session域中设置内容
	session.setAttribute("sessUser", "sessName");
	//给application域中设置内容
	application.setAttribute("appUser", "appName");
%>

<jsp:forward page="scope2.jsp"></jsp:forward>
<h1>各个域中的数据</h1>
pageContext：<%=pageContext.getAttribute("pageUser") %><br/>
request：<%=request.getAttribute("reqUser") %><br/>
session：<%=session.getAttribute("sessUser") %><br/>
application：<%=application.getAttribute("appUser") %><br/>
<a href="scope2.jsp">去scope2看效果</a>
</body>
</html>