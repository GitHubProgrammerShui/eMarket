function mouseover(){
    		var button = document.getElementById("submit");
    		button.style.backgroundColor="blue";
    	}
    	function mouseout(){
    		var button = document.getElementById("submit");
    		button.style.backgroundColor="royalblue";
    	}
    	function inputonfocus(id){
    		var input = document.getElementById(id);
    		input.style.border="1px solid royalblue";
    	}
    	function inputonblur(id){
    		var input = document.getElementById(id);
    		input.style.border="1px solid #B3B8C4";
    	}
    	function checkAllInformation(){
    		//��֤�˺�
    		var id = document.getElementById("carnum").value;
    		if(id==""){
    			var tip = document.getElementById("tip1");
    			tip.style.color = "red";
    			tip.innerHTML = "�������˺ţ�";
    			return false;
    		}
    		if(id.length!=5){
    			var tip = document.getElementById("tip1");
    			tip.style.color = "red";
    			tip.innerHTML = "�˺ų��ȱ���Ϊ5λ�����֣�";
    			return false;
    		}
    	}