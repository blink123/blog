<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="layout" uri="/easy-layout.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>write_blog</title>
<link href="${ctx}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/bootstrap/css/visitor_css.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<script type="text/javascript" charset="utf-8"
	src="uediter/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="uediter/ueditor.all.min.js">
	
</script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8"
	src="uediter/lang/zh-cn/zh-cn.js"></script>

<style type="text/css">
div {
	width: 100%;
	height:80%;
}
</style>

</head>
<body>
	<div class="bc">
		<div class="content" style="padding-top: 20px;">
			<div class="container-fluid">
				<div class="hero-unit">					
					<br />
					
	<div class="panel panel-default" style="filter: alpha(opacity=100);-moz-opacity:1; opacity:1;">
				<div class="panel-body">
					<form action="releaseBlog.do" method="post">
						<div class="title" style="margin:15px auto 15px 0;border-radius:10px">
							<label for="title">标题</label> 
							<input id="title" class="input1"	type="text" required="required" name="title" />
						</div>
						<!-- 加载编辑器的容器 -->
						<script id="container" name="content" type="text/plain" style="width:100%;height:260px;">
            编辑博客...
        </script>
						<br />
						<div class="write_model">
							<div class="classify" >
								<label class="label" style="color:#555">文章分类</label>
								 <select name="classify">
									<option>体育</option>
									<option>娱乐</option>
									<option>体育</option>
									<option>美图</option>
									<option>购物</option>
									<option>科技</option>
								</select>
							</div>
						</div>
						<br /> 
						<div style="ext-align: center;">
							<input class="btn btn-default" type="submit" value="提交">
						</div>
					</form>
				</div>
				</div>
				
				</div>
			</div>
			<div class="container-fluid">
				<div class="footer">
					<div class="footer_text">
						<p>Copyright&COPY;2017All rights Resevered</p>
						<p>版权所有</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 配置文件 -->
	<script type="text/javascript" src="ueditor.config.js"></script>
	<!-- 编辑器源码文件 -->
	<script type="text/javascript" src="ueditor.all.js"></script>
	<!-- 实例化编辑器 -->
	<script type="text/javascript">
		var editor = UE.getEditor('container');
	</script>
</body>
</html>
