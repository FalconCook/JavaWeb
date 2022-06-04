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
		$("#btn01").click(function(){
			$.ajax({
				url:"JQueryGetServlet?method=getUrlData&id="+Math.random(),
				/* data:{"name":"李四","age":18}, */
				data:"name=张三&age=18",
				type:"POST",
				async:true,
				success:function(data){
					alert(data);
				},
				error:function(){
					alert("发生错误了...");
				}
			});
		});
		
		$("#btn02").click(function(){
			var name = $("#input1").val();
			var age = $("#input2").val();
			var datas = $("#formSubmit").serialize();
			$.ajax({
				url:"JQueryGetServlet?method=getUrlData&id="+Math.random(),
				/* data:{"name":"李四","age":18}, */
				data:datas,
				type:"POST",
				async:true,
				success:function(data){
					alert(data);
				},
				error:function(){
					alert("发生错误了...");
				}
			});
		});
	});
</script>
</head>
<body>
<button id="btn01">JqueryPost请求，携带参数在url中,type是json</button>
<div style="border: 1px solid;width: 300px;height: 200px" id="divShow">
</div>

<form id="formSubmit" action="">
	姓名：<input name="name" id="input1"/> 年龄：<input name="age" id="input2"/>
</form>
<button id="btn02">AJAX请求表单数据</button>
</body>
</html>