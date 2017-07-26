<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="TopInfo">
	<div class="link">
		<div style="float: left;">
			<a href="${pageContext.request.contextPath}/index.jsp">e家商城</a>
			<c:choose>
				<c:when test="${sessionScope.customer!=null}">
					<label>您好，${sessionScope.customer.name}</label>
				</c:when>
				<c:otherwise>
					<a href="#" onclick="show();return false;">登陆</a>
					<a href="${pageContext.request.contextPath}/register">注册</a>
				</c:otherwise>
			</c:choose>
		</div>
		<div style="float: right;">
			<c:if test="${sessionScope.customer!=null}">
				<a href="${pageContext.request.contextPath}/auth/user/currentUser">我的信息</a>
				<a href="${pageContext.request.contextPath}/auth/logout">注销登录</a>
			</c:if>
		</div>
	</div>
</div>