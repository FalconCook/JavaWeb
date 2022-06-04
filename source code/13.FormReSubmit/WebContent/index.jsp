<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){
		var btn = document.getElementById("subId");
		btn.onclick = function(){
			//将按钮变灰
			this.disabled = true;
			//提交表单
			var formEle = document.getElementsByTagName("form")[0];
			formEle.submit();
		};
	};
</script>
</head>
<body>
<%
	//产生一个唯一不重复令牌
	String uuid = UUID.randomUUID().toString();
	session.setAttribute("token", uuid);
%>
<form action="UserServlet" method="post">
	用户名：<input type="text" name="username"/>
	<input type="hidden" name="token" value="<%=uuid %>"/>
	<input type="submit" value="注册" id="subId"/>
</form>
</body>
</html>