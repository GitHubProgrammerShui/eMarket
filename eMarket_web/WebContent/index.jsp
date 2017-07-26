<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>e家商城</title>

<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css">
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
						<a href="index.jsp"> <img src="${pageContext.request.contextPath}/resources/img/logo.jpg" alt="E家商城">
						</a>
					</div>
					<div class="menu" style="float:right; ">
						<form action="${pageContext.request.contextPath}/product/fetch" method="post">
						
							<select style="height: 30px;" name="mode">
								<option value="0">商品名称</option>
								<option value="1">商品品牌</option>
								<option value="2">商品类型</option>
							</select> 
							<input type="text" placeholder="请输入您要查询的商品信息"
								style="width: 200px;height: 30px;" name="key"/> 
							<input type="submit" value="搜索" style="height:30px; border:#DCDCDC 1px solid;"/>
						</form>
					</div>

				</div>
			</div>
		</div>
		<div style="height:10px;"></div>
		<!--head end-->
		<!--body start-->
		<div id="body">
			<!--focus start-->
			<div id="Focus">
				<ul style="left:-2582.7827318080817px;width:3920px;">
					<li><a href="#" target="_blank"> <img src="${pageContext.request.contextPath}/resources/img/1.jpg"
							alt="热卖商品"> </a>
					</li>
					<li><a href="#" target="_blank"> <img src="${pageContext.request.contextPath}/resources/img/2.jpg"
							alt="热卖商品"> </a>
					</li>
					<li><a href="#" target="_blank"> <img src="${pageContext.request.contextPath}/resources/img/3.jpg"
							alt="热卖商品"> </a>
					</li>
					<li><a href="#" target="_blank"> <img src="${pageContext.request.contextPath}/resources/img/4.jpg"
							alt="热卖商品"> </a>
					</li>
				</ul>
			</div>
			<!--foncus end -->

			<div class="HeightTab clearfix"></div>
			<!--MainBlock start-->
			<div class="MainBlock">
				<!--left start-->
				<div class="left">
					<div class="topic">
						<div class="TopicTitle">新闻动态 News</div>
						<div class="TopicMore">
							<a href="#"><img src="${pageContext.request.contextPath}/resources/img/more.png"> </a>
						</div>
					</div>
					<div class="HeightTab clearfix"></div>

					<table id="MBlockTable" width="100%" border="0" cellspacing="0"
						cellpadding="0">
						<tbody>
							<tr>
								<td width="75%">· <a href="#" target="_blank"
									title="雅虎或出售亚洲资产推动阿里巴巴集团IPO">雅虎或出售亚洲资产推动阿里巴巴集团IPO</a></td>
								<td width="25%"><span>2012/5/23</span></td>
							</tr>
						</tbody>
					</table>
				</div>
				<!--left end-->

				<div class="WidthTab"></div>
				<!--right start-->
				<div class="right2" style="width:550px;">
					<div class="topic">
						<div class="TopicTitle">折扣专区</div>
						<div class="TopicMore">
							<a href="#"><img src="${pageContext.request.contextPath}/resources/img/more.png"> </a>
						</div>
					</div>
					<div class="img">
						<div style="width: 160px;height: 100px; float: left">
							<img src="${pageContext.request.contextPath}/resources/img/Contact_img.jpg" width="160" height="100"
								alt="联系方式">
							<div class="txt ColorLink">
								<div style="padding-left:5px;">
									<p>
										<strong>传入折扣商品名称</strong>
									</p>
									<p>
										折扣:<label>传入折扣值</label>
									</p>
									<p>
										品牌:<label>传入品牌名</label>
									</p>
									<p>
										类型:<label>传入类型名</label>
									</p>
									<p>
										<label style="color: red">会员价：<label
											style="color: red;font-size: 15px;">传入价格*折扣数</label></label>
									</p>
								</div>
							</div>
						</div>
						<div style="width: 160px;height: 100px; float: left">
							<img src="${pageContext.request.contextPath}/resources/img/Contact_img.jpg" width="160" height="100"
								alt="联系方式" style="margin-left: 20px;">
							<div class="txt ColorLink">
								<div style="padding-left:10px;">
									<p>
										<strong>传入折扣商品名称</strong>
									</p>
									<p>
										折扣:<label>传入折扣值</label>
									</p>
									<p>
										品牌:<label>传入品牌名</label>
									</p>
									<p>
										类型:<label>传入类型名</label>
									</p>
									<p>
										<label style="color: red">会员价：<label
											style="color: red;font-size: 15px;">传入价格*折扣数</label> </label>
									</p>
								</div>
							</div>
						</div>
						<div style="width: 160px;height: 100px; float: left">
							<img src="${pageContext.request.contextPath}/resources/img/Contact_img.jpg" width="160" height="100"
								alt="联系方式" style="margin-left: 20px; ">
							<div class="txt ColorLink">
								<div style="margin-left:10px;">
									<p>
										<strong>传入折扣商品名称</strong>
									</p>
									<p>
										折扣:<label>传入折扣值</label>
									</p>
									<p>
										品牌:<label>传入品牌名</label>
									</p>
									<p>
										类型:<label>传入类型名</label>
									</p>
									<p>
										<label style="color: red">会员价：<labelstyle="color:red;font-size: 15px;">传入价格*折扣数

											
										</label> </label>
									</p>
								</div>
							</div>
						</div>
					</div>
					<div class=" clearfix"></div>
				</div>
			</div>
			<!--right end-->

			<!--MainBlock end-->
			<div class="HeightTab clearfix"></div>
			<!--ProductShow start-->
			<div class="ProductShow">
				<div class="topic">
					<div class="TopicTitle">商品专区</div>
					<div class="TopicMore">
						<a href="#"><img src="${pageContext.request.contextPath}/resources/img/more.png"> </a>
					</div>
				</div>
				<div class="hjnavleft">
					<ul>
						<li id="1" onclick="s(1)">主板</li>
						<li id="2" class="hover1" onclick="s(2)">显示器</li>
						<li id="3" onclick="s(3)">内存</li>
						<li id="4" onclick="s(4)">键盘</li>
						<li id="5" onclick="s(5)">鼠标</li>
						<li id="6" onclick="s(6)">原装台式</li>
						<li id="7" onclick="s(7)">显卡</li>
						<li id="8" onclick="s(8)">网卡</li>
						<li id="9" onclick="s(9)">笔记本</li>
						<li id="10" onclick="s(10)">硬盘</li>
					</ul>
				</div>

				<div class="hjnavcn">

					<div id="u1" class="hjone" style="display:none; ">
						<div class="albumblock">
							<div class="inner">
								<a href="#" target="_blank" title="艾诺 高清大屏MP4触摸+按键"> <img
									src="${pageContext.request.contextPath}/resources/img/20111210171953.jpg" width="166" height="166">
									<div class="albumtitle">艾诺 高清大屏MP4触摸+按</div> </a>
							</div>
						</div>
					</div>
					<div id="u2" class="hjone" style="display:block;">
						<div class="albumblock">
							<div class="inner">
								<a href="#" target="_blank"
									title="联想手机: 5寸HD屏四核安卓 联想K860仅售2000出头"> <img
									src="${pageContext.request.contextPath}/resources/img/201299145547.jpg" width="166" height="166">
									<div class="albumtitle">联想手机: 5寸HD屏四核安</div> </a>
							</div>
						</div>
					</div>
					<div id="u3" class="hjone" style="display: none; ">
						<div class="albumblock">
							<div class="inner">
								<a href="#" target="_blank" title="台电P76TI 8G 平板电脑"> <img
									src="${pageContext.request.contextPath}/resources/img/2011121017127.jpg" width="166" height="166">
									<div class="albumtitle">台电P76TI 8G 平板电</div> </a>
							</div>
						</div>
					</div>
					<div id="u4" class="hjone" style="display: none; ">
						<div class="albumblock">
							<div class="inner">
								<a href="#" target="_blank" title="7寸雷达一体机 中恒G7PRO豪华版2680">
									<img src="${pageContext.request.contextPath}/resources/img/201252315514.jpg" width="166" height="166">
									<div class="albumtitle">7寸雷达一体机 中恒G7PR</div> </a>
							</div>
						</div>
					</div>
					<div id="u5" class="hjone" style="display: none; ">
						<div class="albumblock">
							<div class="inner">
								<a href="#" target="_blank" title="商务气质浓郁 惠普6560B仅售6K1元"> <img
									src="${pageContext.request.contextPath}/resources/img/201252315108.jpg" width="166" height="166">
									<div class="albumtitle">商务气质浓郁 惠普6560B</div> </a>
							</div>
						</div>
					</div>
					<div id="u6" class="hjone" style="display:none;">
						<div class="albumblock">
							<div class="inner">
								<a href="#" target="_blank" title="商务气质浓郁 惠普6560B仅售6K1元"> <img
									src="${pageContext.request.contextPath}/resources/img/201252315108.jpg" width="166" height="166">
									<div class="albumtitle">商务气质浓郁 惠普6560B</div> </a>
							</div>
						</div>
					</div>
					<div id="u7" class="hjone" style="display:none;">
						<div class="albumblock">
							<div class="inner">
								<a href="#" target="_blank" title="商务气质浓郁 惠普6560B仅售6K1元"> <img
									src="${pageContext.request.contextPath}/resources/img/201252315108.jpg" width="166" height="166">
									<div class="albumtitle">商务气质浓郁 惠普6560B</div> </a>
							</div>
						</div>
					</div>
					<div id="u8" class="hjone" style="display:none;">
						<div class="albumblock">
							<div class="inner">
								<a href="#" target="_blank" title="商务气质浓郁 惠普6560B仅售6K1元"> <img
									src="${pageContext.request.contextPath}/resources/img/201252315108.jpg" width="166" height="166">
									<div class="albumtitle">商务气质浓郁 惠普6560B</div> </a>
							</div>
						</div>
					</div>
					<div id="u9" class="hjone" style="display:none;">
						<div class="albumblock">
							<div class="inner">
								<a href="#" target="_blank" title="商务气质浓郁 惠普6560B仅售6K1元"> <img
									src="${pageContext.request.contextPath}/resources/img/201252315108.jpg" width="166" height="166">
									<div class="albumtitle">商务气质浓郁 惠普6560B</div> </a>
							</div>
						</div>
					</div>
					<div id="u10" class="hjone" style="display:none;">
						<div class="albumblock">
							<div class="inner">
								<a href="#" target="_blank" title="商务气质浓郁 惠普6560B仅售6K1元"> <img
									src="${pageContext.request.contextPath}/resources/img/201252315108.jpg" width="166" height="166">
									<div class="albumtitle">商务气质浓郁 惠普6560B</div> </a>
							</div>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<!--ProductShow end-->
			<div class="HeightTab clearfix"></div>
			<!--links start-->

		</div>
		<!--body end-->
		<div class="HeightTab clearfix"></div>
		<!--footer start-->
		<div id="footer">
			<div class="inner">
				<p>
					<a href="#" target="_blank">网站建设</a> | <a href="#" target="_blank">服务条款</a>
					| <a href="#" target="_blank">开放平台</a> | <a href="#"
						target="_blank">广告服务</a> | <a href="#" target="_blank">商务洽谈</a> |
					<a href="#" target="_blank">企业招聘</a> | <a href="#" target="_blank">社会公益</a>
					| <a href="#" target="_blank">客服中心</a> | <a href="#"
						target="_blank">网站导航</a> | <a href="managerLogin.jsp">站内管理</a> |
					<a href="#" target="_blank">站内统计</a><br /> Copyright © 2009 - 2014
					LyWeb. All Rights Reserved <br>
				</p>
			</div>
		</div>
		<!--footer end -->

	</div>

</body>
</html>
