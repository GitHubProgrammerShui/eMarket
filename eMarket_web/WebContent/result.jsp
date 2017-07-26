<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="prop" uri="http://www.shui.com/el/PropertiesReader"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>页面从此处开始</title>
</head>
<body>
	<label>${requestScope.tips}</label>
	<table>
		<tr>
			<td>用户名</td>
			<td>${requestScope.customerDetail.customer.username}</td>
		</tr>
		<tr>
			<td>密码</td>
			<td>${requestScope.customerDetail.customer.password}</td>
		</tr>
		<tr>
			<td>名称</td>
			<td>${requestScope.customerDetail.customer.name}</td>
		</tr>
		<tr>
			<td>用户类型</td>
			<td>${requestScope.customerDetail.customer.userType}</td>
		</tr>
		<tr>
			<td>性别</td>
			<td>${requestScope.customerDetail.sex}</td>
		</tr>
		<tr>
			<td>创建时间</td>
			<td><fmt:formatDate value="${requestScope.customerDetail.createTime}" pattern="yyyy年MM月dd日  HH:mm:ss"/></td>
		</tr>
		<tr>
			<td>图片</td>
			<td><img alt="" src="${prop:getStringValue('imgRootUrl')}${requestScope.customerDetail.image}" style="max-height: 300px"></td>
		</tr>
		<tr>
			<td>等级</td>
			<td>${requestScope.customerDetail.level}</td>
		</tr>
		<tr>
			<td>积分</td>
			<td>${requestScope.customerDetail.score}</td>
		</tr>
	</table>
</body>
</html>