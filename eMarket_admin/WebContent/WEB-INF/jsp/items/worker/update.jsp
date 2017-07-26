<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<form action="${pageContext.request.contextPath}/admin/worker/update" method="post">
		<table>
			<tr>
				<td>用户名</td>
				<td>${requestScope.workerDetail.worker.username}<input name="username" type="hidden" value="${requestScope.workerDetail.worker.username}"></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input name="name" value="${requestScope.workerDetail.worker.name}"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input name="password" value="${requestScope.workerDetail.worker.password}"></td>
			</tr>
			<tr>
				<td>角色</td>
				<td>
					<select name="role">
						<option value="boss" <c:if test="${requestScope.workerDetail.worker.role=='boss'}">selected="selected"</c:if>>店主</option>
						<option value="employee" <c:if test="${requestScope.workerDetail.worker.role=='employee'}">selected="selected"</c:if>>店员</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>工资</td>
				<td><input name="reward" value="${requestScope.workerDetail.reward}"></td>
			</tr>
			<tr>
				<td>备注</td>
				<td>
					<textarea rows="5" cols="10" name="comment">${requestScope.workerDetail.comment}</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<img style="max-height: 300px" alt="" src="${prop:getStringValue('imgRootUrl')}${requestScope.workerDetail.image}" id="workerImg">
				</td>
			</tr>
			<tr>
				<td>图片</td>
				<td>
					<input id="uploadImage" type="button" value="选择图片">
					<input type="hidden" name="image" id="imgPath" value="${requestScope.workerDetail.image}">
				</td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
					<select name="sex">
						<option value="男" <c:if test="${requestScope.workerDetail.sex=='男'}">selected="selected"</c:if>>男</option>
						<option value="女" <c:if test="${requestScope.workerDetail.sex=='女'}">selected="selected"</c:if>>女</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>年龄</td>
				<td>
					<input type="number" name="age" value="${requestScope.workerDetail.age}">
				</td>
			</tr>
			<tr>
				<td>身份证号</td>
				<td><input type="text" name="idCard" value="${requestScope.workerDetail.idCard}"></td>
			</tr>
			<tr>
				<td>地址</td>
				<td><textarea rows="5" cols="10" name="address">${requestScope.workerDetail.address}</textarea></td>
			</tr>
			<tr>
				<td>银行卡号</td>
				<td><input name="accountCardNo" value="${requestScope.workerDetail.accountCardNo}"></td>
			</tr>
			<tr>
				<td>电话号码</td>
				<td><input name="tel" value="${requestScope.workerDetail.tel}"></td>
			</tr>
			<tr>
				<td>电子邮箱</td>
				<td><input name="email" value="${requestScope.workerDetail.email}"></td>
			</tr>
			<tr>
				<td>qq</td>
				<td><input name="qq" value="${requestScope.workerDetail.qq}"></td>
			</tr>
			<tr>
				<td><input type="submit" value="保存"></td>
				<td><input type="reset" value="取消"></td>
			</tr>
		</table>
	</form>
</body>
</html>