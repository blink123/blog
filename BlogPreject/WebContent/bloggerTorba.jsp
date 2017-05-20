<%@page import="cx.system.blogger.Blogger"%>
<%@page import="liujiawei.service.BlogAttrs"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="container-fluid">
	<div class="header">
		<div>
			<h1>blogger name</h1>
			<span>http://blogger/index.html</span>
		</div>
		<div class="navbar1">
			<ul class="nav nav-tabs">
			<%Blogger currentBlogger=(Blogger)request.getSession().getAttribute(BlogAttrs.ATTR_CURRENTBLOGGER);			
			  if(currentBlogger!=null&&currentBlogger.getPermission()==1){%>
				<li><a href="toBloggerHome.do">关注信息</a></li>
				<li><a href="toBloggerOwn.do">个人主页</a></li>
				<li><a href="toBloggerLeaveMSg.do">留言</a></li>
				<li><a href="toAboutMe.do">关于我</a></li>
				<%} else{%>
					<li><a href="toBloggerOwn.do">个人主页</a></li>
					<li><a href="toBloggerLeaveMSg.do">留言</a></li>
				<%}%>
			</ul>
		</div>
	</div>
</div>