/*��������Լ���Ƕ�׵�IFRAME�˾��滻�����ڵ�URL,bbs����;*/
var url=window.location.href;
if(window!=parent&&url.indexOf("bbs")==-1&&url.indexOf("iframe")==-1)
	parent.navigate(url);
function $(x){
    return document.getElementById(x);
}
/*������ʾlogo*/
var objLogoBg=$("headLogoBg");
var objLogo=$("headLogo");
if(objLogoBg)
	objLogoBg.innerHTML='<a href="http://www.paipai.com/?ADTAG=3.1.1" target="_top"><img src="http://pics.paipai.com/common/logo/logoNewYear2008A.gif" alt="��Ѷ���µ����߹�����վ�����֡�ʱ�С�����" /></a><div class="absolute" style="left:82px;top:65px"><img src="http://pics.paipai.com/common/logo/logoNewYear2008C.gif" /></div><div class="absolute" style="left:174px;top:65px"><img src="http://pics.paipai.com/common/logo/logoNewYear2008D.gif" /></div><div class="absolute" style="left:205px;top:65px"><img src="http://pics.paipai.com/common/logo/logoNewYear2008E.gif" /></div><div class="absolute" style="left:812px;top:27px"><img src="http://pics.paipai.com/common/icon/new.gif" /></div>';
else if(objLogo) 
	objLogo.innerHTML='<a href="http://www.paipai.com/?ADTAG=3.1.1" target="_top"><img src="http://pics.paipai.com/common/logo/logoV3A.gif" alt="��Ѷ���µ����߹�����վ�����֡�ʱ�С�����" /></a>';
/*������ʾ����
if($("headNote")){
	$("headNote").innerHTML="Ϊ�˸��õ�Ϊ���ѷ�������������7��25������5:00-7:00����ϵͳά������ʱ��������ع��ܽ���ʱ�޷�����ʹ�á�<br />�ɴ˸��������Ĳ��㣬�������Ǹ�⣬��л������������֧�֣�";
	$("headNote").style.display="";
}*/

function showFlash(showId,flashSrc,flashW,flashH){
	$(showId).innerHTML='<embed src="'+flashSrc+'" height="'+flashH+'" width="'+flashW+'" wmode="transparent" type="application/x-shockwave-flash"></embed>';
}

function setHeadFmCookie(name){
  var cookieValue = "";
  var search = name + "=";
  if(document.cookie.length > 0)
  { 
    offset = document.cookie.indexOf(search);
    if (offset != -1)
    { 
      offset += search.length;
      end = document.cookie.indexOf(";", offset);
      if (end == -1) end = document.cookie.length;
      cookieValue = unescape(document.cookie.substring(offset, end))
    }
  }
  return cookieValue;
}

var hs = setHeadFmCookie("hs");
var sNickName= hs.replace(/[0,1]\/\d+\/[0,1]\//,"");
var showStatus="";
var objUser=$("headUser");
var objInto=$("headInto");
var objStatus=$("headStatus");
if(sNickName){
	var sNickName_short = (sNickName.length > 5)?sNickName.substring(0,3)+"...":sNickName;
	showUser="��ӭ����"+sNickName_short+"��";
	if(objUser) objUser.innerHTML=showUser;
	if(objInto){
		if(url.indexOf("my.paipai.com")==-1)
			objInto.innerHTML="[�˳�]";
		else objInto.innerHTML="�˳�";
		objInto.href="http://member.paipai.com/cgi-bin/c2cUser_LoginOut";
	}
	var showBasic=hs.split("/")[0];
	var showPayNum=hs.split("/")[1];
	var showTenPay=hs.split("/")[2];
	var objStatus=$("headStatus");
	if(objStatus){
		if(showPayNum>0)
			showStatus="<a href='http://my.paipai.com/cgi-bin/qshop_manage?urltype=1' class='linkBlue'>���� <b style='color:#ff4e00;text-decoration:underline'>"+showPayNum+"</b>&nbsp;&nbsp;�ʽ��״����</a>";
		else if(showBasic==0)
			showStatus="<a href='http://my.paipai.com/cgi-bin/qshop_manage?urltype=18' class='linkBlue'>���Ļ���������δ���ã�</a>";
		else if(showTenPay==0)
			showStatus="<a href='http://pay.paipai.com/cgi-bin/pay_query_user_qpayaccount' target='_blank' class='linkBlue'>���ĲƸ�ͨ�ʻ���δ��ͨ��</a>";
		objStatus.innerHTML=showStatus;
	}
	RememberWelcomeMsg(showStatus);
}

function RememberWelcomeMsg(value){
 document.cookie =  "WelcomeMsg=" + escape(value)+";domain=my.paipai.com";
}

function cleanKeyWord(keyDefault,keyId){
	var obj=$(keyId);
	if(keyDefault==obj.value)
		obj.value="";
}
function checkHeadSubmit(keyDefault,keyId){
	var obj=$(keyId);
	if(keyDefault==obj.value||obj.value=="")
		obj.value="";
	return true;
}

function showHeadOver(obj){
	obj.src=obj.src.replace(".gif","Over.gif");
}

function showHeadOut(obj){
	obj.src=obj.src.replace("Over","");
}

function showMenu(menuName,isIndex){
	var obj=$("menu"+menuName);
	var objList=$("menuList");
	if(obj){
		obj.className="menuHere";
		if(menuName=="Home"){
			obj.style.backgroundImage="url(http://pics.paipai.com/head/menuHere.gif)";
			obj.style.paddingLeft="0px";
		}
	}
}

function readCookie(name){
  var cookieValue = "";
  var search = name + "=";
  if(document.cookie.length > 0){ 
    offset = document.cookie.indexOf(search);
    if (offset != -1){ 
      offset += search.length;
      end = document.cookie.indexOf(";", offset);
      if (end == -1) end = document.cookie.length;
      cookieValue = unescape(document.cookie.substring(offset, end))
    }
  }
  return cookieValue;
}

function goShopCar(){
	var sUrl = "http://auction.paipai.com/cgi-bin/shopcar?"+Math.random();
	var oPopUp = window.open(sUrl,"ppShopCar");
	oPopUp.focus();	
}

function ShowShopcarNum(){		
	var oShopCarNum =$("spcartnum");
	var oBBSFloat   =$("bbsfloat");
	var iNum = parseInt(readCookie("spcart"));
	if(isNaN(iNum))
		iNum = 0;
	if(oShopCarNum && iNum>0){
		oShopCarNum.innerHTML = "<span class='fontOrange number'>["+iNum+"]</span>";
	}
}

ShowShopcarNum();

var statusNote="������ - ���֡�ʱ�С�����";
var isScreen=1;
var isIE6=1;
if(screen.width==1024) isScreen=0;
var nav=navigator.appVersion;
if (nav.indexOf('MSIE')!=-1){
	var curIE=nav.substr(nav.indexOf('MSIE')+5,3);
	if (curIE==6.0) isIE6=0;
}
if(isIE6||isScreen) statusNote+=" - ʹ��";
if(isIE6) statusNote+="IE6.0";
if(isIE6&&isScreen) statusNote+="�Լ�";
if(isScreen) statusNote+="1024��768�ֱ���";
if(isIE6||isScreen) statusNote+="���ʱ�վ�ܹ����������Ч����";
window.status=statusNote;	