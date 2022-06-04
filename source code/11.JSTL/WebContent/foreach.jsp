<%@page import="java.util.ArrayList"%>
<%@page import="com.cracker.bean.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 把每次遍历到的值赋给var指定的变量 -->
<c:forEach begin="0" end="10" var="num" step="2">
	${num }<br/>
</c:forEach>
<%
	List<Student> list = new ArrayList<Student>();
	list.add(new Student("小明",18));
	list.add(new Student("小明2",18));
	list.add(new Student("小明3",18));
	list.add(new Student("小明4",18));
	list.add(new Student("小明5",18));
	
	request.setAttribute("list", list);
%>

<!-- 使用foreach遍历一个list 指定遍历哪些东西items 每个遍历出的数据放在哪儿var -->
<c:forEach var="stu" items="<%=list %>">
	${stu.name }--->${stu.age }<br/>
</c:forEach>
<hr/>
<table>
	<tr>
		<th>用户名</th><th>年龄</th>
		<th>status.begin</th><th>status.end</th>
		<th>status.step</th>
		<th>status.count</th><th>status.index</th>
		<th>status.last</th>
	</tr>
<c:forEach begin="0" end="4" step="1" var="stu" items="${requestScope.list }" varStatus="status">
	<tr>
		<td>${stu.name }</td><td>${stu.age }</td>
		<td>${status.begin }</td><td>${status.end }</td>
		<td>${status.step }</td>
		<th>${status.count }</th><th>${status.index }</th>
		<th>${status.last }</th>
	</tr>
</c:forEach>
</table>


<c:if test="${msg }">
	<c:redirect url="/index.jsp"></c:redirect>
</c:if>

</body>
</html>