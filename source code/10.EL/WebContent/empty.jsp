<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
<!-- el表达式中有一个empty运算符 就是判断一个对象是否为空 ==null 
1.null
[1]变量的值是null		v
[2]域对象中不存在这个变量	v
2.空集合		v
3.空数组	int[] i = null
4.空字符串	v
5.空字符		v
-->
<%
	Student stu = null;
	List<Student> list = new ArrayList<Student>();
	int[] i = null;
	Map<String,Object> map = new HashMap<String,Object>();
	//list.add(null);
	pageContext.setAttribute("list", "15");
	//System.out.println(list.size());
%>
<%-- ${pageScope.list == null} --%><!-- false -->
${empty pageScope.list}<!-- true -->

${empty pageScope.list?"我是空串":pageScope.list}
${ pageScope.list != ""}
${ pageScope.list + "20"}

<%
	request.getContextPath();
%>

${pageContext.request.contextPath}
标签，文字

el的意义：
1、简化操作
2、友好显示

<%
	pageContext.setAttribute("req", request);
%>
<span>${msg}</span>
${req.scheme}://${req.serverName}
</body>
</html>