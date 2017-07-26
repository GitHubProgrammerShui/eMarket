<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="prop" uri="http://www.shui.com/el/PropertiesReader"%>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ajaxupload.3.6.js"></script>
<script type="text/javascript">
	var imgPath="${prop:getStringValue('imgRootUrl')}";
	function upload(uploadBtn,img,imgInput){
		new AjaxUpload(uploadBtn,{
			"action":"${pageContext.request.contextPath}/upload",
			"name":"photo",
			"autoSubmit":true,
			"responseType":"json",
			"onSubmit":function(file,ext){
				if(ext!="jpg"&&ext!="jpeg"&&ext!="png"&&ext!="gif"&&ext!="bmp"){
					alert("上传的图片格式不正确（支持jpg，jpeg，png，gif，bmp上传）");
					return false;
				}
			},
			"onComplete":function(file,response){
				if(!response.success){
					alert(response.tips);
				}else{
					$(img).attr("src",imgPath+response.data+"?num="+Math.random());
					$(imgInput).val(response.data);
					$(img).attr("height","300px");
				}
			}
		});
	}
	$(function(){
		var uploadBtn=document.getElementById("uploadImage");
		var uploadImg=document.getElementById("image");
		var uploadInput=document.getElementById("imgPath");
		upload(uploadBtn,uploadImg,uploadInput);
	});
</script>
<style type="text/css">
	#table1 tr{
		text-align: right;
	}
</style>
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
							href="#">用户信息</a>
						</span>
					</div>
					<!--main start-->
					<div class="main">

						<!--content start-->
						<div class="content">
							<div class="MorePro">
								<div class="CaseBlock">
								<form action="${pageContext.request.contextPath}/auth/user/update" method="post">
									<table style="margin-left: 68px;" id="table1">
										<tr>
											<td>账号：</td>
											<td><input type="hidden" value="${requestScope.customerDetail.customer.username}" name="username"/>${requestScope.customerDetail.customer.username}</td>
										</tr>
										<tr>
											<td>密码：</td>
											<td><input type="password" value="${requestScope.customerDetail.customer.password}" name="password"/> </td>
										</tr>
										<tr>
											<td>姓名：</td>
											<td><input type="text" value="${requestScope.customerDetail.customer.name}" name="name"/> </td>
										</tr>
										<tr>
											<td>手机号：</td>
											<td><input type="text" value="${requestScope.customerDetail.tel }" name="tel"/> </td>
										</tr>
										<tr>
											<td>地址：</td>
											<td><input type="text" value="${requestScope.customerDetail.address }" name="address"/> </td>
										</tr>
										<tr>
											<td>邮箱：</td>
											<td><input type="text" value="${requestScope.customerDetail.email }" name="email"/> </td>
										</tr>
										<tr>
											<td>性别：</td>
											<td><input type="text" value="${requestScope.customerDetail.sex }" name="sex"/> </td>
										</tr>
										<tr>
											<td>QQ：</td>
											<td><input type="text" value="${requestScope.customerDetail.qq }" name="qq"/> </td>
										</tr>
										<tr>
											<td colspan="2"><img alt="" src="${prop:getStringValue('imgRootUrl')}${requestScope.customerDetail.image}" height="200px" id="image"></td>
										</tr>
										<tr>
											<td>上传图片：</td>
											<td>
												<input type="button" value="选择图片" id="uploadImage">
												<input name="image" type="hidden" id="imgPath" value="${requestScope.customerDetail.image}">
											</td>
										</tr>
										<tr>
											<td align="center"><input type="submit" value="提交修改"/></td>
											<td></td>
										</tr>
									</table>
									</form>
								</div>
								<div class="clearfix" ></div>
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
					| <a href="#" target="_blank">开放平台</a> | <a href="#"
						target="_blank">广告服务</a> | <a href="#" target="_blank">商务洽谈</a> |
					<a href="#" target="_blank">企业招聘</a> | <a href="#" target="_blank">社会公益</a>
					| <a href="#" target="_blank">客服中心</a> | <a href="#"
						target="_blank">网站导航</a> | <a href="#" target="_blank">站内管理</a> |
					<a href="#" target="_blank">站内统计</a><br /> Copyright © 2009 - 2014
					LyWeb. All Rights Reserved <br>
				</p>
			</div>
		</div>
		<!--footer end -->
	</div>

</body>
</html>
