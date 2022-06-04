<%@page import="com.cracker.bean.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- jsp脚本片段 pageContext，request，session，application 资源之间共享数据 -->
<%
	Student stu = new Student("张三",18);
	pageContext.setAttribute("stu", stu);
	request.setAttribute("stu-x", stu);
	session.setAttribute("stu", "sessionValue");
	application.setAttribute("stu", "appValue");
	String str = "你好";
%>
jsp:<%=request.getAttribute("stu-x") %>
<br/>
el:${requestScope['stu-x'] }


<%-- jsp表达式：<%=str %>
el表达式：${str} --%>
jsp表达式：<%=request.getAttribute("stu-x") %><br/>
el表达式：${requestScope['stu-x']['name']}<br/>

JSP表达式取出四个域中的内容：<br/>

<%--${表达式内容} --%> 
使用el表达式获取域内容语法<br/>

page:${ pageScope.stu.name}<br/>
request:${ requestScope.stu}<br/>
session:${ sessionScope.stu}<br/>
application:${ applicationScope.stu}


<!-- el中的其他对象 pageContext可以取出其他jsp页面的隐含对象，接下就可以取出所隐含对象属性-->
${pageContext.request.scheme }
<%=pageContext.getRequest().getScheme() %>

<!-- 和HTTP协议有关 5个-->
param (封装了所有的请求参数的key-value)对应一个请求参数	request.getParamer("username")<br/>
paramValues 对应一组请求参数<br/>
header	请求头	request.getHeader("User-Agent")<br/>
headerValues	请求头返回字符数组<br/>	
cookie	获取某个cookie对象<br/>

请求参数：${param.username }<br/>
获取请求参数：${paramValues.ah[0]},${paramValues.ah[1]},${paramValues.ah[2]}
获取请求头：${header['Host'] }<br/>

<hr/>
${pageScope.stu.flag }

<!-- cookie是一个对象 -->
Cookie：${cookie.JSESSIONID.name } || ${ cookie.JSESSIONID.value}
<br/>
<!-- initParam 获取web的初始化参数 -->
初始化参数：${initParam.user }
</body>
</html>