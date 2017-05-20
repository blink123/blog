<%@page import="cx.system.blogger.Blogger"%>
<%@page import="jmk.system.comment.Comment"%>
<%@page import="liujiawei.service.BlogAttrs"%>
<%@page import="liujiawei.service.ContentMgr"%>
<%@page import="liujiawei.service.BloggerMgr"%>
<%@page import="jmk.system.comment.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="layout" uri="/easy-layout.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<layout:render name="/basemodel.jsp">
	<layout:component name="content">
	<%Blogger blogger = (Blogger) request.getSession().getAttribute(BlogAttrs.ATTR_AIMBLOGGER);
		Blogger currentBlogger =(Blogger)request.getSession().getAttribute(BlogAttrs.ATTR_CURRENTBLOGGER); %>
		<div class="bc">
			<div class="content" style="width: 90%;">
				<!-- 这里引用其他jsp组件    博主导航条 -->
				<jsp:include page="bloggerTorba.jsp" flush="true" />
				<div class="container-fluid">
					<div class="panel panel-default">
						<div class="write_blog">
							<a href="writeBlog.do">写博客</a>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-xs-2 col-md-2">
									<!-- <div class="fir_colm"> -->
									<div class="infoma">
										<img src="${ctx}/pictures/head2.jpg" class="img-responsive"
											alt="Responsive image">
										<p><%=blogger.getName()%></p>
										<!-- 这里添加增加好友操作 -->
										<%if(currentBlogger==null){%>
											<a data-toggle="modal" data-target="#login" href="">登陆后关注</a>
										<% }else if(currentBlogger.getPermission()==0){ 
											if(BloggerMgr.getInstance().checkFriendByName(currentBlogger.getName(), blogger.getName()))
											{
										%>
										<a href="javascript:void(0);" onclick="onBtnNotBeFriends()">取消关注</a>
										<%}else{ %>
											<a href="javascript:void(0);" onclick="onBtnBeFriends()">关注TA</a>
											<%} %>
										<%} %>
									</div>
								</div>
								<div class="col-xs-10 col-md-10">
									<div class="sec_colm  box_css">
										<!-- 这是博主自己的主页的博客模板 -->
										<%											
											List<Article> list_aArticles = ContentMgr.getInstance().getArticlesByBlogger(blogger.getName());
											for (Article articleTemp : list_aArticles) {
										%>
										<div class="blog box_css" id="<%=articleTemp.getNumber()%>">
											<p>
												<b><%=articleTemp.getTitle()%></b>
											</p>
											<div class="reship">
												<b><a>转发</a></b><a><i
													class="glyphicon glyphicon-share-alt"
													aria-label="Right Align"></i></a>
											</div>
											<span class="time"><%=articleTemp.getTime()%></span>
											<p><%=articleTemp.getContent()%></p>
											<div>
												<ul class="ul_dia">
													<li><a href="javascript:void(0);" 
												onclick="onBtnComment('<%=articleTemp.getNumber()%>','<%=articleTemp.getBloggerName()%>','<%=blogger.getName()%>')"><i class="glyphicon glyphicon-comment"></i>
															评论</a></li>
													<li><a><i class="glyphicon glyphicon-thumbs-up"></i>
															点赞</a></li>
													<li><a><i class="glyphicon glyphicon-yen"></i>
															打赏</a></li>
													<%if(blogger.getPermission()==1){ %>
													<li><a><i class="glyphicon glyphicon-yen"></i>
															删除</a></li>		
															<%} %>
												</ul>
												<p class="whole">
													<a>查看全文&nbsp;&nbsp;&nbsp;</a><a><b
														class="caret"></b></a>
												</p>
												<br/>
											</div>
											<br/>
											<br/>
											<!-- 在这里添加评论框 -->
								<div class="commend">
								</div>
								<!-- 评论区 -->
								
								<label>评论列表</label>
								<div id="allcomment">
								<!-- 从数据库中读取评论信息并展示 -->
								<%
									List<Comment> list_comment=ContentMgr.getInstance().getAllCommentsByBlogid(articleTemp.getNumber());
								  for(Comment comm : list_comment){%>
									<p><%=comm.getSendBloggerName()%>  回复    <%=comm.getAimBloggerName()%> ： <%=comm.getContent()%> </p>
									<%} %>
								</div>
										</div>
										<%
											}
										%>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="${ctx}/bootstrap/js/jquery-2.0.0.js"></script>
		<script src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
		<script>
		function onBtnComment(blogid,bloggername,mebloggername){
		//	alert(str);
			var commentdiv=$('#'+blogid).find('.commend');
		    if(commentdiv.children('textarea').length==0){
		    	var inputArea="<textarea style=\"width:100%\" rows=\"4\" cols=\"100px\">写评论</textarea> <br/> <button type=\"button\" class=\"btn btn-info\">发表评论</button>";
		    	commentdiv.append(inputArea);
				var btn_submit=commentdiv.children('button');
				//点击提交
				btn_submit.click( function () { 
					var commentText=commentdiv.children('textarea').val();
					$.post(
					"releaseComment.do",
					{content:commentText,articleNumber:blogid,aimBloggerName:bloggername},
					function(data){
						commentdiv.empty();
						//在这里刷新评论列表
						var allcommentdiv=$('#'+blogid).find('#allcomment');
						var com="<p>"+mebloggername+"  回复   "+bloggername+" : "+commentText+"</p>";
						allcommentdiv.append(com);
						commentdiv.empty();
					})
				});
		    }else{
		    	commentdiv.empty();
		    }
			return false;//在ie6下，如果不写return false可能有问题。
		}				
		</script>
		<!-- 添加关注 -->
		<script>
		function onBtnBeFriends(){
			$.post(
					"onAddFriend.do",
					function(data){
						alert("关注成功");
					})
		}
		</script>
		<!-- 取消关注 -->
		<script>
		function onBtnNotBeFriends(){
			$.post(
					"onCancelFriend.do",
					function(data){
						alert("取消成功");
					})
		}
		</script>
			
	</layout:component>
</layout:render>