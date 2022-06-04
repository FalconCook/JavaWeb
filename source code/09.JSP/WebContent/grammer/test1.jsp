<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- JSP模板元素 JSP页面中的静态HTML内容称为JSP模板元素 
	HTML定义页面结构
	
	把模板元素原封不动传入到out.write()
	-->
	<h1>你好</h1>
<!-- JSP表达式
	页面输出内容
	注意点：表达式里面的所有内容都是被传参进 out.print(new Date());
	所以参数能怎么写就怎么写
 -->
 <%= new Date()%>
 
 <!-- JSP脚本片段
 		在脚本片段里写java代码
 		向页面输出内容
 		out.print("");
 		脚本片段被原封不动的复制到.java文件里
 		脚本片段可以写多个
 		可以拆分，合起来必须是合法而且完整的java片段
  -->
 <%
 	int age = 18;
 	if(age >= 18){
 		out.print("666");
 	}else{
 		out.print("777");
 	}
 %>
</body>
</html>