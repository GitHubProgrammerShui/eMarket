<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="prop" uri="http://www.shui.com/el/PropertiesReader"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>商品添加页面</title>
	<style type="text/css">
		#add_area{width: 800px;height: 500px;margin: auto;}
		#add_frame{margin: auto;}
	</style>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ajaxupload.3.6.js"></script>
	<script type="text/javascript">
		var imgPath="${prop:getStringValue('imgRootUrl')}";
		function upload(uploadBtn,img,imgInput){
			new AjaxUpload(uploadBtn,{
				"action":"${pageContext.request.contextPath}/admin/goods/upload",
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
</head>
<body>
	<div id="add_area">
		<label>${requestScope.tips}</label>
		<form action="${pageContext.request.contextPath}${requestScope.url}" method="post">
			<table id="add_frame">
				<c:choose>
					<c:when test="${requestScope.initParams['goods'] != null}">
					<caption>修改商品</caption>
					<tr>
						<td>商品编号</td>
						<td>${requestScope.initParams['goods'].id}<input name="id" value="${requestScope.initParams['goods'].id}" type="hidden"></td>
					</tr>
					</c:when>
					<c:otherwise>
					<caption>添加商品</caption>
					</c:otherwise>
				</c:choose>
				<tr>
					<td>商品名称</td>
					<td><input name="name" placeholder="请输入商品名称" required="required" value="${requestScope.initParams['goods'].name}"/></td>
				</tr>
				<tr>
					<td>商品价格</td>
					<td><input name="price" placeholder="请输入商品价格" required="required" pattern="([0-9]+)\.?[0-9]*" value="${requestScope.initParams['goods'].price}"/></td>
				</tr>
				<tr>
					<td>商品状态</td>
					<td>
						<select name="status">
							<option value="0" <c:if test="${requestScope.initParams['goods'].status==0}">selected="selected"</c:if>>下架</option>
							<option value="1" <c:if test="${requestScope.initParams['goods'].status==1}">selected="selected"</c:if>>原价销售</option>
							<option value="2" <c:if test="${requestScope.initParams['goods'].status==2}">selected="selected"</c:if>>精品销售</option>
							<option value="3" <c:if test="${requestScope.initParams['goods'].status==3}">selected="selected"</c:if>>已售完</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<img height="200px" id="image" alt="" src="${prop:getStringValue('imgRootUrl')}${requestScope.initParams['goods'].image}">
					</td>
				</tr>
				<tr>
					<td>商品照片</td>
					<td>
						<input id="imgPath" name="image" type="hidden" value="${requestScope.initParams['goods'].image}">
						<button id="uploadImage" type="button">上传图片</button>
					</td>
				</tr>
				<tr>
					<td>商品品牌</td>
					<td>
						<select name="brandId">
						<!-- 这里使用foreach循环查出所有品牌选项 -->
						<c:forEach items="${requestScope.initParams['brandList']}" var="brand">
							<option value="${brand.id}" <c:if test="${requestScope.initParams['goods'].brand.id==brand.id}">selected="selected"</c:if>>${brand.name}</option>
						</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>商品类型</td>
					<td>
						<select name="typeId">
						<!-- 这里使用foreach循环查出所有类型 -->
						<c:forEach items="${requestScope.initParams['typeList']}" var="type">
							<option value="${type.id}" <c:if test="${requestScope.initParams['goods'].type.id==type.id}">selected="selected"</c:if>>${type.name}</option>
						</c:forEach>
						</select>
					</td>
				</tr> 
				<tr>
					<td>商品信息</td>
					<td><textarea name="content" rows="10" cols="20" style="resize:none">${requestScope.initParams['goods'].content}</textarea></td>
				</tr>
				<tr>
					<td><input type="submit" value="保存"/></td>
					<td><input type="reset" value="取消"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>