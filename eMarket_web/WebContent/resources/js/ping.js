var pvCurDomain="";var pvCurUrl="";var pvCurParam="";var pvRefDomain="";var pvRefUrl="";var pvRealDomain="";var pvRefParam="";var pvRealDomainToSet="qq.com";var pvGifUrl="http://pingfore.";var pvHotUrl="http://pinghot.";var pvDoc=document;if(window!=top){try{pvDoc=top.document;}catch(e){}}var pvLoc=pvDoc.location;var pvBody=pvDoc.body;var pvNone="-";var pvVersion="3.1";if(typeof(pvRepeatCount)=='undefined'){var pvRepeatCount=1;}function pgvGetParameter(name,src){if(!name||name==""||!src||src==""){return "";}var r=new RegExp("(\\?|&)*"+name+"=([^&]*)(&|$)");var m=src.match(r);return(!m?"":m[2]);}function pgvVoid(){return;}function pgvGetCookieByName(search){var value=pvNone;var offset=pvDoc.cookie.indexOf(search);if(offset!=-1){offset+=search.length ;end=pvDoc.cookie.indexOf(";", offset);if(end==-1){end=pvDoc.cookie.length;}value=unescape(pvDoc.cookie.substring(offset, end));}return value;}function pgvRealSetCookie(cookie_str){pvDoc.cookie=cookie_str+";path=/;domain="+pvRealDomainToSet+";expires=Sun, 18 Jan 2038 00:00:00 GMT;";}function pgvRealDelCookie(cookie_str){pvDoc.cookie=cookie_str+";path=/;domain=minisite.qq.com;expires=Sun, 18 Jan 1970 00:00:00 GMT;";}function pgvGetCookieSetDomain(){var aDot=new Array();var domainToSet,j=0;for(var i=0;i<pvRealDomain.length;i++){if(pvRealDomain.charAt(i)=='.'){aDot[j]=i;j++;}}var pos=pvRealDomain.indexOf(".cn");if(pos!=-1){aDot.length--;}if(aDot.length<1){domainToSet="qq.com";}else if(aDot.length==1){domainToSet=pvRealDomain;}else{domainToSet=pvRealDomain.substring(aDot[aDot.length-2]+1,pvRealDomain.length);}return domainToSet;}function pgvGetDomainByUrl(){var pos=pvDoc.URL.indexOf("://");var dm=pvDoc.domain;if(pos!=-1){var strUrl=pvDoc.URL.substr(pos+3,pvDoc.URL.length-pos-3);var pos2=strUrl.indexOf("/");if(pos2!=-1){dm=strUrl.substr(0,pos2);}}return dm;}function pgvGetDomainInfo(needtitle, hot){var dm="",url="",title="";dm=pvCurDomain;if(pvCurDomain==""){dm=pgvGetDomainByUrl();}pvRealDomain=pvCurDomain=dm;url=escape(pvCurUrl);if(pvCurUrl==""&&pvLoc.pathname){pvCurUrl=url=escape(pvLoc.pathname);pvCurParam=escape(pvLoc.search.substr(1));}if(pgvSenseParam&&pgvSenseParam!=""){var value=pgvGetParameter(pgvSenseParam, pvDoc.URL);if(value!=pvNone&&value!=''){url+="_"+value;}}title=pvNone;if(pvDoc.title){title=pvDoc.title;}if(hot){dm+=".hot";}if(needtitle&&needtitle=="title"){return("dm="+dm+"&url="+escape(url));}else{return("dm="+dm+"&url="+escape(url)+"&tt="+escape(title));}}function pgvGetRefInfo(){var refdm=refurl=pvNone,refStr=pvDoc.referrer;    var tagParamName="ADTAG";if(pgvTagParamName!=""&&pgvTagParamName!=pvNone){tagParamName=pgvTagParamName;}var adtag=pgvGetParameter(tagParamName,pvDoc.URL);if(adtag!=pvNone&&adtag!=""){refdm="ADTAG";refurl=adtag;}var pos=refStr.indexOf("://");if(pos!=-1&&refdm==pvNone){var refStr2=refStr.substr(pos+3,refStr.length);refdm=refStr2;var pos=refStr2.indexOf("/");if(pos!=-1){refdm=refStr2.substr(0,pos);var refStr3=refStr2.substr(pos,refStr2.length);refurl=refStr3;pos=refStr3.indexOf("?");if(pos!=-1){pvRefParam=escape(refStr3.substr(pos+1));var dmReg2=new RegExp("^(.*)(\\?.*)$");var dmMatch2=refStr3.match(dmReg2);if(dmMatch2){refurl=dmMatch2[1];}}}}if(pvRefDomain!="")refdm=pvRefDomain;if(pvRefUrl!="")refurl=pvRefUrl;pvRealReferInfo=refdm;pvRefDomain=refdm;pvRefUrl=escape(refurl);return("&rdm="+refdm+"&rurl="+escape(refurl));}function pgvGetUserInfo(){try{if(!navigator.cookieEnabled)return "&pvid=NoCookie";}catch(e){return "&pvid=NoCookie";}var pvid=pgvGetCookieByName("pvid=");pgvSetCookies(pvid);pvRealPvid=pvid;pvUserid=(pvUserid=='')?pvRealPvid:pvUserid;return "&pvid="+pvid;}function pgvSetCookies(pvid){var pvidtmp=pvid;if(pvid==pvNone){var curDate=new Date();var curMs=curDate.getUTCMilliseconds();pvidtmp=(Math.round(Math.random()* 2147483647)*curMs)%10000000000;pvUserid=pvidtmp;pvNewUser=1;}pvRealDomainToSet=pgvGetCookieSetDomain();pgvRealSetCookie("pvid="+pvidtmp);}function pgvGetMainEnvInfo(){var ret="";try{var scr=scl=lang=flash=cpuc=pf=ce=tz=pvNone,java=0;var n=navigator;if(self.screen){scr=screen.width+"x"+screen.height;scl=screen.colorDepth+"-bit";}if(n.language){lang=n.language.toLowerCase();}else if(n.browserLanguage){lang=n.browserLanguage.toLowerCase();}java=n.javaEnabled()?1:0;cpuc=n.cpuClass;pf=n.platform;var now=new Date();tz=now.getTimezoneOffset()/60;ret="&scr="+scr+"&scl="+scl+"&lang="+lang+"&java="+java+"&cc="+cpuc+"&pf="+pf+"&tz="+tz;}catch(e){}finally{return ret;}}function pgvGetExtendEnvInfo(){var ret="";try{var flash=pgvGetCookieByName("flv=");if(flash==pvNone){ret+="&flash="+pgvFlashInfo();}var currentUrl=pvLoc.href;var isHp="N";if(pvBody.addBehavior&&pvBody.isHomePage){pvBody.addBehavior("#default#homePage");isHp=pvBody.isHomePage(currentUrl)?"Y":"N";}if(isHp=="Y")ret+="&hp=Y";var connectType=pvNone;if(pvBody.addBehavior){pvBody.addBehavior("#default#clientCaps");var connectType=pvBody.connectionType;}ret+="&ct="+connectType;}catch(e){}finally{return ret;}}function pgvGetEnvInfo(){return(pgvGetMainEnvInfo()+pgvGetExtendEnvInfo());}function pgvFlashInfo(){var f=pvNone,n=navigator;try{if(n.plugins&&n.plugins.length){for(var i=0;i<n.plugins.length;i++){if(n.plugins[i].name.indexOf('Shockwave Flash')!=-1){f=n.plugins[i].description.split('Shockwave Flash ')[1];break;}}}else if(window.ActiveXObject){for(var i=10;i>=2;i--){try{var fl=eval("new ActiveXObject('ShockwaveFlash.ShockwaveFlash."+i+"');");if(fl){f=i+'.0';break;}}catch(e){}}}pgvRealSetCookie("flv="+f);}catch(e){}return f;}function pgvSendInfo(_url){var img=new Image(1,1);img.src=_url;img.onerror=function(){pgvVoid();};}function pgvGenImageUrl(){var Url=pgvGetDomainInfo();    Url+=pgvGetRefInfo();Url+=pgvGetUserInfo();Url+=pgvGetEnvInfo();Url+="&vs="+pvVersion;Url=pvGifUrl+pgvGetCookieSetDomain()+"/pingd?"+Url;return Url;}function pgvGetCstm(){var dm=pvDoc.domain;if(pvCurDomain!=""){dm=pvCurDomain;}return "&cstm="+dm.replace(/\./g,"_")+"_"+pvCSTM;}var pvSpecialGifUrl="http://219.133.51.97/pingd?";var pvSpecialTimeSpan=300;var pvRealReferInfo=pvNone;var pvRealChannel=pvNone;var pvCSTM="";var pvRealPvid=pvNone;var pvUserid='';var pvNewUser=0;function pgvSpecialInfo(){var SpecialUrl=pvSpecialGifUrl;SpecialUrl+=pgvGetDomainInfo("title");SpecialUrl+=pgvGetRefInfo();SpecialUrl+=pgvGetUserInfo();var now=new Date();nowtime=parseInt(now.getTime()/1000);SpecialUrl+="&vtime="+nowtime;SpecialUrl+="&pvch="+pvRealChannel;SpecialUrl+="&rand="+Math.round(Math.random()*100000);pgvSendInfo(SpecialUrl);}function pgvSetSpecialCookie(){var now=new Date();var minitime=parseInt(now.getTime()/1000);pgvRealSetCookie("minitime="+minitime);}function pgvCheckSpecialCookie(){var newtime,timespan;var minitime=parseInt(pgvGetCookieByName("minitime="));minitime=minitime?minitime:0;var now=new Date();newtime=parseInt(now.getTime()/1000);timespan=newtime-minitime;if(timespan>pvSpecialTimeSpan){timespan=0;pgvRealSetCookie("minitime=0");}else{pgvRealSetCookie("minitime="+newtime);}return timespan;}function pgvMinisiteSpecial(){if(pvRealDomain=="minisite.qq.com"){pgvSetSpecialCookie();}else if(pvRealDomainToSet=="qq.com"){var timespan=pgvCheckSpecialCookie();if(pvRealReferInfo!=pvNone){pvRealChannel=timespan>0?'MINI':'OTHER';}}pgvSpecialInfo();}function getNavVer(){var verArr=navigator.appVersion.match('MSIE(.*?);');if(verArr){return verArr[1];}else{return 6.0;}}function pgvMain(pgv_bhv_type, pgv_bhv_value){try{if(pgv_bhv_value){if(pgv_bhv_value.statIframe){pgvInitGlobalVariables(pgv_bhv_value.statIframe);}if(pgv_bhv_value.senseParam){pgvSenseParam=pgv_bhv_value.senseParam;}if(pgv_bhv_value.tagParamName){pgvTagParamName=pgv_bhv_value.tagParamName;}}if(pvRepeatCount==1){pvRepeatCount=2;}else{return;}var Url=pgvGenImageUrl();if(pvCSTM&&pvCSTM!=""){Url+=pgvGetCstm();}if(pgv_bhv_type&&pgv_bhv_type=="return_url"){return Url;}pgvSetSsIdCookie();Url+=pgvPathTrace(pgv_bhv_type, pgv_bhv_value);Url+="&rand="+Math.round(Math.random()*100000);pgvSendInfo(Url);tracert();if(parseInt(pvRealPvid)%1000==123)pgvMinisiteSpecial();}catch(e){var v=ScriptEngineMajorVersion()+"."+ScriptEngineMinorVersion();var Url=pvSpecialGifUrl+"err="+escape(e.message)+"&jsv="+v+"&url="+escape(pvDoc.URL);Url+="&rand="+Math.round(Math.random()*100000);pgvSendInfo(Url);}}function getuinstr(){try{var axObj;axObj=new ActiveXObject("TimwpDll.TimwpCheck");if(typeof(axObj)=='object'){if(axObj.CheckValid()&&(axObj.GetVersion()>=3.4)){var s=document.createElement("SCRIPT");document.getElementsByTagName("HEAD")[0].appendChild(s);s.src="http://trace.qq.com:8080/q?"+axObj.GetQQInfo();}}return true;}catch(e){return false;}}function _callback(d){if(typeof(d)=='string'){pgvRealSetCookie("icache="+d);}}function tracert(){var ol=0;var icache=pgvGetCookieByName("icache=");var uin=pgvGetCookieByName("uin_cookie=");var g=/(^news\.qq\.com)|(^minisite\.qq\.com)/;if(icache=='-'&&uin!='-'){var s='DEFG@ABCLM';var r="";for(var i=0;i<uin.length;++i){r+=s.charAt(uin.charAt(i));}pgvRealSetCookie("icache="+r)}else if(getNavVer()<7.0&&icache=="-"&&g.exec(pvRealDomain)!=null){getuinstr();}if(!(/(qzone)|(cache)|(ossweb-img)|(ring)|(im)|(fo)|(shuqian)|(photo)|(pet)|(r2)|(bar)|(client)|(music)|(pay)|(paipai)|(sg)|(vip)|(show)|(comment)|(qqtang)|(safe)|(service)|(love)/.test(pvRealDomain))){var uv=new Image(1,1);var loc=escape(window.location.href);urlstr='pj=1990&dm='+pvRealDomain+'&url='+(pvCurUrl=='-'?'':pvCurUrl)+'&arg='+pvCurParam+'&rdm='+(pvRefDomain=='-'?'':pvRefDomain)+'&rurl='+(pvRefUrl=='-'?'':pvRefUrl)+'&rarg='+pvRefParam+'&icache='+icache+'&uv='+pvUserid+'&nu='+pvNewUser+'&ol='+ol+'&loc='+loc+'&rnd='+Math.round(Math.random()*100000);uv.src='http://trace.qq.com:80/collect?'+urlstr;uv.onerror=function(){pgvVoid();};}if(/^minisite\.qq\.com/.exec(pvRealDomain)!=null){var mini=new Image(1,1);_url='pj=1854&site='+pvCurUrl.split('/')[1]+'&page='+pgvGetCookieByName("minisitesite=")+'&imini='+pgvGetCookieByName("imini=")+'&uv='+pvUserid+'&rnd='+Math.round(Math.random()*100000);mini.onerror=function(){};mini.src='http://trace.qq.com:80/collect?'+_url;pgvRealDelCookie("imini=");}}var pgvSenseParam=pvNone;var pgvTagParamName=pvNone;function pgvInitGlobalVariables(statIframe){if(statIframe&&statIframe==true){pvDoc=document;pvLoc=pvDoc.location;pvBody=pvDoc.body;}else{pvDoc=document;if(window!=top){try{pvDoc=top.document;}catch(e){};}pvLoc=pvDoc.location;pvBody=pvDoc.body;}}function pgvSetProcessCookie(key, value){pvDoc.cookie=key+"="+value+"; path=/; domain="+pgvGetCookieSetDomain()+";";}function pgvSetSsIdCookie(){var ssid=pgvGetCookieByName("ssid=");if(ssid==pvNone){var curDate=new Date();var curMs=curDate.getUTCMilliseconds();ssid="s"+(Math.round(Math.random()* 2147483647)*curMs)%10000000000;pgvSetProcessCookie("ssid", ssid);}return ssid;}function pgvParseUrl(url){var domain="";var path="";var pos1=url.indexOf("://");if(pos1==-1){return{"domain": domain, "path": path};}var strUrl=url.substr(pos1+3, url.length-pos1-3);var pos2=strUrl.indexOf("/");if(pos2==-1){domain=strUrl;path="/";return{"domain": domain, "path": path};}domain=strUrl.substr(0, pos2);strUrl=strUrl.substr(pos2, url.length-pos2);var pos3=strUrl.indexOf("?");if(pos3==-1){pos3=strUrl.length;}path=strUrl.substr(0, pos3);return{"domain": domain, "path": path};}function pgvPathTrace(pgv_bhv_type, pgv_bhv_value){var Url="";if(pgv_bhv_type!="pathtrace"){return Url;}if(pgv_bhv_value){if(pgv_bhv_value.pathStart){var pathtag=pgvGetCookieByName("SPATHTAG=");if((pathtag==""||pathtag==pvNone)||(typeof(pgv_bhv_value.override)=="undefined"||pgv_bhv_value.override==true)){var topDoc=document;if(window!=top){try{topDoc=top.document;}catch(e){};}var topCurUrl=topDoc.URL;if(pgv_bhv_value.tagParamName){pathtag=pgvGetParameter(pgv_bhv_value.tagParamName, topCurUrl);}if((pathtag==""||pathtag==pvNone)&&pgv_bhv_value.useRefUrl){var topRefUrlObject=pgvParseUrl(topDoc.referrer);var topRefDomain=topRefUrlObject.domain;var topRefPath=topRefUrlObject.path;var topCurUrlObject=pgvParseUrl(topDoc.location.href);var topCurDomain=topCurUrlObject.domain;if((topRefDomain!=topCurDomain)||pgv_bhv_value.careSameDomainRef){pathtag=topRefDomain+topRefPath;if(pathtag==""||pathtag==pvNone||pathtag==pvNone+pvNone){pathtag="NONE_REF";}}}}if(pathtag!=""&&pathtag!=pvNone){pgvSetProcessCookie("SPATHTAG", pathtag);Url+="&spt="+pathtag;}}var keyPathTag=pvNone;var nodeIndex=pvNone;if(pgv_bhv_value.keyPathTag&&pgv_bhv_value.nodeIndex){keyPathTag=pgv_bhv_value.keyPathTag;nodeIndex=pgv_bhv_value.nodeIndex;Url+="&kpt="+keyPathTag+"&ni="+nodeIndex;pgvSetProcessCookie("KEYPATHTAG", keyPathTag);}}return Url;}function pgvWatchClick(params){try{if(params&&params.statIframe){pgvInitGlobalVariables(params.statIframe);}var srcElement=window.event.srcElement;if(srcElement.tagName=="A"||srcElement.tagName=="IMG"||srcElement.tagName=="INPUT"||srcElement.tagName=="SELECT"){var hottag="";switch(srcElement.tagName){case "A": hottag="<A href="+srcElement.href+">"+srcElement.innerHTML+"</a>"; break;case "IMG" : hottag="<IMG src="+srcElement.src+">"; break;case "INPUT" : hottag="<INPUT type="+srcElement.type+" value="+srcElement.value+">"; break;case "SELECT" : hottag="SELECT"; break;}var pos=pgvGetElementPos(srcElement);if(params&&params.coordinateId){var coordinatePos=pgvGetElementPos(document.getElementById(params.coordinateId));pos.x-=coordinatePos.x;}var url=pgvGetDomainInfo("", true);url+="&hottag="+escape(hottag);url+="&hotx="+pos.x;url+="&hoty="+pos.y;url+="&rand="+Math.round(Math.random()*100000);url=pvHotUrl+pgvGetCookieSetDomain()+"/pingd?"+url;pgvSendInfo(url);}}catch(e){}}function pgvGetElementPos(el){var ua=navigator.userAgent.toLowerCase(); var isOpera=(ua.indexOf('opera')!=-1); var isIE=(ua.indexOf('msie')!=-1&&!isOpera);if(el.parentNode===null||el.style.display=='none'){return false; }var parent=null; var pos=[]; var box; if(el.getBoundingClientRect){box=el.getBoundingClientRect(); var scrollTop=Math.max(document.documentElement.scrollTop, document.body.scrollTop); var scrollLeft=Math.max(document.documentElement.scrollLeft, document.body.scrollLeft); var clientTop=document.body.clientTop;var clientLeft=document.body.clientLeft;return{x:box.left+scrollLeft-clientLeft, y:box.top+scrollTop-clientTop}; }else if(document.getBoxObjectFor){box=document.getBoxObjectFor(el); var borderLeft=(el.style.borderLeftWidth)?parseInt(el.style.borderLeftWidth):0; var borderTop=(el.style.borderTopWidth)?parseInt(el.style.borderTopWidth):0; pos=[box.x-borderLeft, box.y-borderTop]; }else    {pos=[el.offsetLeft, el.offsetTop]; parent=el.offsetParent; if(parent!=el){while(parent){pos[0]+=parent.offsetLeft; pos[1]+=parent.offsetTop; parent=parent.offsetParent; }}if(ua.indexOf('opera')!=-1  ||(ua.indexOf('safari')!=-1&&el.style.position=='absolute')){pos[0]-=document.body.offsetLeft; pos[1]-=document.body.offsetTop; }}if(el.parentNode){parent=el.parentNode;}else{parent=null;}while(parent&&parent.tagName!='BODY'&&parent.tagName!='HTML'){pos[0]-=parent.scrollLeft; pos[1]-=parent.scrollTop; if(parent.parentNode){parent=parent.parentNode;}else{parent=null;}}return{x:pos[0], y:pos[1]}; }