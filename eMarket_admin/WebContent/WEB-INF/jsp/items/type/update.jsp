<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>页面从此处开始</title>
</head>
<body>
	<label>${requestScope.tips}</label>
	<div id="add_area">
		<form action="${pageContext.request.contextPath}/admin/type/update" method="post">
			<table id="add_table">
				<tr>
					<td>类型编号</td>
					<td>${requestScope.type.id}<input name="id" type="hidden" value="${requestScope.type.id}"></td>
				</tr>
				<tr>
					<td>类型名称</td>
					<td><input name="name" value="${requestScope.type.name}"/></td>
				</tr>
				<tr>
					<td>备注</td>
					<td>
						<textarea name="comment" rows="10" cols="20" style="resize:none;">${requestScope.type.comment}</textarea>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="保存"/></td>
					<td><input type="reset" value="取消"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>