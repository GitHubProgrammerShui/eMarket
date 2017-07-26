<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form action="/admin/login" method="post">
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