<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setAttribute("msg", "HelloWorldA");
%>
判断前面的字符串是否包含后面，区分大小写:${fn:contains(msg, "a") }<br/>
判断前面的字符串是否包含后面，不区分大小写:${fn:containsIgnoreCase(msg, "a") }<br/>
判断字符串是否以某个字符串开始：${fn:startsWith(msg,"H") }<br/>
判断字符串是否以某个字符串结束：${fn:endsWith(msg,"H") }<br/>
字符串的起始位置：${fn:indexOf(msg, "Wor")}<br/>
字符串替换：${fn:replace(msg, "Hello", "Hi")}<br/>
字符串截取(不包含后面)：${fn:substring(msg, 0, 5)}<br/>
</body>
</html>