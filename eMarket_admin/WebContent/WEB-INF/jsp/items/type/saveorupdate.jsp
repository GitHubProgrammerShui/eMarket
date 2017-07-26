<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>页面从此处开始</title>
	<style type="text/css">
		#add_area{
			width: 600px;
			height: auto;
			margin-left: auto;
			margin-right: auto;
		}
		#add_table{
			margin-left: auto;
			margin-right: auto;
		}
	</style>
</head>
<body>
	<label>${requestScope.tips}</label>
	<div id="add_area">
		<form action="${pageContext.request.contextPath}/admin/type/save" method="post">
			<table id="add_table">
				<tr>
					<td>类型名称</td>
					<td><input name="name"/></td>
				</tr>
				<tr>
					<td>备注</td>
					<td>
						<textarea name="comment" rows="10" cols="20" style="resize:none;"></textarea>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="添加品牌"/></td>
					<td><input type="reset" value="取消"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>