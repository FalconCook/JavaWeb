<%@page import="java.util.Date"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
<%@page import="org.apache.tomcat.jni.Local"%>
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
	//应该判断用户从哪个国家来。request中封装了
	//可以通过request对象来获取用户的区域信息
	Locale locale = request.getLocale();
	String lang = request.getParameter("lang");
	String c = request.getParameter("c");
	if(lang==null || "".equals(lang) || c==null || "".equals(c)){
		
	}else{
		//获取实际传来的locale信息，动态创建locale对象
		locale = new Locale(lang, c);
	}
	ResourceBundle bundle = ResourceBundle.getBundle("bookstore", locale);
%>
<h1><%=bundle.getString("welcome") %><%=new Date() %></h1>
<form action="">
	<%=bundle.getString("username")%>：<input name="username"/><br/>
	<%=bundle.getString("password")%>：<input name="password" type="password"/><br/>
	<button><%=bundle.getString("login")%></button>
</form>
<a href="index.jsp?lang=zh&c=CN">中文</a>	| <a href="index.jsp?lang=en&c=US">English</a>
</body>
</html>