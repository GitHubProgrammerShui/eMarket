	function CheckMobile()
{
        var chgMobile = document.getElementById("chgMobile");
	var chgMobile2 = document.getElementById("chgMobile2");
	if(!chgMobile.value.match(/^(13[0-9][0-9]{8}|15[38-9][0-9]{8})$/) || chgMobile.value != chgMobile2.value)
	{
		chgMobile.select();
		chgMobile.focus();
		alert("��������ȷ�ֻ�����,�������������һ�£�");
		return false;
	}

	return true;
}

function CheckAmount()
{
			var amount=document.getElementById("amount").value;
			var validAmount=[50,100,300];
			var phoneNumber=document.getElementById("chgMobile").value;
			if( 300 == amount && phoneNumber.match(/^(13[0-3][0-9]{8}|153[0-9]{8})$/))
			{
							alert("��ͨ�ֻ��ݲ�֧��300Ԫ��ֵ��");
							return false;
			}
			
			for(i in validAmount)
			{
							if( amount == validAmount[i])
							{

											return true;
							}
			}
			alert("����ѡ���ֵ��");
			return false;
}

function submitChgForm(theForm)
{
	if(!CheckMobile())
	return false;
	if(!CheckAmount())
	return false;
	window.open("http://digital.paipai.com/sale/mobile2/step2.shtml?pageNo=01&mobile="+document.getElementById("chgMobile").value+"&money="+document.getElementById("amount").value+"&ADTAG=104.33.2",null,'height=175,width=520');
	return false;
}