<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>页面从此处开始</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/admin/brand/save" method="post">
		<table>
			<tr>
				<td>名称</td>
				<td><input name="name"></td>
			</tr>
			<tr>
				<td>国家</td>
				<td><input name="country"></td>
			</tr>
			<tr>
				<td>等级</td>
				<td><input name="level"></td>
			</tr>
			<tr>
				<td><input type="submit" value="保存"></td>
				<td><input type="reset" value="取消"></td>
			</tr>
		</table>
	</form>
</body>
</html>