<%@page import="liujiawei.service.BlogAttrs"%>
<%@page import="cx.system.blogger.Blogger" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="layout" uri="/easy-layout.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<layout:definition>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>visitor_index</title>
<link href="${ctx}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/bootstrap/css/visitor_css.css" rel="stylesheet">
<style>
body {
	font-family: "microsoft yahei";
	/*min-width: 800px;*/
}

img {
	width: 100%;
	/*height: 462px;*/
}

.navbar {
	/*margin-bottom: -10px;*/
	
}
#myppt {
	margin-top: -20px;
}
</style>
<layout:component name="links">这里是链接的外部文件</layout:component>
</head>
<body>
<%request.setCharacterEncoding("utf-8"); %>
<%request.setAttribute("currentview", "index"); %>
	<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
		<div class="container-fluid">
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-left">
					<li><a href="index.jsp">首页</a></li>
					<li><a href="#">关于</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<%Blogger blogger= (Blogger)request.getSession().getAttribute(BlogAttrs.ATTR_CURRENTBLOGGER);%>
					<%if(blogger!=null){%>
						<li style="padding-top:15px;padding-bottom:15px;color:white">欢迎您：<%= blogger.getName() %></li>
						<li><a href="toBloggerHome.do">进入主页</a></li>
						<li><a href="toLogout.do">注销</a></li>
					<%}else{%>
						<li><a data-toggle="modal" data-target="#login" href="">登陆</a></li>
						<li><a data-toggle="modal" data-target="#register" href="">注册</a></li>
					<%} %>
				</ul>
			</div>
		</div>
	</nav>
	<div class="bc">
		<div class="content">
			<div class="container-fluid">
				<!--  div class="row"-->
					<layout:component name="content">这里是想重写的部分</layout:component>
				<!--  /div-->
			</div>
		</div>
		
	  <div class="footer">
      <div class="footer_text">
              <p>Copyright&COPY;2017All rights Resevered</p>
              <p>版权所有</p>
          </div>
      </div>
		
	</div>

	<!-- 注册窗口 -->
	<div id="register" class="modal fade"  tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<button class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
				</div>
				<div class="modal-title">
					<h1 class="text-center">注册</h1>
				</div>
				<div class="modal-body">
					<form class="form-group" action="regist.do" method="post">
						<div class="form-group">
							<label for="">用户名</label>
							<input class="form-control" type="text" name="username"
								placeholder="6-15位字母或数字">
						</div>
						<div class="form-group">
							<label for="">密码</label> <input class="form-control"
								type="password" placeholder="至少6位字母或数字" name="password">
						</div>
						<div class="form-group">
							<label for="">再次输入密码</label> <input class="form-control"
								type="password" placeholder="至少6位字母或数字">
						</div>
						<div class="text-right">
							<button class="btn btn-primary" type="submit">提交</button>
							<button class="btn btn-danger" data-dismiss="modal">取消</button>
						</div>
						<a href="" data-toggle="modal" data-dismiss="modal"
							data-target="#login">已有账号？点我登录</a>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- 登录窗口 -->
	<div id="login" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<button class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
				</div>
				<div class="modal-title">
					<h1 class="text-center">登录</h1>
				</div>
				<div class="modal-body">
					<form class="form-group" action="login.do" method="post">
						<div class="form-group">
							<label for="">用户名</label> <input name="username" class="form-control" type="text"
								placeholder="">
						</div>
						<div class="form-group">
							<label for="">密码</label> <input name="password" class="form-control"
								type="password" placeholder="">
						</div>
						<div class="text-right">
							<button class="btn btn-primary" type="submit">登录</button>
							<button class="btn btn-danger" data-dismiss="modal">取消</button>
						</div>
						<a href="" data-toggle="modal" data-dismiss="modal"
							data-target="#register">还没有账号？点我注册</a>
					</form>
				</div>
			</div>
		</div>
	</div>
	
	<script src="${ctx}/bootstrap/js/jquery-2.0.0.js"></script>
    <script src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
	<script src="http://cdn.bootcss.com/bootstrap/2.3.1/js/bootstrap-modal.js"></script>
</body>
	</html>
</layout:definition>