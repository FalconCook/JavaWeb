<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<iframe name="sessionFrame"></iframe>
		
		<ul>
			<li><a target="sessionFrame" href="SessionServlet?method=get">获取session对象</a></li>
			<li><a target="sessionFrame" href="SessionServlet?method=save">给session中保存内容</a></li>
			<li><a target="sessionFrame" href="SessionServlet?method=getValue">获取session中内容</a></li>
			<li><a target="sessionFrame" href="SessionServlet?method=time">获取Session中有效时间</a></li>
			<li><a target="sessionFrame" href="SessionServlet?method=updatetime">修改Session有效时间</a></li>
			<li><a target="sessionFrame" href="SessionServlet?method=invalid">强制Session失效</a></li>
			<li><a target="sessionFrame" href="SessionServlet?method=persist">关闭浏览器保持session</a></li>
			
			<li><a href="s.jsp">去其他页面取数据</a></li>
		</ul>
	</div>
</body>
</html>