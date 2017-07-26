<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>页面从此处开始</title>
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
		<form action="${pageContext.request.contextPath}/admin/brand/fetch" method="post">
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
					<td>最低星级</td>
					<td><input name="lowestLevel" type="number"></td>
				</tr>
				<tr>
					<td>最高星级</td>
					<td><input name="highestLevel" type="number"></td>
				</tr>
				<tr>
					<td>起始时间</td>
					<td><input name="startCreateTime" type="date"></td>
				</tr>
				<tr>
					<td>结束时间</td>
					<td><input name="stopCreateTime" type="date"></td>
				</tr>
				<tr>
					<td>国家</td>
					<td><input name="country" type="text"></td>
				</tr>
				<tr>
					<td><input type="submit" value="搜索"></td>
					<td><input type="reset" value="取消"></td>
				</tr>
			</table>
		</form>
		<table id="brand_list">
			<caption>品牌列表</caption>
			<tr>
				<th>编号</th>
				<th>名称</th>
				<th>国家</th>
				<th>创建时间</th>
				<th>星级</th>
				<th>备注</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${requestScope.brandList}" var="brand">
			<tr style="background-color: #ABDDEC">
				<td width="150px">${brand.id}</td>
				<td width="50px">${brand.name}</td>
				<td width="50px">${brand.country}</td>
				<td width="250px"><fmt:formatDate value="${brand.createTime}" pattern="yyyy年HH月dd日  HH:mm:ss"/></td>
				<td width="50px">${brand.level}</td>
				<td width="200px">${brand.comment}</td>
				<td width="150px">
					<a href="${pageContext.request.contextPath}/admin/brand/initUpdate?id=${brand.id}">修改</a>&nbsp;
					<a href="${pageContext.request.contextPath}/admin/brand/remove?id=${brand.id}">删除</a>
				</td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="7" align="center">
					<label style="line-height:100%">${requestScope.tips}</label>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>