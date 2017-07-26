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
				"action":"${pageContext.request.contextPath}/admin/worker/upload",
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
			var uploadImg=document.getElementById("workerImg");
			var uploadInput=document.getElementById("imgPath");
			upload(uploadBtn,uploadImg,uploadInput);
		});
	</script>
</head>
<body>
	<label>添加人员</label>
	<form action="${pageContext.request.contextPath}/admin/worker/add" method="post">
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
				<td>角色</td>
				<td>
					<select name="role">
						<option value="boss">店主</option>
						<option value="employee">店员</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>工资</td>
				<td><input name="reward"></td>
			</tr>
			<tr>
				<td>备注</td>
				<td>
					<textarea rows="5" cols="10" name="comment"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<img style="max-height: 300px" alt="" src="" id="workerImg">
				</td>
			</tr>
			<tr>
				<td>图片</td>
				<td>
					<input id="uploadImage" type="button" value="选择图片">
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
				<td>年龄</td>
				<td>
					<input type="number" name="age">
				</td>
			</tr>
			<tr>
				<td>身份证号</td>
				<td><input type="text" name="idCard"></td>
			</tr>
			<tr>
				<td>地址</td>
				<td><textarea rows="5" cols="10" name="address"></textarea></td>
			</tr>
			<tr>
				<td>银行卡号</td>
				<td><input name="accountCardNo"></td>
			</tr>
			<tr>
				<td>电话号码</td>
				<td><input name="tel"></td>
			</tr>
			<tr>
				<td>电子邮箱</td>
				<td><input name="email"></td>
			</tr>
			<tr>
				<td>qq</td>
				<td><input name="qq"></td>
			</tr>
			<tr>
				<td><input type="submit" value="保存"></td>
				<td><input type="reset" value="取消"></td>
			</tr>
		</table>
	</form>
</body>
</html>