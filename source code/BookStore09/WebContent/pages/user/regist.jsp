<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员注册页面</title>
<%@include file="/include/base.jsp" %>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}	
</style>
<script type="text/javascript">
	$(function(){
		//2、点击图片更换验证码
		$("#codeImg").click(function(){
			//改变src，要让浏览器知道这是新请求,如果是同一请求，浏览器有时会从缓存中加载
			var url = "code.jpg?t="+Math.random();
			$(this).prop("src",url);
		});
		
		$(".itxt[name=username]").blur(function(){
			var username = $(".itxt[name=username]").val();
			//用户已经输完用户名
			//向服务器发个请求看用户是否可用
			//验证用户名
			var regUserName = /^[a-zA-Z0-9_-]{5,18}$/;
			if(regUserName.test(username)){
				//用户名验证成功发请求
				$.get("UserServlet?method=checkuser&username="+username,
					function(data){
						$(".errorMsg").text(data);
					}
				);
			}
			
		});
		//1、检查用户名、密码等信息是否符合规则
		$("#sub_btn").click(function(){
			
			//获取用户输入
			var username = $(".itxt[name=username]").val();
			var password = $(".itxt[name=password]").val();
			var repwd = $(".itxt[name=repwd]").val();
			var email = $(".itxt[name=email]").val();
			var code = $(".itxt[name=code]").val();
			
			var regUserName = /^[a-zA-Z0-9_-]{5,18}$/;
			var regPwd = /^[a-zA-Z0-9_-]{5,18}$/;
			var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			
			if(!regUserName.test(username)){
				//如果用户名验证失败
				$(".errorMsg").text("用户名格式错误");
				//取消默认行为
				return false;
			}else{
				
			}
			
			if(!pwdReg.test(password)){
				//密码格式不正确
				alert("请输入包含字母、数字、-、_且6-18位的密码！");
				//取消默认行为
				return false;
			}
			
			//验证确认密码
			if(repwd != password){
				//两次输入的密码不一致
				alert("两次输入的密码不一致！");
				return false;
			}
			
			//检查邮箱格式
			
			if(!emailReg.test(email)){
				alert("请输入正确的邮箱地址！");
				return false;
			}
			
			//检查验证码是否为空
			if(code == ""){
				alert("请输入验证码！");
				return false;
			}

		});
		
	});

</script>

</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册会员</h1>
								<span class="errorMsg">
									${msg==null?"请输入用户名":msg }
									<%-- <%=request.getAttribute("msg")==null?"请输入用户名":request.getAttribute("msg") %> --%>
								</span>
							</div>
							<div class="form">
								<form action="UserServlet" method="post">
									<input type="hidden" name="method" value="regist" />
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username"
									value="${param.username }" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="text" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email"
									value="${param.email }" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 80px;" name="code"/>
									<img alt="" src="code.jpg" style="float: right; margin-right: 40px; width:120px; height: 50px" id="codeImg">									
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<div id="bottom">
			<span>
				书城.Copyright &copy;2015
			</span>
		</div>
</body>
</html>