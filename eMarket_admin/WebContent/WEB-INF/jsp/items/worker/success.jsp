<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="prop" uri="http://www.shui.com/el/PropertiesReader"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>页面从此处开始</title>
</head>
<body>
	<c:set var="workerDetail" value="${requestScope.workerDetail}"></c:set>
	<label>${requestScope.tips}</label>
	<table>
		<tr>
			<td>用户名</td>
			<td>${workerDetail.worker.username}</td>
		</tr>
		<tr>
			<td>密码</td>
			<td>${workerDetail.worker.password}</td>
		</tr>
		<tr>
			<td>姓名</td>
			<td>${workerDetail.worker.name}</td>
		</tr>
		<tr>
			<td>角色</td>
			<td>${workerDetail.worker.role}</td>
		</tr>
		<tr>
			<td>所属商城编号</td>
			<td>${workerDetail.worker.marketId}</td>
		</tr>
		<tr>
			<td>工资</td>
			<td>${workerDetail.reward}</td>
		</tr>
		<tr>
			<td>注册时间</td>
			<td><fmt:formatDate value="${workerDetail.registerTime}" pattern="yyyy年MM月dd日  HH:mm:ss"/></td>
		</tr>
		<tr>
			<td>备注</td>
			<td>${workerDetail.comment}</td>
		</tr>
		<tr>
			<td>照片</td>
			<td><img height="100px" alt="" src="${prop:getStringValue('imgRootUrl')}${workerDetail.image}"></td>
		</tr>
		<tr>
			<td>性别</td>
			<td>${workerDetail.sex}</td>
		</tr>
		<tr>
			<td>年龄</td>
			<td>${workerDetail.age}</td>
		</tr>
		<tr>
			<td>身份证号</td>
			<td>${workerDetail.idCard}</td>
		</tr>
		<tr>
			<td>地址</td>
			<td>${workerDetail.address}</td>
		</tr>
		<tr>
			<td>银行卡号</td>
			<td>${workerDetail.accountCardNo}</td>
		</tr>
		<tr>
			<td>电话号码</td>
			<td>${workerDetail.tel}</td>
		</tr>
		<tr>
			<td>电子邮箱</td>
			<td>${workerDetail.email}</td>
		</tr>
		<tr>
			<td>qq</td>
			<td>${workerDetail.qq}</td>
		</tr>
	</table>
</body>
</html>