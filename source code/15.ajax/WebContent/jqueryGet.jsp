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
		//jQuery.get(url, [data], [callback], [type])
		//url:待载入页面的URL地址
		//data:待发送 Key/value 参数。
		//callback:载入成功时回调函数。
		//type:返回内容格式，xml, html, script, json, text, _default。
		$("#btn01").click(function(){
			$.get("JQueryGetServlet?method=getUrlParam&id="+Math.random(),
				function(data){
					var obj = JSON.parse(data);
					var str = "学生名：" + obj.name;
					str += "<br/>学生年龄：" + obj.age;
					$("#divShow").html(str);
				}
			);
		});
		
		$("#btn02").click(function(){
			$.get("JQueryGetServlet?method=getUrlParam&id="+Math.random(),
				function(data){
					//声明为json
					var obj = data;
					var str = "学生名：" + obj.name;
					str += "<br/>学生年龄：" + obj.age;
					$("#divShow").html(str);
				},"json");
		});
		
		$("#btn03").click(function(){
			$.get("JQueryGetServlet?method=getUrlData&id="+Math.random(),
				{name:"李四",age:18},
				function(data){
					//声明为json
					var obj = data;
					var str = "学生名：" + obj.name;
					str += "<br/>学生年龄：" + obj.age;
					$("#divShow").html(str);
				},
				"json");
		});
		
		$("#btn04").click(function(){
			$.get("JQueryGetServlet?method=getUrlData&id="+Math.random())
		});
	});
</script>
</head>
<body>
<button id="btn01">JqueryGet请求，携带参数在url中,type是text</button>
<button id="btn02">JqueryGet请求，携带参数在url中,type是json</button>
<button id="btn03">JqueryGet请求，携带参数在data中</button>
<button id="btn04">JqueryGet请求，只传url</button>
<div style="border: 1px solid;width: 300px;height: 200px" id="divShow">

</div>
</body>
</html>