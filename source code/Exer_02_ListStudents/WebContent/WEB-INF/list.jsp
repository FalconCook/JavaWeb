<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.cracker.servlet.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table {
		border: 1px solid;
		border-collapse: collapse;
	}
	td,th{
		border: 1px solid;
		border-collapse: collapse;
	}
</style>
</head>
<body>
<!-- 把所有的学生数据友好的显示 -->
<% List<Student> all = (List<Student>)request.getAttribute("list"); %>
<%
	if(all != null){
%>
	<table>
	<tr>
		<th>#</th>
		<th>姓名</th>
		<th>性别</th>
		<th>年级</th>
		<th>创建日期</th>
	</tr>
	<%for(int i=0;i<all.size();i++){
		//获取当前student对象
		Student stu = all.get(i);
	%>
		<tr>
			<td><%=stu.getId() %></td>
			<td><%=stu.getName()%></td>
			<td><%=stu.getGender()%></td>
			<td><%=stu.getGrade()%></td>
			<td><%=new SimpleDateFormat("yyyy-MM-dd").format(stu.getCreateDate())%></td>
		</tr>
	<%
	}%>
</table>
<%		
	}else{
		%>
		<h1>当前没有学生</h1>
		<%
	}
%>
</body>
</html>