var show_word="������Ʒ�ؼ���";
function searchSubmitTo(){
	var obj=document.getElementById("KeyWord");
	var formobj=document.getElementById("searchForm");
	var keyType = document.getElementById("keywordtype");
	var classid = document.getElementById("sClassid");
	var shopclassid = document.getElementById("shoptype");
	formobj.action="http://search1.paipai.com/cgi-bin/comm_search1";
	if(!keyType||keyType.value == "goods"||keyType.type=="radio"){
		if(obj.value!=""){
			formobj.submit();
		} else if(document.getElementById("sClassid")){
			if(document.getElementById("sClassid").value!="")
				formobj.submit();
			else location.href="http://search.paipai.com/";
		} else if(document.getElementById("Path")){
			if(document.getElementById("Path").value!="")
				formobj.submit();
			else location.href="http://search.paipai.com/";
		}
	}else{
		if(obj.value!=""){
			formobj.action="http://search1.paipai.com/cgi-bin/shop_search1";
			shopclassid.value = classid.value;
			formobj.submit();
		} else location.href="http://shop.paipai.com/";
	}
	return false;
}

function makeSearch(){
	document.getElementById("keywordtype").value=document.getElementById("searchType_foot").value;
	document.getElementById("KeyWord").value=document.getElementById("KeyWord_foot").value;
	searchSubmitTo();
}

function showSearch(obj,type){
	if(type){
		if(obj.value=="")
			obj.value="";
		obj.style.color='gray';
	}else{
		if(obj.value==show_word||obj.value=="����ؼ��ֽ�������")
			obj.value="";
		obj.style.color='#000000';
	}
}

function showFind(sortId){
	var obj=document.getElementById("sClassid");
	var length;
	length = obj.length;
	for(var index=0;index<length;index++){
		if(obj.options[index].value == sortId){
			obj.selectedIndex = index;
			break;
		}
	} 
}

function showType(sortId){
	var obj=document.getElementById("keywordtype");
	var length;
	length = obj.length;
	for(var index=0;index<length;index++){
		if(obj.options[index].value == sortId){
			obj.selectedIndex = index;
			break;
		}
	} 
}

rnd.today=new Date(); 
rnd.seed=rnd.today.getTime(); 
function rnd(){ 
	rnd.seed = (rnd.seed*9301+49297) % 233280; 
	return rnd.seed/(233280.0); 
}
function rand(number){ 
	return Math.ceil(rnd()*number)-1; 
}

document.onclick=hideResult;
var nowLink=-1;
var preLink=0;
var keyNumber=0;
function showResult(code,value){
	var obj=document.getElementById('result');
	ShowPaiPaiSearchResult(value);
	nowLink=-1;
	preLink=0;
}
function hideResult(){
	var obj=document.getElementById('result');
	if(obj) obj.style.display='none';
}
function showKeyDown(code){
	keyNumber=document.getElementById("result").childNodes.length;
	if(code==38||code==40){
		preLink=nowLink;
		if(code==38)
			nowLink--;
		else if(code==40)
			nowLink++;
		if(nowLink<0) nowLink=keyNumber-1;
		else if(nowLink>keyNumber-1) nowLink=0;
		var objNowLink=document.getElementById("result").childNodes[nowLink];
		if(objNowLink)
			objNowLink.className="activeLink";
		if(nowLink!=-1){
			var objPreLink=document.getElementById("result").childNodes[preLink];
			if(objPreLink)
				objPreLink.className="";	
			}				
	} else if(code==13){
		if(nowLink!=-1){
			var objNowLink=document.getElementById("result").childNodes[nowLink];
			if(objNowLink){
				keyHref=objNowLink.href;
				keyStart=keyHref.indexOf("KeyWord=");
				keyEnd=keyHref.indexOf("&ADTAG");
				keyValue=keyHref.substring(keyStart+8,keyEnd);
				document.getElementById("KeyWord").value=keyValue;
			}
		}
		if(document.getElementById("searchForm"))
			searchSubmitTo(); 	
	}
}
function loadscript(rURL,rID) {
	var oldscript = document.getElementById(rID);
	var newscript = document.createElement("script");
	newscript.setAttribute("id", rID)
	newscript.setAttribute("src", rURL);
	oldscript.parentNode.replaceChild(newscript, oldscript);
	return true;
}
function ShowPaiPaiSearchResult(KeyWord){
    loadscript("http://search.paipai.com/cgi-bin/isuggest?KeyWord="+KeyWord,"PaipaiSearchJs");
    return true;
}

var arrFirstSort=[3119,12001,24590,20501,20001,2001,21001,28001,21501,22001,6001,6070,22501,3002,28038,1,5001,4001,28039,28009,28046,11001,23001,28055,28053,28052,28054,28056,8001,24001,23501,24501,9001,21591,10001];
var arrFirstDate=[];
arrFirstDate[3119]="��ֵ�� - �ֻ��� - �绰��";
arrFirstDate[12001]="������Ϸ������Ʒ";
arrFirstDate[24590]="��ѶQQר��";
arrFirstDate[20501]="Ůװ - Ůʿ��Ʒ - ����";
arrFirstDate[20001]="��ױ - ��ˮ - ���� - ����";
arrFirstDate[2001]="�鱦���� - ʱ����Ʒ";
arrFirstDate[21001]="Ůʿ��� - Ьñ - ���";
arrFirstDate[28001]="Ʒ���ֱ� - �����ֱ�";
arrFirstDate[21501]="��ʿ���� - Zippo - ��ʿ��Ʒ";
arrFirstDate[22001]="��װ - �а� - �������";
arrFirstDate[6001]="�˶� - ���� - ����";
arrFirstDate[6070]="���� - ��Ʒ - ���� - ��Ʊ";
arrFirstDate[22501]="Ӥ�� - �и���Ʒ - ͯװ";
arrFirstDate[3002]="�ֻ�";
arrFirstDate[28038]="�ʼǱ�����";
arrFirstDate[1]="����Ӳ�� - ̨ʽ����";
arrFirstDate[5001]="�������� - ���� - ����";
arrFirstDate[4001]="������� - ����� - ��ӡ";
arrFirstDate[28039]="������� - �������";
arrFirstDate[28009]="������� - ����Ԫ��";
arrFirstDate[28046]="�칫�豸 - �ľ� - �Ĳ�";
arrFirstDate[11001]="�����ܱ� - ��Ϸ�ܱ�";
arrFirstDate[23001]="��ͨ��Ʒ - ��� - ģ��";
arrFirstDate[28055]="�Ӽ� - ���� - ��Ʒ - ����";
arrFirstDate[28053]="�ҵ� - �������� - ������е";
arrFirstDate[28052]="ʳƷ - ����Ʒ - ��Ҷ - �ز�";
arrFirstDate[28054]="�Ҿ� - �˼Ҵ���";
arrFirstDate[28056]="װ�� - �ƾ� - ��� - ��ԡ";
arrFirstDate[8001]="�ʱ� - �Ŷ� - �ֻ� - �ղ�";
arrFirstDate[24001]="���� - ����Ʒ - ��Ʒ - �ʻ�";
arrFirstDate[23501]="�鼮 - ��ֽ - ��־";
arrFirstDate[24501]="��Ӱ - ���� - ���� - ����";
arrFirstDate[9001]="���� - Ħ�� - ���г�";
arrFirstDate[21591]="���� - ���� - ��Ȥ����";
arrFirstDate[10001]="סլ - ���� - �칫¥����";

function showFirstSort(showType){
	var showSortStr="";
	var showSortMore="";
	if(showType!="link"){
		if(showType==1) 
			showSortMore="0,"
		showSortStr+='<optgroup>';
		showSortStr+='<option value="'+showSortMore+'3119">��ֵ�� - �ֻ��� - �绰��</option>';
		showSortStr+='<option value="'+showSortMore+'12001">������Ϸ������Ʒ</option>';
		showSortStr+='<option value="'+showSortMore+'24590">��ѶQQר��</option>';
		showSortStr+='</optgroup>';
		showSortStr+='<optgroup class="optionShow">';
		showSortStr+='<option value="'+showSortMore+'20501">Ůװ - Ůʿ��Ʒ - ����</option>';
		showSortStr+='<option value="'+showSortMore+'20001">��ױ - ��ˮ - ���� - ����</option>';
		showSortStr+='<option value="'+showSortMore+'2001">�鱦���� - ʱ����Ʒ</option>';
		showSortStr+='<option value="'+showSortMore+'21001">Ůʿ��� - Ьñ - ���</option>';
		showSortStr+='<option value="'+showSortMore+'28001">Ʒ���ֱ� - �����ֱ�</option>';
		showSortStr+='<option value="'+showSortMore+'21501">��ʿ���� - Zippo - ��ʿ��Ʒ</option>';
		showSortStr+='<option value="'+showSortMore+'22001">��װ - �а� - �������</option>';
		showSortStr+='<option value="'+showSortMore+'6001">�˶� - ���� - ����</option>';
		showSortStr+='<option value="'+showSortMore+'6070">���� - ��Ʒ - ���� - ��Ʊ</option>';
		showSortStr+='<option value="'+showSortMore+'22501">Ӥ�� - �и���Ʒ - ͯװ</option>';
		showSortStr+='</optgroup>';
		showSortStr+='<optgroup>';
		showSortStr+='<option value="'+showSortMore+'3002">�ֻ�</option>';
		showSortStr+='<option value="'+showSortMore+'28038">�ʼǱ����� </option>';
		showSortStr+='<option value="'+showSortMore+'1">����Ӳ�� - ̨ʽ����</option>';
		showSortStr+='<option value="'+showSortMore+'5001">�������� - ���� - ����</option>';
		showSortStr+='<option value="'+showSortMore+'4001">������� - ����� - ��ӡ</option>';
		showSortStr+='<option value="'+showSortMore+'28039">������� - �������</option>';
		showSortStr+='<option value="'+showSortMore+'28009">������� - ����Ԫ��</option>';
		showSortStr+='<option value="'+showSortMore+'28046">�칫�豸 - �ľ� - �Ĳ�</option>';
		showSortStr+='<option value="'+showSortMore+'11001">�����ܱ� - ��Ϸ�ܱ�</option>';
		showSortStr+='<option value="'+showSortMore+'23001">��ͨ��Ʒ - ��� - ģ��</option>';
		showSortStr+='</optgroup>';
		showSortStr+='<optgroup class="optionShow">';
		showSortStr+='<option value="'+showSortMore+'28055">�Ӽ� - ���� - ��Ʒ - ����</option>';
		showSortStr+='<option value="'+showSortMore+'28053">�ҵ� - �������� - ������е</option>';
		showSortStr+='<option value="'+showSortMore+'28052">ʳƷ - ����Ʒ - ��Ҷ - �ز�</option>';
		showSortStr+='<option value="'+showSortMore+'28054">�Ҿ� - �˼Ҵ���</option>';
		showSortStr+='<option value="'+showSortMore+'28056 ">װ�� - �ƾ� - ��� - ��ԡ</option>';
		showSortStr+='<option value="'+showSortMore+'8001">�ʱ� - �Ŷ� - �ֻ� - �ղ�</option>';
		showSortStr+='<option value="'+showSortMore+'24001">���� - ����Ʒ - ��Ʒ - �ʻ�</option>';
		showSortStr+='<option value="'+showSortMore+'23501">�鼮 - ��ֽ - ��־</option>';
		showSortStr+='<option value="'+showSortMore+'24501">��Ӱ - ���� - ���� - ����</option>';
		showSortStr+='<option value="'+showSortMore+'9001">���� - Ħ�� - ���г�</option>';
		showSortStr+='<option value="'+showSortMore+'21591">���� - ���� - ��Ȥ����</option>';
		showSortStr+='<option value="'+showSortMore+'10001">סլ - ���� - �칫¥����</option>';
		showSortStr+='</optgroup>';
	} else {
		for(var i=0;i<arrFirstSort.length;i++)
			showSortStr+='<li><a href="http://search.paipai.com/cgi-bin/shop_search?shoptype='+arrFirstSort[i]+'">'+arrFirstDate[arrFirstSort[i]]+'</a></li>'
	}
	document.write(showSortStr);
}