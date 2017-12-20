var MSIE=navigator.userAgent.indexOf("MSIE");
var OPER=navigator.userAgent.indexOf("Opera");

function doCouplet(){
	if((document.body.offsetWidth>800) && MSIE!=-1 && OPER==-1){	
	couplet_left.style.visibility='visible';
	couplet_right.style.visibility='visible';	  
	  couplet_left.style.top=100;
	  couplet_left.style.left=5;
	  couplet_right.style.top=100;
	  couplet_right.style.right=5;
	}
}