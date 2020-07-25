<%--@elvariable id="error" type=""--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>学生登录页面</title>
		<style type="text/css">
			*{
				margin:0px;
				padding:0px;
			}
			html,body{
				background-image:url(static/img/login/bg.jpg);
				background-size:100% 100%;
				height:100%;
			}
			.login{
				position:absolute;  
				background-color: rgba(255,255,255,.8);
				top:25%;
				left:60%;
				right:10%;
				bottom:25%;
				border-radius: 5px;
			}
			.title,.u,.p,.l,.tips,.s{
				position:absolute;
				width:100%;
			}
			input{
				height:35px;
				background-color:#F2F2FA;
				border:0px;
				width:60%;
			}
			button{
				background-color:#467FE6;
				height:35px;
				width:60%;
				border:0px;
				border-radius:5px;
				color:#FFF;
				font-size:16PX;
			}
			select{
				width:60%;
				height:35px;
				border-radius: 4px;
				border:1px solid #e1e1e1;
			}
			.title{
				top:5%;
				bottom:80%;
				text-align:center;
				font-weight:bold;
				padding-top:10px;
				box-sizing:border-box;
				
			}
			.u{
				top:20%;
				bottom:60%;
				left:50px;
			}
			.p{
				top:40%;
				bottom:40%;
				left:50px;
			}
			.s{
				top:60%;
				bottom:20%;
				left:50px;
			}
			.l{
				top:80%;
				bottom:10%;
				left:90px;
			}
			.tips{
				top:90%;
				font-size:13px;
				color:#999999;
				text-align:center;
				
			}

			</style>
	</head>
	<body>
		<div class="login">
			
			<div class="title">
			      学生选课系统
			</div>
			<form action="/login" method="post">
			<div class="u">
				用户<input type="text" name="userName" />
			</div>
			<div class="p">
				密码<input type="text" name="password" />
			</div>
			<div class="s">
				身份
				<select name="type">
					<option value="">请选择登录类型</option>
					<option value="0">学生</option>
					<option value="1">老师</option>
					<option value="2">管理员</option>
				</select>
			</div>
			<div class="l">

				<button type="submit">登录</button>
			</div>
			</form>
			<div class="tips">
				这里应该显示录入信息不能为空${error};

			</div>
		</div>
	</body>
</html>
