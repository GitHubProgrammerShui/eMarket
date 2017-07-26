<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>页面从此处开始</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/admin/factory/fetch" method="post">
		<table>
			<tr>
				<td>库存编号</td>
				<td><input name="id"></td>
			</tr>
			<tr>
				<td>库存量</td>
				<td>
					<input name="lowestAmount" type="number">
					<input name="highestAmount" type="number">
				</td>
			</tr>
			<tr>
				<td>商品名称</td>
				<td><input name="goodsName"></td>
			</tr>
			<tr>
				<td><input type="submit" value="搜索"></td>
				<td><input type="reset" value="取消"></td>
			</tr>
		</table>
	</form>
	
	<table>
		<tr>
			<th>编号</th>
			<th>商品编号</th>
			<th>商品名</th>
			<th>商品品牌</th>
			<th>商品类型</th>
			<th>库存量</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.factoryItemList}" var="factoryItem">
		<tr>
			<td>${factoryItem.id}</td>
			<td>${factoryItem.goods.id}</td>
			<td>${factoryItem.goods.name}</td>
			<td>${factoryItem.goods.brand.name}</td>
			<td>${factoryItem.goods.type.name}</td>
			<td>${factoryItem.amount}</td>
			<td>
				<a href="${pageContext.request.contextPath}/admin/factory/remove?id=${factoryItem.id}">删除</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>