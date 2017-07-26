<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="prop" uri="http://www.shui.com/el/PropertiesReader"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<title>E家商城-商品信息</title>
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/inner.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/functions.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/myjs.js"></script>
</head>

<body>
	<!--弹窗登录窗口  --->
	<%@include file="/include/form.jsp"%>
	<!--弹窗登录窗口结束  --->

	<div id="wrapper">

		<!--head start-->
		<div id="head">

			<!--top start -->
			<div class="top">
				<%@include file="/include/top.jsp"%>

				<div class="clearfix"></div>

				<div class="TopLogo">
					<div class="logo">
						<a href="#"> <img src="${pageContext.request.contextPath}/resources/img/logo.jpg" alt="e家商城"> </a>
					</div>
					<div class="menu"></div>

				</div>
			</div>
		</div>
		<div style="height:10px;"></div>
		<!--head end-->
		<!--body start-->
		<div id="body">
			<!--focus start-->
			<div id="InnerBanner"></div>
			<!--foncus end-->
			<div class="HeightTab clearfix"></div>
			<!--inner start -->
			<div class="inner">
				<!--left start-->
				<div class="left">
					<div class="Sbox">
						<div class="topic">热门产品&nbsp;&nbsp;&nbsp;Hot</div>
						<div class="list">
							<dl>
								<dt>2011/12/10</dt>
								<dd>
									<a href="#" target="_blank" title="昂达GPS导航仪VP80 3D版 四维图新全实景6寸">昂达GPS导航仪VP80
										3</a>
								</dd>
							</dl>
							<dl>
								<dt>2011/12/10</dt>
								<dd>
									<a href="#" target="_blank" title="昂达GPS导航仪VP80 3D版 四维图新全实景6寸">昂达GPS导航仪VP80
										3</a>
								</dd>
							</dl>
							<dl>
								<dt>2011/12/10</dt>
								<dd>
									<a href="#" target="_blank" title="昂达GPS导航仪VP80 3D版 四维图新全实景6寸">昂达GPS导航仪VP80
										3</a>
								</dd>
							</dl>
							<dl>
								<dt>2011/12/10</dt>
								<dd>
									<a href="#" target="_blank" title="昂达GPS导航仪VP80 3D版 四维图新全实景6寸">昂达GPS导航仪VP80
										3</a>
								</dd>
							</dl>
						</div>

					</div>
					<div class="HeightTab clearfix"></div>

				</div>
				<!--left end-->
				<!--right start-->
				<div class="right">
					<div class="Position" style="border-bottom:2px #dcdcdc solid;">
						<span>你的位置：<a href="index.jsp">首页</a> &gt; <a
							href="productDetail.jsp">商品详情</a> </span>
					</div>
					<!--main start-->
					<div class="main">

						<!--content start-->
						<div class="content">
							<div class="MorePro">
								<div class="CaseBlock">
									<ul>
										<div class="albumblock">
											<div style="float: left;">
												<a href="#" target="_blank"
													title="${requestScope.goods.name}"> <img
													src="${prop:getStringValue('imgRootUrl')}${requestScope.goods.image}"
													style="width: 250px;height: 250px;" /></a>
											</div>
											<div style="float: left;width: 400px;">
												<form action="${pageContext.request.contextPath}/auth/initOrderInfo" method="get">
													<table>
														<tr >
															<td colspan="2"><label style="font-size: 17px;"><strong>商品名称:${requestScope.goods.name}</strong>
															</label>
															</td>
														</tr>
														<tr >
															<td colspan="2"><label
																style="font-size: 13px;color: red">${requestScope.goods.content}</label>
															</td>
														</tr>
														<tr style="height: 30px;">
															<td style="width: 50px;"><label
																style="font-size: 13px;color: gray">价格:</label>
															</td>
															<td><label
																style="color: dimgray"><fmt:formatNumber value="${requestScope.goods.price}" pattern="0.00"/></label>
															</td>
														</tr>
														<%-- <tr style="height: 30px;">
															<td style="width: 50px;"><label
																style="font-size: 13px;color: gray">折扣价</label>
															</td>
															<td>
																<label style=";color: red;font-size: 20px;">${折扣价格}折扣价格}</label>&nbsp;
																<label style="border: lightpink 1px solid;background-color: lightpink;color: white">十月钜惠</label>
															</td>
														</tr> --%>
														<tr style="height: 30px;">
															<td><label
																style="font-size: 13px;color: gray">数量</label>
															</td>
															<td>
																<input name="goodsId" type="hidden" value="${requestScope.goods.id}">
																<input type="text" style="width: 50px;height: 20px;" value="1" name="amount"/>&nbsp;&nbsp;
															</td>
														</tr>
														<tr style="height: 100px;">
															<td>
																<input type="submit" value="立即购买" style="width: 150px;height: 40px;border:red 1px solid; background-color: pink;color: red;font-size: 18px;"/>
															</td>
															<!-- <td>
																<input type="submit" value="加入购物车" style="width: 150px;height: 40px;border:red 1px solid; background-color: red;color:white;font-size: 18px;"/>
															</td> -->
														</tr>
	
													</table>
												</form>
											</div>
										</div>
									</ul>
								</div>
							</div>

						</div>
						<div class="clearfix"></div>
						<div class="t_page ColorLink">
							<div class="Sbox">
								<!-- 商品累计评价 -->
								<div class="topic">累计评价</div>
								<%-- <fieldset>
									<legend>${评价会员名 }评价会员名</legend>
									<div class="list" style="float:left ">
										<dl>
											<dt>${商品评论日期 }商品评论日期</dt>
											<dt>${商品评论内容 }商品评论内容</dt>
										</dl>	
									</div>	
								</fieldset> --%>
								<!--添加评论-->	
								<div class="topic">请写下您的评论</div>
								<fieldset >
								<form action="" method="post">
									<div class="list" style="float:left ">
										<textarea style="width:670px;height: 80px;text-align: left;resize:none" name=""> 
										</textarea>
										<input type="submit" value="提交评论"/>
									</div>	
									</form>
								</fieldset>
							</div>
						</div>
					</div>

				</div>
				<!--content end-->

			</div>
			<!--main end-->
		</div>
		<!--right end-->
	</div>
	<!--inner end-->
	</div>
	<!--body end-->
	<div class="HeightTab clearfix"></div>
	<!--footer start-->
	<div id="footer">
		<div class="inner">
			<p>
				<a href="#" target="_blank">网站建设</a> | <a href="#" target="_blank">服务条款</a>
				| <a href="#" target="_blank">开放平台</a> | <a href="#" target="_blank">广告服务</a>
				| <a href="#" target="_blank">商务洽谈</a> | <a href="#" target="_blank">企业招聘</a>
				| <a href="#" target="_blank">社会公益</a> | <a href="#" target="_blank">客服中心</a>
				| <a href="#" target="_blank">网站导航</a> | <a href="#" target="_blank">站内管理</a>
				| <a href="#" target="_blank">站内统计</a><br /> Copyright © 2009 -
				2014 LyWeb. All Rights Reserved <br>
			</p>
		</div>
	</div>
	<!--footer end -->
	</div>

</body>
</html>
