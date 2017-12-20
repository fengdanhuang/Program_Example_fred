<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="abc.Conv" %>
<html>
<head>
<title>
ex04
</title>
</head>
<body bgcolor="#ffffff">
<%
	String s = "ÕÅÈý";
        out.println("<pre>String s = " + s + "<br>");
        out.println("ISO-8859-1 : " + Conv.toHexString(s) );
%>
</body>
</html>
