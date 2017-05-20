<%@page import="java.util.ArrayList"%>
<%@page import="com.mysql.fabric.xmlrpc.base.Array"%>
<%@page import="liujiawei.service.ContentMgr"%>
<%@page import="jmk.system.comment.Article"%>
<%@page import="java.util.List"%>
<%@page import="liujiawei.service.BloggerMgr"%>
<%@page import="cx.system.blogger.Blogger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="layout" uri="/easy-layout.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>write_blog</title>
<link href="${ctx}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/bootstrap/css/visitor_css.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div class="bc">
		<div class="content" style="padding-top: 20px;">
			<div class="container-fluid">
				<div class="hero-unit">
					<br />
					<div class="panel panel-default"
						style="filter: alpha(opacity = 100); -moz-opacity: 1; opacity: 1;">
						<div class="panel-body">
						<div class="hero-unit" style="padding-top:20px;color:wheat;">
							<h1>系统管理员</h1>
						</div>
						<!-- 这里是博主表 -->
							<div class="separator bottom form-inline small">用户表</div>
							<table
								class="table table-bordered table-condensed table-striped table-primary table-vertical-center checkboxs">
								<thead>
									<tr>
										<th class="center">编号</th>
										<th class="center">姓名</th>
										<th class="center">注册日期</th>
										<th class="center">点赞数</th>
										<th class="center">打赏数</th>
										<th class="center" style="width: 90px;">操作</th>
									</tr>
								</thead>
								<tbody id="tb_work_device">
									<%
										List<Blogger> list_bloggers = BloggerMgr.getInstance().getAllBlogger();
									if(list_bloggers==null){
										list_bloggers=new ArrayList<Blogger>();
									}
										int no = 0;
										for (Blogger blogger : list_bloggers) {
											no++;
									%>
									<tr class="selectable">
										<td class="center"><%=no%></td>
										<td class="center"><%=blogger.getName()%></td>
										<td class="center"><%=blogger.getDatetime()%></td>
										<td class="center"><%=blogger.getLikeNumber()%></td>
										<td class="center"><%=blogger.getRewardNumber()%></td>
										<td class="center">
											<button class="btn btn-danger" onclick="onDeleteBlogger('<%=blogger.getName()%>',this)">删除</button>
										</td>
									</tr>
									<%
										}
									%>
								</tbody>
							</table>
							<!-- 这里是博文表 -->
							<div class="separator bottom form-inline small">博文表</div>
							<table
								class="table table-bordered table-condensed table-striped table-primary table-vertical-center checkboxs">
								<thead>
									<tr>
										<th class="center">编号</th>
										<th class="center">博文名称</th>
										<th class="center">博文作者</th>
										<th class="center">博文类型</th>
										<th class="center">发布日期</th>
										<th class="center">点赞量</th>
										<th class="center" style="width: 90px;">操作</th>
									</tr>
								</thead>
								<tbody id="tb_work_device">
									<%
										List<Article> list_artArticles = ContentMgr.getInstance().getAllArticles();
									if(list_artArticles==null){
										list_artArticles=new ArrayList<Article>();
									}
										for (Article article : list_artArticles) {
									%>
									<tr class="selectable">
										<td class="center"><%=article.getNumber()%></td>
										<td class="center"><%=article.getTitle()%></td>
										<td class="center"><%=article.getBloggerName()%></td>
										<td class="center"><%=article.getType()%></td>
										<td class="center"><%=article.getTime()%></td>
										<td class="center"><%=article.getReadCount()%></td>
										<td class="center">
										 <ul class="nav navbar-nav">
										 	<li style="float:left;">
										 	<%if(BloggerMgr.getInstance().isInRecommand(article.getNumber())){ %>
										 		<button class="btn btn-info" onclick="onDeleteOneRecommand('<%=article.getNumber()%>',this)">取消推荐</button>
										 		<%}else{ %>
										 		<button class="btn btn-info" onclick="onAddOneRecommand('<%=article.getNumber()%>',this)">推荐</button>
										 		<%} %>
										 	</li>
										 	<li>
												<button class="btn btn-danger" onclick="onDeleteBlogger('<%=article.getNumber()%>',this)">删除</button>
											</li>
										 </ul>
										</td>
									</tr>
									<%
										}
									%>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="${ctx}/bootstrap/js/jquery-2.0.0.js"></script>
		<script src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
	<script>
	function onDeleteBlogger(bloggerName,itermBtn){
		alert("确定删除"+bloggerName+"\nTA的博文等所有相关信息将被一并删除！");		
		$.post(
				"onDeleteBl.do",
				{aimBloggerName:bloggerName},
				function(data){
					$(itermBtn).parents("tr").remove();
					location.reload();
				})
	}
	</script>
	<script>
	function onDeleteBlogger(articlenumber,itermBtn){
	alert("确定删除文章吗？博文等所有相关信息将被一并删除！");		
	$.post(
			"onDeleteArticle.do",
			{articleNumber:articlenumber},
			function(data){
				location.reload();
			})
	}
	</script>
	<script>
	function onAddOneRecommand(recommandnumber,itermBtn){
		$.post(
				"onAddOneRecommand.do",
				{articleNumber:recommandnumber},
				function(data){
					alert("推荐成功");
					location.reload();
				})
	}
	</script>
	<script>
	function onDeleteOneRecommand(recommandnumber,itermBtn){	
		$.post(
				"onDeleteOneRecommand.do",
				{articleNumber:recommandnumber},
				function(data){
					alert("取消成功");
					location.reload();
				})
	}
	</script>
</body>
</html>