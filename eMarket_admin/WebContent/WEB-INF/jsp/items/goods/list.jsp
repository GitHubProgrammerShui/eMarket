<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="prop" uri="http://www.shui.com/el/PropertiesReader"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>页面从此处开始</title>
	<style type="text/css">
			.pro_ele{width:100%;height: 200px;}
			.pro_ele_border{width: 99%;height: 196px;position: relative;top: 2px;border:1px solid gray;margin-left: auto;margin-right: auto;}
			.description{width: 99%;height: 190px;margin-left: auto;
				margin-right: auto;position: relative;top: 3px;}
			.picture{width: 142px;height: 190px;float: left;}
			.describe{width:900px;height:190px;border: 1px solid gray;float: left;}
			#detail_dialog{width:0px;height:0px;position: fixed;top:50px;left: 550px;
				background-color: #438EB9;overflow: auto;}
		</style>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.min.js"></script>
		<script type="text/javascript">
			function showDetail(obj,username){
				$("#detail_frame").attr({"src":"products_detail.jsp?username="+username});
				$("#detail_dialog").animate({"width":"300px","height":"450px","left":"400px"});
			}
			function hideDetailDialog(){
				$("#detail_dialog").animate({"width":"0px","height":"0px","left":"550px"});
			}
		</script>
</head>
<body>
	<c:forEach items="${requestScope.goodsList}" var="goods">
	<div class="pro_ele">
		<div class="pro_ele_border">
			<div class="description">
				<div class="picture">
					<img src="${prop:getStringValue('imgRootUrl')}${goods.image}" width="142px"/>
				</div>
				<div style="width: 20px;height: 190px;float: left"></div>
				<div class="describe">
					<ul style="list-style-type: none;">
						<li><label>商品编号:&nbsp;&nbsp;&nbsp;</label><label>${goods.id}</label></li>
						<li><label>商品名称:&nbsp;&nbsp;&nbsp;</label><label>${goods.name}</label></li>
						<li><label>商品价格:&nbsp;&nbsp;&nbsp;</label><label><fmt:formatNumber value="${goods.price}" pattern="0.00"/></label></li>
						<li>
							<label>商品状态:&nbsp;&nbsp;&nbsp;</label>
							<c:choose>
								<c:when test="${goods.status==0}">下架</c:when>
								<c:when test="${goods.status==1}">原价销售</c:when>
								<c:when test="${goods.status==2}">精品销售</c:when>
								<c:when test="${goods.status==3}">已售完</c:when>
							</c:choose>
						</li>
						<li><label>商品品牌:&nbsp;&nbsp;&nbsp;</label><label>${goods.brand.name}</label></li>
						<li><label>商品类型:&nbsp;&nbsp;&nbsp;</label><label>${goods.type.name}</label></li>
					</ul>
					<ul>
						<li style="display: inline"><a href="${pageContext.request.contextPath}/admin/goods/init/update?id=${goods.id}">修改</a></li>
						<li style="display:inline"><a href="${pageContext.request.contextPath}/admin/goods/remove?id=${goods.id}">删除</a></li>
						<li style="display:inline"><a href="${pageContext.request.contextPath}/admin/goods/getDetail?id=${goods.id}">详细信息</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</c:forEach>
</body>
</html>