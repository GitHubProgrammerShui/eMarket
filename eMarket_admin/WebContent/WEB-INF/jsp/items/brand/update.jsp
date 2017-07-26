<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>页面从此处开始</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/admin/brand/update" method="post">
		<table>
			<tr>
				<td>品牌编号</td>
				<td>${requestScope.brand.id}<input name="id" type="hidden" value="${requestScope.brand.id}"></td>
			</tr>
			<tr>
				<td>名称</td>
				<td><input name="name" value="${requestScope.brand.name}"></td>
			</tr>
			<tr>
				<td>国家</td>
				<td><input name="country" value="${requestScope.brand.country}"></td>
			</tr>
			<tr>
				<td>等级</td>
				<td><input name="level" value="${requestScope.brand.level}"></td>
			</tr>
			<tr>
				<td><input type="submit" value="保存"></td>
				<td><input type="reset" value="取消"></td>
			</tr>
		</table>
	</form>
</body>
</html>