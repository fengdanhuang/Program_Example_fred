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
        out.println("����ʱ�䣺" + d.toString() + "<BR>");

        if(c.get(Calendar.AM_PM) == Calendar.AM )
        	out.println("�簲");
        else
        	out.println("�簲");
%>

</body>
</html>
