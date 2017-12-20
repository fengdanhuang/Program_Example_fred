function setCookie (name, value, expires) {

  document.cookie = name + "=" + value +
    "; expires=" + expires.toGMTString() +  "; domain=sina.com.cn; path=/";
}

function getCookie(name) {

  var search;

  search = name + "="
  offset = document.cookie.indexOf(search) 
  if (offset != -1) {
    offset += search.length ;
    end = document.cookie.indexOf(";", offset) ;
    if (end == -1)
      end = document.cookie.length;
    return document.cookie.substring(offset, end);
  }
  else
    return "";
}

function deleteCookie(name) {

  var expdate = new Date();
  expdate.setTime(expdate.getTime() - (86400 * 1000 * 1));
  setCookie(name, "", expdate);
}


//**********************************************

function isExistCookie(ckName){
var userInfo = getCookie(ckName);
	if (userInfo.length==0){
//		alert("不存在用户"+ckName);
		return false;
	}else{
//		alert("存在用户"+ckName);
		return true;
	}
}

function isExistUser(ckName){
var userInfo = getCookie(ckName).split(":");
	if (userInfo[1].length==0){
//		alert("不存在用户"+ckName);
		return false;
	}else{
//		alert("存在用户"+ckName);
		return true;
	}
}

function isExistMobile(ckName){
var userInfo = getCookie(ckName).split(":");
var mobileNum=userInfo[2];
	if (mobileNum.length==0){
//		alert("用户"+ckName+"不存在手机号码");
		return false
	}else{
//		alert("用户"+ckName+"存在手机号码:"+mobileNum);
		return true
	}
}

function getUserName(ckName){
var userInfo = getCookie(ckName).split(":");
	return userInfo[1];
}

function getMobileNum(ckName){
var userInfo = getCookie(ckName).split(":");
	return userInfo[2];
}


function showPage(num){
	window.location="pic"+num+".html"
}

function get_cookie(name) {
   var arg = name + "=";
   var alen = arg.length;
   var clen = document.cookie.length;
   var i = 0;
   while (i < clen) {
      var j = i + alen;
      if (document.cookie.substring(i, j) == arg) {
        offset=j;
        var endstr = document.cookie.indexOf (";", offset);
        if (endstr == -1) endstr = document.cookie.length;
        return unescape (document.cookie.substring(offset, endstr));
      }
      i = document.cookie.indexOf(" ", i) + 1;
      if (i == 0) break;
   }

   return null;
}

function haveThisApp(appcode) {
	var AppMask=get_cookie("appmask");
	var i=0;
	var bitval=appcode % 16;
	while(appcode=appcode>>4) {
		i++;
		bitval=appcode % 16;
	}
	var bitmask=parseInt(AppMask.charAt(31-i));
	if(isNaN(bitmask) ) {
		//fail
		return false;
	} else {
		//tmp=bitmask & bitval;
		//alert("bitmask="+bitmask+"bitval="+bitval+"=>"+tmp);
		if(bitmask & bitval) {
			//User already know this application
			return true;
		}
	}
}
function promotion(appcode,content) {
	if(haveThisApp(appcode)) {
		return false;
	} else {
		document.write(content);
	}
}
function unipro_clearCookie(name ) {
        document.cookie=name+"=; " + "domain=sina.com.cn; path=/; ";
        bites = document.cookie.split("; ");
}

function unipro_UniProLogout() {
        unipro_clearCookie("SINAPRO");
        unipro_clearCookie("SINA-AVATAR");
        unipro_clearCookie("SINAPROC");
        unipro_clearCookie("nick");
        unipro_clearCookie("SINA_NU");
        unipro_clearCookie("SINA_OU");
        unipro_clearCookie("appmask");
        unipro_clearCookie("gender");
        unipro_clearCookie("UNIPROTM");
        unipro_clearCookie("UNIPROU");
        unipro_clearCookie("SINA_USER");
        unipro_clearCookie("SMS_COOKIE");
	return true;
}

function opensurvey()
{
	var check = getCookie("survey_ck");
    if (check == "")  
    {
        var pp= Math.round((Math.random()) * 10000);
        //if (pp % 30 == 0)
        if (0)
        {
            var expdate = new Date();
            expdate.setTime (expdate.getTime() + (24 * 60 * 60 * 30 * 1000));
            setCookie("survey_ck", "1", expdate);
            window.open("http://unipro.sina.com.cn/new_survey_index.htm",null,"height=455,width=620,status=yes,toolbar=no,scrollbars=yes,resizable=no,menubar=no,location=no");
        }
    }
}
