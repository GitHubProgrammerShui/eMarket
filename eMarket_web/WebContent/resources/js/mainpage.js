// JavaScript Document
//--------------------------------全选-------------------------------
var chked = false;
function selectAll(formName,butOBJ)
{		var addCheckNum=0;

	   var form1 = document.all(formName);
	   
	   for(var i = 0; i < form1.length; i ++ )
	   {
		  if(form1[i].type == "checkbox")
		  {
			 if (chked == true)
			 {
				form1[i].checked = "";
			 }
			 else
			 {
				form1[i].checked = "checked";
				//      alert(form1[i].name);
			 }
			 addCheckNum++;
		  }
	   }
	   if(addCheckNum!=0){
		   if (chked == true)
		   {
			  chked = false;
		   }
		   else
		   {
			  chked = true;
		   }
		   
		   if(butOBJ.value==' 全 选 '){
			   butOBJ.value=' 反 选 ';
		   }else{
			   butOBJ.value=' 全 选 ';
		   }
	   }else{
		  alert("没有可选择的数据");		   
	   }
}

