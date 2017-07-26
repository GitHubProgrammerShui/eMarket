<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="prop" uri="http://www.shui.com/el/PropertiesReader"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>页面从此处开始</title>
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
</head>
<body>
	<form action="${pageContext.request.contextPath}/register" method="post">
		<table>
			<tr>
				<td>姓名</td>
				<td><input name="name"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input name="password"></td>
			</tr>
			<tr>
				<td colspan="2">
					<img alt="" src="" style="min-height: 300px" id="image">
				</td>
			</tr>
			<tr>
				<td>图片</td>
				<td>
					<input type="button" value="选择图片上传" id="uploadImage">
					<input type="hidden" name="image" id="imgPath">
				</td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
					<select name="sex">
						<option value="男">男</option>
						<option value="女">女</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="确认注册"></td>
				<td><input type="reset" value="取消"></td>
			</tr>
		</table>
	</form>
</body>
</html>