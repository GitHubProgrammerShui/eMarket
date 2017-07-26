function showTime(){
	var date=new Date();
	var year=date.getFullYear();
	var month=date.getMonth()+1;
	var day=date.getDate();
	var hour=date.getHours();
	var minute=date.getMinutes();
	var second=date.getSeconds();
	$("#time").text(year+"年"+month+"月"+day+"日"+hour+"时"+minute+"分"+second+"秒");
	setTimeout("showTime()",500);
}
$(function(){
	$("#time").text(showTime());
});
var menuSum;
function handleMenuItem(obj){
	$(obj).next().slideToggle("fast");
	if(menuSum!=null){
		if($(menuSum).attr("id")!=$(obj).next().attr("id")){
			if($(menuSum).css("display")!="none"){
				$(menuSum).slideToggle("fast");
			}
		}
	}
	menuSum=$(obj).next();
}