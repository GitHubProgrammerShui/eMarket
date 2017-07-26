<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="prop" uri="http://www.shui.com/el/PropertiesReader"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>页面从此处开始</title>
</head>
<body>
	<c:set var="orderMap" value="${sessionScope.orderMap}"/>
	<table>
		<tr>
			<td>商品名</td>
			<td>${orderMap['goods'].name}</td>
		</tr>
		<tr>
			<td>价格</td>
			<td>${orderMap['goods'].price}</td>
		</tr>
		<tr>
			<td>图片</td>
			<td><img alt="" src="${prop:getStringValue('imgRootUrl')}${orderMap['goods'].image}" style="max-height: 300px"></td>
		</tr>
		<tr>
			<td>数量</td>
			<td>${orderMap['amount']}</td>
		</tr>
		<tr>
			<td colspan="2">您的订单已由${orderMap['market'].name}处理</td>
		</tr>
		<tr>
			<td>配送地址</td>
			<td>${orderMap['customerDetail'].address}</td>
		</tr>
		<tr>
			<td>联系电话</td>
			<td>${orderMap['customerDetail'].tel}</td>
		</tr>
		<tr>
			<td><a href="${pageContext.request.contextPath}/auth/submit">确认无误，提交订单</a></td>
		</tr>
	</table>
</body>
</html>