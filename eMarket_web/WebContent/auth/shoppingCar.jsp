<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>E家商城-商品信息</title>
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/inner.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/common.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/functions.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/myjs.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.1.4.2-min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/Calculation.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".deleteProductFromShoppingCar").click(function(){
			var tag = confirm("确定删除该商品？");
				if(tag==true){
				$("#productForShoppingCar").remove();
			}	
		});
	});
</script>
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
							href="productDetail.jsp">购物车</a> </span>
					</div>
					<!--main start-->
					<div class="main">

						<!--content start-->
						<div class="content">
							<div class="MorePro">
								<div class="CaseBlock"></div>
							</div>
						</div>
						<div class="clearfix"></div>
						<div class="t_page ColorLink">
							<div class="Sbox">
								<form action="" method="post">
									<table style="font-family:Microsoft Yahei;" width="685"
										border="0" cellspacing="0" cellpadding="0">
										<tr style=" background-color: #099; height:3px;">
											<td colspan="6"></td>

										</tr>
										<tr style=" background-color: #9CF">
											<th height="24" colspan="2">商品</th>
											<th width="217">商品信息</th>
											<th width="97">数量</th>
											<th width="100">单价</th>
											<th width="78">操作</th>

										<!-- 取出session中的购物车中的商品 -->
										</tr>
										<tr height="10px">
											<td colspan="6">&nbsp;</td>
										</tr>
										<tr style="background-color: #FFC" id="productForShoppingCar">
											<td width="50" height="50"><img
												src="${pageContext.request.contextPath}/resources/img/201252315108.jpg"
												width="50" height="50" /></td>
											<td width="129"><div align="center">${商品名称}</div></td>
											<td><div align="center">${商品名称}</div></td>
											<td><div align="center">${商品名称}</div></td>
											<td><div align="center">${商品名称}</div></td>
											<td><div align="center">
												<input type="button" class="deleteProductFromShoppingCar" style="border:none;width:16px;height:16px;background-image: url('img/delete_16.png');"/>
												</div></td>
										</tr>
										<tr height="10px">
											<td colspan="6">&nbsp;</td>
										</tr>
										<!--  -->
										<tr>
											<td height="45" colspan="5"><div align="right">
													<label style="font-size:15px">合计:</label>
													<label style="font-size:23px;color:red">${商品总价格}</label>
												</div></td>
											<td><div align="center">
													<input type="submit" value="结算"
														style="font-size:20px; border:none;padding:11px;background-color:indianred;color: white"/>
												</div></td>

										</tr>
									</table>
								</form>

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
