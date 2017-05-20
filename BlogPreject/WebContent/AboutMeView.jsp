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
							<div class="row"></div>
							<form class="form-group" action="login.do" method="post">
								<div class="person_info">
									<img src="pictures/head1.jpg" class="img-responsive"
									alt="Responsive image">
								</div>					
								<button class="btn btn-primary" type="submit">更换头像</button>
								<div class="form-group">
									<label for="">用户名</label> <input name="username"
										class="form-control" type="text" placeholder="">
								</div>
								<div class="form-group">
									<label for="">密码</label> <input name="password"
										class="form-control" type="password" placeholder="">
								</div>
								<div class="text-right">
									<button class="btn btn-primary" type="submit">修改资料</button>
									<button class="btn btn-primary" type="submit">提交</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</layout:component>
</layout:render>