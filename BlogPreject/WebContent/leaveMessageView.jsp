
<%@page import="cx.system.blogger.Blogger"%>
<%@page import="liujiawei.service.BlogAttrs"%>
<%@page import="liujiawei.service.ContentMgr"%>
<%@page import="java.util.List"%>
<%@page import="jmk.system.comment.PrivateLetter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="layout" uri="/easy-layout.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<layout:render name="/basemodel.jsp">
	<layout:component name="content">
		<div class="bc">
			<div class="content" style="width: 90%;">
				<!-- 这里引用其他jsp组件    博主导航条 -->
				<jsp:include page="bloggerTorba.jsp" flush="true" />
				<div class="container-fluid">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="row">
							
							<!-- 这里是留言或者私信的表单 -->
							<form class="form-group" action="onLeaveLetter.do" method="post">
						<div class="form-group">
							<label for="">留言</label>
							<textarea class="form-control" rows="3" width="15px" name="content"></textarea>
						</div>
						<div class="text-right">
							<button class="btn btn-primary" type="submit">发留言</button>
							<!--  button class="btn btn-primary" type="submit">发私信</button>-->
						</div>
					</form>
							<!-- 这里是留言模板 -->
							<%
							Blogger aimBlogger=(Blogger)request.getSession().getAttribute(BlogAttrs.ATTR_AIMBLOGGER);
							List<PrivateLetter> list_privateLetters=ContentMgr.getInstance().getAllPrivateLetterByName(aimBlogger.getName());
							for(PrivateLetter pl : list_privateLetters){
							%>
							<div class="row border_buttom">
								<div class="col-xs-3 col-md-3 ">
									<div class="person_info">
										<img src="pictures/head3.jpg" class="img-responsive"
											alt="Responsive image">
										<p><%=pl.getSendBloggerName()%></p>
									</div>
								</div>
								<div class="col-xs-9 col-md-9">
									<div class="blog box_css">
										<p>
										<%=pl.getContent() %>
										</p>
										<span class="time"><%=pl.getTime() %></span>
									</div>
								</div>
							</div>
							<%} %>							
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</layout:component>
</layout:render>