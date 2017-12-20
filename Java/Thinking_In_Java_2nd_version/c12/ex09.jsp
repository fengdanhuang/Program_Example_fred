<%@ page contentType="text/html; charset=GBK" %>
<html>
<head>
<title>
ex09
</title>
</head>
<body bgcolor="#ffffff">
<%
	out.println("<B>”√ªß£∫</B>" + new String((request.getParameter("user")).getBytes("ISO_8859_1"),"GB2312") + "<BR>" );
        out.println("<B>÷∞≥∆£∫</B>" + new String((request.getParameter("title")).getBytes("ISO_8859_1"),"GB2312") + "<BR>" );
%>
</body>
</html>
