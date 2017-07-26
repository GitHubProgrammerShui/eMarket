<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>页面从此处开始</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/admin/worker/fetch" method="post">
		<table>
			<tr>
				<td>用户名</td>
				<td><input name="username"></td>
			</tr>
			<tr>
				<td>角色</td>
				<td>
					<select name="role">
						<option value="">全部</option>
						<option value="boss">店主</option>
						<option value="employee">店员</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input name="name"></td>
			</tr>
			<tr>
				<td><input type="submit" value="搜索"></td>
				<td><input type="reset" value="取消"></td>
			</tr>
		</table>
	</form>
	<table>
		<tr>
			<th>用户名</th>
			<th>姓名</th>
			<th>角色</th>
			<th>所属商店编号</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope['fetchResult'].workerList}" var="worker">
			<tr>
				<td align="center">${worker.username}</td>
				<td align="center">${worker.name}</td>
				<td align="center">
					<c:choose>
						<c:when test="${worker.role=='boss'}">店主</c:when>
						<c:when test="${worker.role=='employee'}">店员</c:when>
					</c:choose>
				</td>
				<td align="center">${worker.marketId}</td>
				<td align="center">
					<a href="${pageContext.request.contextPath}/admin/worker/initUpdate?username=${worker.username}">修改</a>
					<a href="${pageContext.request.contextPath}/admin/worker/remove?username=${worker.username}">删除</a>
					<a href="${pageContext.request.contextPath}/admin/worker/getDetail?username=${worker.username}">查看明细</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>