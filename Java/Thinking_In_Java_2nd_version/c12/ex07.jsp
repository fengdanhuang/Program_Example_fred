
<%@ page contentType="text/html; charset=GBK" %>
<jsp:useBean id="counterBean" scope="session" class="CounterBean">
</jsp:useBean>
<html>
<head>
<title>
ex07
</title>
</head>
<body bgcolor="#ffffff">

<jsp:setProperty name="counterBean" property="count" value="10"/>

count÷µ£∫
<jsp:getProperty name="counterBean" property="count" />
</body>
</html>
