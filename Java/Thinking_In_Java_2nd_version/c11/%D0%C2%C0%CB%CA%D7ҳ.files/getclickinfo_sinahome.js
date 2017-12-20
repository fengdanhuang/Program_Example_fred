var _suds_clickmap_js_ver_="clickmap_sample_iframe_session_ref_btn:4.99";
var _suds_cmp_cp_s="";
var _suds_cmp_cp_mp_rf="http://beacon.sina.com.cn/b.gif";
var _suds_cmp_cp_n=0,_SUDS_CMP_CP_N_MAX=3,_SUDS_CMP_CP_C_MAX=1;
var _suds_cmp_c_d_u;
var _suds_cmp_c_d_c;
var _suds_cmp_c_d_s;
var _SUDS_CMP_SAMPLE_PER=1;

var _SUDS_CMP_CLICKDOMAINROOT="";
var _SUDS_CMP_CLICKSESSIONID="";
var _SUDS_CMP_CLICKMAPUNIPROU="";
var _SUDS_CMP_CLICKMAPPAGEREF=document.referrer;
if(""==_SUDS_CMP_CLICKMAPPAGEREF) _SUDS_CMP_CLICKMAPPAGEREF = "newpage";

function getSudsClickMapDomainRoot()
{
	if (""!=_SUDS_CMP_CLICKDOMAINROOT) return _SUDS_CMP_CLICKDOMAINROOT;
	
	_suds_cmp_domainRoot="";
	_suds_cmp_pageUrl = document.URL;
	_suds_cmp_pageUrl = _suds_cmp_pageUrl.toLowerCase()
	
	pe=_suds_cmp_pageUrl.indexOf(".sina.");
	
	if (pe>0)
	{
		_suds_cmp_domainRoot="sina.com.cn";
	}
	else
	{
		ps=_suds_cmp_pageUrl.indexOf(".");
		if(ps>0) { ps=ps+1; }
		else { return ""; }
		
		pe=_suds_cmp_pageUrl.indexOf("/",ps);
		if(pe<0){ pe = _suds_cmp_pageUrl.length;}
		
		_suds_cmp_domainRoot = _suds_cmp_pageUrl.substring(ps, pe);
	}
	_SUDS_CMP_CLICKDOMAINROOT=_suds_cmp_domainRoot;
	return _suds_cmp_domainRoot;
}

function getSudsClickMapCookie(ckName)
{
	var start = document.cookie.indexOf(ckName+"=");
	if (-1 == start)
	{
		return "";
	}
	start = document.cookie.indexOf("=", start)+1;
	var end = document.cookie.indexOf(";", start);
	if (0 >= end)
	{
		end = document.cookie.length;
	}
	ckValue = document.cookie.substring(start, end);
	return ckValue;	
}
function setSudsClickMapCookie(ckName, ckValue, expires)
{ 
	if (ckValue != null)
	{
		_suds_cmp_domainRoot = getSudsClickMapDomainRoot();
		if (("undefined" == expires)||(null == expires))
		{
			document.cookie = ckName + "=" + ckValue + "; domain="+_suds_cmp_domainRoot+"; path=/" ;
		}
		else
		{
			var now = new Date();
			var time = now.getTime();
			time = time + 86400000 * expires;
			now.setTime(time);
			time = now.getTime();
			document.cookie = ckName + "=" + ckValue + "; domain="+_suds_cmp_domainRoot+"; expires="+now.toUTCString()+ "; path=/";
		}
	}
}
function checkSudsClickMapSessionId()
{
	ckTmp = getSudsClickMapCookie("Apache");
	if("" == ckTmp)
	{
		var now = new Date();
		ckTmp = now.getTime()+Math.random();
		setSudsClickMapCookie("Apache",ckTmp);
	}
	return ckTmp;
}	

function getSudsClickMapSessionInfo()
{
	if (""==_SUDS_CMP_CLICKSESSIONID)   _SUDS_CMP_CLICKSESSIONID=checkSudsClickMapSessionId("Apache");
	if (""==_SUDS_CMP_CLICKMAPUNIPROU)  _SUDS_CMP_CLICKMAPUNIPROU=getSudsClickMapCookie("UNIPROU");
}

function randomSampleSudsClickMap()
{
	var r_num=Math.floor(Math.random()*100);
	if(r_num < _SUDS_CMP_SAMPLE_PER)
	{
		getSudsClickMapSessionInfo();
		
		_suds_cmp_c_d_u=window.onunload;
		_suds_cmp_c_d_c=document.onclick;
		_suds_cmp_c_d_s=document.onstop;
		document.onclick=sudsclickmapLinkclick;
		window.onunload=sudsclickmapUnload;
		window.onstop=sudsclickmapStop;
		document.write("<div id=sudsclickdiv style='position: absolute;width:80;top:-300;left:400;visibility: visible;z-index: 1'></div>");
	}
	else
	{ return 0; }
}

function putSudsClickMapClick()
{
	var strSudsClickMapQuest="";
	if (""!=_suds_cmp_cp_s)
	{
		strSudsClickMapQuest=document.URL+"|*|"+_suds_cmp_cp_s+"|*|"+_SUDS_CMP_CLICKSESSIONID+"|*|"+_SUDS_CMP_CLICKMAPUNIPROU+"|*|"+_SUDS_CMP_CLICKMAPPAGEREF;
		sudsclickdiv.innerHTML="<img src='"+_suds_cmp_cp_mp_rf+"?"+strSudsClickMapQuest+"' border='0' alt='' />";
		if("1"!=_SUDS_CMP_CLICKMAPPAGEREF) { _SUDS_CMP_CLICKMAPPAGEREF="1"; }
		
		_suds_cmp_cp_s="";_suds_cmp_cp_n=0;
	}
}

function collectSudsClickMapClick( clickS )
{
	_suds_cmp_cp_s=_suds_cmp_cp_s+clickS;
	_suds_cmp_cp_n++;
	if(_suds_cmp_cp_n>=_SUDS_CMP_CP_C_MAX)
	{ putSudsClickMapClick();  if (_SUDS_CMP_CP_C_MAX<_SUDS_CMP_CP_N_MAX) _SUDS_CMP_CP_C_MAX++;}
}

function getSudsClickMapClickSrcUrl(s)
{
	var ps=s.indexof("http");
	if (ps<0) return "";
	var pe=s.indexof(" ",ps);
	if (pe<0) 
	{
		pe=s.indexof(">",ps);
		if (pe<0) return "";
	}
	
	return substring(ps, pe);
}

function sudsclickmapUnload()
{ if(_suds_cmp_c_d_u) {_suds_cmp_c_d_u();} putSudsClickMapClick(); }
function sudsclickmapStop()
{ if(_suds_cmp_c_d_s) {_suds_cmp_c_d_s();} putSudsClickMapClick(); }
function sudsclickmapLinkclick(e)
{
	if(_suds_cmp_c_d_c) {_suds_cmp_c_d_c(e);}
	var o=event.srcElement;
	var MouseX="";
	var MouseY="";
	var ckTitle="";

	if ((o!=null)&&(o!=document))
	{
		if ("A" == o.tagName)
			ckTitle = "t=txt,s="+o.innerHTML+",h="+o.href;
		if(("FONT" == o.tagName)||("B" == o.tagName))
		{
			MouseX=window.top.document.body.scrollLeft + event.screenX - window.top.screenLeft;
			MouseY=window.top.document.body.scrollTop  + event.screenY - window.top.screenTop;

			ckTitle = "t=txt,s="+o.innerHTML+",h=";
			for(i=0;i<4;i++)			
			{
				o=o.parentElement;
				if(o==document) return ;

				if ("A" == o.tagName) break;
			}
			if(i>=4)
			{ return; }
			else
			{ ckTitle = ckTitle+o.href; }
		}
		if ("IMG" == o.tagName) 
			ckTitle = "t=img,s=,h="+o.src ;

		if ("INPUT" == o.tagName)
		{
			if(("image"==o.type)||("submit"==o.type))
			{
				MouseX=window.top.document.body.scrollLeft + event.screenX - window.top.screenLeft;
				MouseY=window.top.document.body.scrollTop  + event.screenY - window.top.screenTop;				
				
				ckTitle = "t=submit,s=,h=";
				for(i=0;i<4;i++)			
				{
					o=o.parentElement;
					if(o==document) return ;
      	
					if ("FORM" == o.tagName) break;
				}
				if(i>=4)
				{ return; }
				else
				{ ckTitle = ckTitle+o.action; }				
			}
			else if("button"==o.type)
			{
				ckTitle = "t=button,s="+o.value+",h=name_"+o.name;
			} 
		}


		if (""!=ckTitle)
		{
			if(""==MouseX)
			{
				MouseX=window.top.document.body.scrollLeft + event.screenX - window.top.screenLeft;
				MouseY=window.top.document.body.scrollTop  + event.screenY - window.top.screenTop;
			}
			if (window.top.document.body.offsetWidth>800)
			{MouseX=MouseX-Math.ceil((window.top.document.body.offsetWidth-788)/2);}
			
			var now = new Date();
			var ct = now.getTime();
			ckTitle=ckTitle+",ct="+ct+",x="+MouseX+",y="+MouseY+"|";
			
			try 
			{
				window.top.collectSudsClickMapClick(ckTitle); 
			} catch(e)
			{}
		}
	}
}

randomSampleSudsClickMap();