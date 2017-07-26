<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>页面从此处开始</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/login" method="post">
		<table>
			<tr>
				<td>用户名</td>
				<td><input name="username"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input name="password" type="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="登录"></td>
				<td><input type="reset" value="取消"></td>
			</tr>
		</table>
	</form>
</body>
</html>