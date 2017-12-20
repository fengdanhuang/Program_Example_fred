<%@ page contentType="text/html; charset=GBK" %>
<%@ page language="java" import="java.util.*" %>
<html>
<head>
<title>
AmPm.jsp
</title>
</head>
<body bgcolor="#ffffff">

<%
	Calendar c = Calendar.getInstance();
        Date d = c.getTime();
%>
        现在时间：<%= d.toString() %> <BR>
 <%
        if(c.get(Calendar.AM_PM) == Calendar.AM )
%>
		早安
<%      else	%>
		午安

</body>
</html>
