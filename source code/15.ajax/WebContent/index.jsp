<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	
	//很多代码
	function ajaxRequest(){
		//如何发送ajax请求 异步请求
		//异步通信：通信之间没有任何优先级关系
		//同步通信：上一次通信完成，下一次才可以继续
		//在代码中
		//如果发送的是异步请求，那么发送请求后，后面的代码，不用等待请求完成（接受到来自服务器的数据）再执行
		//如果发送的是同步请求，那么发送请求后，后面的代码，需要等待请求完成再执行
		
		//1、创建xhr对象，用这个对象来向服务器发送请求
		var xhr = new getXMLHttpRequest();
		/* xhr.onreadystatechange = function(){
			alert(xhr.readyState);
		}; */
		//2、发请求 open()，send();
		//method请求类型GET、POST，url请求地址，async是否为异步，默认true（是异步）
		//username, password
		//3、open只是设置请求信息的，可以将请求参数带在url上
		xhr.open("GET", "AJAXServlet?username=abc&pwd=123", true);
		//4、Object body，请求体。把要发送的数据放在请求体
		//form method=get
		//5、调用send方法将请求发出去
		xhr.send();
		//6、必须接收响应的数据
		//xhr对象有两个属性
		//responseText 获得字符串形式的响应数据
		//responseXML 获得XML形式的响应数据
		/*alert("你好");
		alert(xhr.responseText);*/
		//必须在响应完成接受。。。必须监控请求对象的状态
		//onreadystatechange 每当请求状态改变就会执行
		//xhr对象有一个readyState
		//0：请求未初始化
		//1：服务器连接已建立
		//2：请求已接收
		//3：请求处理中
		//4：请求已完成，且响应已就绪
		xhr.onreadystatechange = function(){
			//当请求已完成的时候
			if(xhr.readyState == 4 && xhr.status == 200){
				//获取xhr的数据
				//alert(xhr.responseText);
				var divEle = document.getElementById("div_time");
				divEle.innerHTML = xhr.responseText;
				//alert(xhr.responseText;);
			}
		};
		
		alert("程序最后的alert");
	}
	
	//
	function getXMLHttpRequest(){
		var xhr;
		try{
			//大部分浏览器都支持
			xhr = new XMLHttpRequest();
		}catch(e){
			try{
				//如果不支持，在这里捕获异常并且采用IE6支持的方式
				xhr = new ActiveXObject("Msxml2.XMLHTTP");
			}catch(e){
				//如果还不支持，在这里捕获异常并采用IE5支持的方式
				xhr = new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
		return xhr;
	}
	//js发送ajax很麻烦
	//jquery发请求
</script>
<script type="text/javascript">
	function ajaxRequest2(){
		//jQuery.get(url, [data], [callback], [type])
		//jquery如何接收参数,只需要在回调函数里面定义一个接收响应数据的参数
		//type表示响应的数据是什么类型
		$.get("AJAXServlet?username=abc&pwd=123", function(a){
			//alert(a);
			var obj = JSON.parse(a);
			$("#div_time").text(obj.name);
		},"text");
	}
</script>
</head>
<body>
<iframe name="ajaxframe"></iframe>
<a href="AJAXServlet" target="ajaxframe">发送请求，获取服务区时间</a>
<button onclick="ajaxRequest();">发送ajax请求</button>
<button onclick="ajaxRequest2();">jquery发送ajax请求</button>
<div id="div_time">

</div>
</body>
</html>