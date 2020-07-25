<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>系统首页</title>
		<link rel="stylesheet" href="static/css/style.css" />
		<link rel="stylesheet" href="static/css/font-awesome-4.7.0/css/font-awesome.min.css" />
		<script src="static/js/jquery-2.1.1.min.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(function(){
				$('.menux p').click(function(){
					$(this).siblings('ul').slideUp(200);
					$(this).next('ul').slideToggle(200);
				});
				$('.menux ul a').click(function(){
					$('iframe').attr("src",$(this).attr("url"));
					$('.menu_title').html($(this).attr("title"));
				});
			})
		</script>
	</head>
	<body>
		<div class="header">
			<div class="logo">学生选课系统</div>
			<div class="user">
				<i class="fa fa-caret-down point"></i>
				<i class="fa fa-user"></i>
				管理员
				<ul>
					<li><a href="javascript:void(0)">修改密码</a></li>
					<li><a href="javascript:void(0)">个人信息</a></li>
					<li><a href="javascript:void(0)">退出登录</a></li>
				</ul>
			</div>
		</div>
		<div class="left">
			<div class="title">
				<i class="fa fa-home"></i>
				系统功能
			</div>
			<div class="menux">
				<p>
					<i class="fa fa-info-circle"></i>
					<i class="fa fa-info-right point"></i>
					一级功能名称
				</p>
				<ul >
					<li>
						<a href="javascript:void(0);" url="tmp/list.jsp" title="子功能1">
						   <i class="fa fa-caret-right"></i>
						      子功能1
						</a>
					</li>
					<li>
						<a href="javascript:void(0);" url="2.html" title="子功能2">
						   <i class="fa fa-caret-right"></i>
						      子功能2
						</a>
					</li>
					<li>
						<a href="javascript:void(0);" url="3.html" title="子功能3">
						   <i class="fa fa-caret-right"></i>
						      子功能3
						</a>
					</li>
				</ul>
				<p>
					<i class="fa fa-info-circle"></i>
					<i class="fa fa-info-right point"></i>
					一级功能名称
				</p>
				<ul >
					<li>
						<a href="javascript:void(0);" url="tmp/list.jsp" title="子功能1">
						   <i class="fa fa-caret-right"></i>
						      子功能1
						</a>
					</li>
					<li>
						<a href="javascript:void(0);" url="2.html" title="子功能2">
						   <i class="fa fa-caret-right"></i>
						      子功能2
						</a>
					</li>
					<li>
						<a href="javascript:void(0);" url="3.html" title="子功能3">
						   <i class="fa fa-caret-right"></i>
						      子功能3
						</a>
					</li>
				</ul>
				<p>
					<i class="fa fa-info-circle"></i>
					<i class="fa fa-info-right point"></i>
					一级功能名称
				</p>
				<ul >
					<li>
						<a href="javascript:void(0);" url="tmp/list.jsp" title="子功能1">
						   <i class="fa fa-caret-right"></i>
						      子功能1
						</a>
					</li>
					<li>
						<a href="javascript:void(0);" url="2.html" title="子功能2">
						   <i class="fa fa-caret-right"></i>
						      子功能2
						</a>
					</li>
					<li>
						<a href="javascript:void(0);" url="3.html" title="子功能3">
						   <i class="fa fa-caret-right"></i>
						      子功能3
						</a>
					</li>
				</ul>
			</div>
		   </div>
		<div class="main">
			<div class="location">
				<i class="fa fa-home"></i>
				<span class="menu_title">用户管理</span>
			</div>
			<iframe src="tmp/list.jsp" width="100%" height="90%" frameborder="0px"></iframe>
		</div>
	</body>
</html>
