<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>订单列表</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript">
	</script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/admin/order/fetch" method="post">
		<table>
			<tr>
				<td>起始时间</td>
				<td><input name="startCreateTime" type="date"></td>
				<td>结束时间</td>
				<td><input name="endCreateTime" type="date"></td>
				<td><input type="submit" value="检索"></td>
			</tr>
		</table>
	</form>
	<table id="order">
		<tr>
			<th>订单号</th>
			<th>创建时间</th>
			<th>金额</th>
			<th>数量</th>
			<th>状态</th>
			<th>商品名称</th>
			<th>处理商店</th>
			<th>用户名</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.orderList}" var="order">
		<tr>
			<td align="center">${order.id}</td>
			<td align="center" width="300px"><fmt:formatDate value="${order.createTime}" pattern="yyyy年MM月dd日  HH:mm:ss"/></td>
			<td align="center">${order.amount}</td>
			<td align="center">${order.quantity}</td>
			<td align="center">
				<c:choose>
					<c:when test="${order.status==0}">待处理</c:when>
					<c:when test="${order.status==1}">用户已取消</c:when>
					<c:when test="${order.status==2}">处理中</c:when>
					<c:when test="${order.status==3}">已拒绝</c:when>
					<c:when test="${order.status==4}">已完成</c:when>
					<c:when test="${order.status==5}">处理失败</c:when>
				</c:choose>
			</td>
			<td align="center">${order.goods.name}</td>
			<td align="center">${order.market.id}</td>
			<td align="center">${order.customer.name}</td>
			<td>
				<c:choose>
					<c:when test="${order.status==0}">
						<a href="${pageContext.request.contextPath}/admin/order/handle?id=${order.id}">处理</a>
						<a href="${pageContext.request.contextPath}/admin/order/refuse?id=${order.id}">拒绝</a>
					</c:when>
					<c:when test="${order.status==2}">
						<a href="${pageContext.request.contextPath}/admin/order/complete?id=${order.id}">完成</a>
						<a href="${pageContext.request.contextPath}/admin/order/stop?id=${order.id}">停止</a>
					</c:when>
				</c:choose>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>