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
        ����ʱ�䣺<%= d.toString() %> <BR>
 <%
        if(c.get(Calendar.AM_PM) == Calendar.AM )
%>
		�簲
<%      else	%>
		�簲

</body>
</html>
