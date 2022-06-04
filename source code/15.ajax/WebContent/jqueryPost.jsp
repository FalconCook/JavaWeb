<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		//jQuery.Post(url, [data], [callback], [type])
		//url:待载入页面的URL地址
		//data:待发送 Key/value 参数。
		//callback:载入成功时回调函数。
		//type:返回内容格式，xml, html, script, json, text, _default。
		$("#btn01").click(function(){
			$.post("JQueryGetServlet?method=getUrlData&id="+Math.random(),
				{name:"李四",age:18},
				function(data){
					var obj = JSON.parse(data);
					var str = "学生名：" + obj.name;
					str += "<br/>学生年龄：" + obj.age;
					$("#divShow").html(str);
				}
			);
		});
		
		
	});
</script>
</head>
<body>
<button id="btn01">JqueryPost请求，携带参数在url中,type是json</button>
<div style="border: 1px solid;width: 300px;height: 200px" id="divShow">

</div>
</body>
</html>