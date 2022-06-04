<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/grammer/250.jsp" session="true"
    isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! private String name="username"; 
	public void test(){
		System.out.println("我是test方法");
	}
%>
<% 
	session.setAttribute("msg", "你好，我是Session的Msg");
	test();
	//java注释
	//int i = 10/0;
%>

${sessionScope.msg}
<h1>test2.jsp</h1>
<!-- HTML注释 -->
<%-- JSP注释 --%>
<%= name%>
</body>
</html>