<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>页面从此处开始</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript">
		var contextPath="${pageContext.request.contextPath}";
		$(function(){
			getBrand();
			getType();
			fetchGoods();
		});
		function fetchGoods(){
			var param={
					"brandId":document.getElementById("brandList").value,
					"typeId":document.getElementById("typeList").value
			};
			$.post(contextPath+"/admin/factory/fetchGoods",param,function(data){
				$("#goodsList").empty();
				var optionStr=null;
				for(var i=0;i<data.length;i++){
					optionStr="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
					$("#goodsList").append(optionStr);
				}
			},"json");
		}
		function getBrand(){
			$.post(contextPath+"/admin/factory/getBrand",function(data){
				$("#brandList").empty();
				var optionStr=null;
				for(var i=0;i<data.length;i++){
					optionStr="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
					$("#brandList").append(optionStr);
				}
			},"json");
		}
		function getType(){
			$.post(contextPath+"/admin/factory/getType",function(data){
				$("#typeList").empty();
				var optionStr=null;
				for(var i=0;i<data.length;i++){
					optionStr="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
					$("#typeList").append(optionStr);
				}
			},"json");
		}
	</script>
</head>
<body>
	<table>
		<tr>
			<td>品牌</td>
			<td>
				<select id="brandList" onchange="fetchGoods()">
				</select>
			</td>
		</tr>
		<tr>
			<td>类型</td>
			<td>
				<select id="typeList" onchange="fetchGoods()">
				</select>
			</td>
		</tr>
	</table>
	<form action="${pageContext.request.contextPath}/admin/factory/add" method="post">
		<table>
			<tr>
				<td>商品</td>
				<td>
					<select name="goodsId" id="goodsList">
					</select>
				</td>
			</tr>
			<tr>
				<td>数量</td>
				<td><input name="quantity" type="number"></td>
			</tr>
			<tr>
				<td><input type="submit" value="保存"></td>
				<td><input type="reset" value="取消"></td>
			</tr>
		</table>
	</form>
</body>
</html>