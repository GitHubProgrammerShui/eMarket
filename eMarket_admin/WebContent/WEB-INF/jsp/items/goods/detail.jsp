<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="prop" uri="http://www.shui.com/el/PropertiesReader"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>页面从此处开始</title>
</head>
<body>
	<table>
		<caption>商品信息</caption>
		<tr>
			<td>商品编号</td>
			<td>${requestScope.goods.id}</td>
			<td>商品名称</td>
			<td>${requestScope.goods.name}</td>
		</tr>
		<tr>
			<td colspan="4">
				<img alt="" src="${prop:getStringValue('imgRootUrl')}${requestScope.goods.image}" height="200px">
			</td>
		</tr>
		<tr>
			<td>商品价格</td>
			<td><fmt:formatNumber value="${requestScope.goods.price}" pattern="0.00"/></td>
			<td>商品状态</td>
			<td>
				<c:choose>
					<c:when test="${requestScope.goods.status==0}">下架</c:when>
					<c:when test="${requestScope.goods.status==1}">原价销售</c:when>
					<c:when test="${requestScope.goods.status==2}">精品销售</c:when>
					<c:when test="${requestScope.goods.status==3}">已售完</c:when>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td>添加时间</td>
			<td colspan="3"><fmt:formatDate value="${requestScope.goods.createTime}" pattern="yyyy年MM月dd日  HH:mm"/></td>
		</tr>
		<tr>
			<td>备注</td>
			<td colspan="3">${requestScope.goods.content}</td>
		</tr>
		<tr>
			<td><input type="button" value="返回" onclick="javascript:history.go(-1);"></td>
		</tr>
	</table>
</body>
</html>