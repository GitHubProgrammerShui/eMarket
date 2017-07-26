<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html style="height: 100%;overflow:hidden;">
<head>
	<meta charset="UTF-8">
	<title>网站后台主页面</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/emarket-admin-index.js"></script>
	<style type="text/css" src="index.css"></style>
	<style type="text/css">
		#main{width:100%;height:inherit;}
		#top{width:100%;height:16%;background-color: #438EB9}
		#menu{width:13%;height:84%;float:left;background-color: #F2F2F2;}
		#content{width:87%;height:84%;float:left}
		a{text-decoration: none;}
		ul{margin:0px;padding-left:0px;list-style-type: none;list-style-position: inside;}
		#main_menu .item_sum{width: 100%;height: 30px;line-height: 30px;text-align: center;}
		#main_menu .item_sum:hover{background-color: #C1C1C1;}
		.item{width: 100%;height: 30px;line-height: 30px;text-align: center;background-color: #ABDDEC;}
		.item:hover{background-color: #1AB2E0;}
	</style>
</head>
<body style="margin: 0px;width: 100%;height: 100%">
	<div id="main">
		<div id="top">
			<img src="${pageContext.request.contextPath}/resources/images/logo.png">
			<div style="width: 400px;height: 50px;background-color: white;display: inline-block;position: absolute;top: 25px;right: 100px;">
				<div style="width: 300px;height: 50px;background-color: #62A8D1;text-align: center;float: left;line-height: 50px;">
					<font id="time" style="font-family:方正新舒体简体;font-size: 18px"></font>
				</div>
				<div style="width: 2px;height: 50px;float: left;"></div>
				<div id="admin" style="width: 98px;height: 50px;background-color: #62A8D1;text-align: center;float: left;line-height: 50px;cursor: pointer;">${sessionScope.worker.name}</div>
			</div>
		</div>
		<div id="menu">
			<div id="main_menu">
				<div class="item_sum" onclick="handleMenuItem(this)">
					<font style="cursor:pointer;">商品管理</font>
				</div>
				<ul id="products_menu" style="display:none;background-color:#A1A1A1;height: auto;">
					<li>
						<div class="item">
							<a href="${pageContext.request.contextPath}/admin/goods/init/save" target="content_frame">&nbsp;&nbsp;添加商品&nbsp;&nbsp;</a>
						</div>
					</li>
					<li>
						<div class="item">
							<a href="${pageContext.request.contextPath}/admin/goods/showGoods" target="content_frame">&nbsp;查看所有商品&nbsp;</a>
						</div>
					</li>
				</ul>
				<div class="item_sum" onclick="handleMenuItem(this)">
					<font style="cursor:pointer;">品牌管理</font>
				</div>
				<ul id="brands_menu" style="display:none;background-color:#A1A1A1;">
					<li>
						<div class="item">
							<a href="${pageContext.request.contextPath}/admin/view/items-brand-save" target="content_frame">&nbsp;&nbsp;添加品牌&nbsp;&nbsp;</a>
						</div>
					</li>
					<li>
						<div class="item">
							<a href="${pageContext.request.contextPath}/admin/brand/fetch" target="content_frame">&nbsp;品牌列表&nbsp;</a>
						</div>
					</li>
				</ul>
				<div class="item_sum" onclick="handleMenuItem(this)">
					<font style="cursor:pointer;">类型管理</font>
				</div>
				<ul id="types_menu" style="display:none;background-color:#A1A1A1;">
					<li>
						<div class="item">
							<a href="${pageContext.request.contextPath}/admin/view/items-type-saveorupdate" target="content_frame">&nbsp;&nbsp;添加类型&nbsp;&nbsp;</a>
						</div>
					</li>
					<li>
						<div class="item">
							<a href="${pageContext.request.contextPath}/admin/type/fetch" target="content_frame">&nbsp;类型列表&nbsp;</a>
						</div>
					</li>
				</ul>
				<div class="item_sum" onclick="handleMenuItem(this)">
					<font style="cursor:pointer;">订单管理</font>
				</div>
				<ul id="orders_menu" style="display:none;background-color:#A1A1A1;">
					<li>
						<div class="item">
							<a href="${pageContext.request.contextPath}/admin/order/fetch?marketId=${sessionScope.market.id}" target="content_frame">&nbsp;&nbsp;搜索订单&nbsp;&nbsp;</a>
						</div>
					</li>
				</ul>
				<div class="item_sum" onclick="handleMenuItem(this)">
					<font style="cursor:pointer;">库存管理</font>
				</div>
				<ul id="factorys_menu" style="display:none;background-color:#A1A1A1;">
					<li>
						<div class="item">
							<a href="${pageContext.request.contextPath}/admin/view/items-factory-save" target="content_frame">&nbsp;&nbsp;添加&nbsp;&nbsp;</a>
						</div>
						<div class="item">
							<a href="${pageContext.request.contextPath}/admin/factory/fetch?marketId=${sessionScope.market.id}" target="content_frame">&nbsp;&nbsp;查看&nbsp;&nbsp;</a>
						</div>
					</li>
				</ul>
				<c:if test="${sessionScope.worker.role=='boss'}">
				<div class="item_sum" onclick="handleMenuItem(this)">
					<font style="cursor:pointer;">人员管理</font>
				</div>
				<ul id="sys_menu" style="display:none;background-color:#A1A1A1;">
					<li>
						<div class="item">
							<a href="${pageContext.request.contextPath}/admin/worker/fetch" target="content_frame">&nbsp;&nbsp;查看人员&nbsp;&nbsp;</a>
						</div>
						<div class="item">
							<a href="${pageContext.request.contextPath}/admin/view/items-worker-add" target="content_frame">&nbsp;&nbsp;添加人员&nbsp;&nbsp;</a>
						</div>
					</li>
				</ul>
				</c:if>
			</div>
		</div>
		<div id="content">
			<div style="width: 100%;height:100%;line-height: 0px;border:0px">
				<iframe width="100%" height="100%" name="content_frame" src="${pageContext.request.contextPath}/hello.jsp" style="border: 0px"></iframe>
			</div>
		</div>
	</div>
</body>
</html>