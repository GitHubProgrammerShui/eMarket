<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<style type="text/css">
		#list_area{
			width: 600px;
			height: auto;
			margin-left: auto;
			margin-right: auto;
		}
		#brand_list{
			margin-left: auto;
			margin-right: auto;
		}
	</style>
	<script type="text/javascript">
	</script>
</head>
<body>
	<div id="list_area">
		<form action="${pageContext.request.contextPath}/admin/type/fetch" method="post">
			<table>
				<tr>
					<td>品牌编号</td>
					<td><input name="id"></td>
				</tr>
				<tr>
					<td>品牌名称</td>
					<td><input name="name"></td>
				</tr>
				<tr>
					<td>起始时间</td>
					<td><input name="startTime" type="date"></td>
				</tr>
				<tr>
					<td>结束时间</td>
					<td><input name="stopTime" type="date"></td>
				</tr>
				<tr>
					<td>备注</td>
					<td><input name="comment"></td>
				</tr>
				<tr>
					<td><input type="submit" value="查询"></td>
					<td><input type="reset" value="取消"></td>
				</tr>
			</table>
		</form>
		<table id="brand_list">
			<caption>品牌列表</caption>
			<tr>
				<th>编号</th>
				<th>名称</th>
				<th>创建时间</th>
				<th>备注</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${requestScope.typeList}" var="type">
			<tr style="background-color: #ABDDEC">
				<td width="150px">${type.id}</td>
				<td width="50px">${type.name}</td>
				<td width="100px"><fmt:formatDate value="${type.createTime}" pattern="yyyy年MM月dd日  HH:mm:ss"/></td>
				<td width="100px">${type.comment}</td>
				<td width="100px">
					<a href="${pageContext.request.contextPath}/admin/type/initUpdate?id=${type.id}">修改</a>&nbsp;
					<a href="${pageContext.request.contextPath}/admin/type/remove?id=${type.id}">删除</a>
				</td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="5" align="center">
					<label style="line-height:100%">${requestScope.tips}</label>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>