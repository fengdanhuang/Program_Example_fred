<%@ page contentType="text/html; charset=GBK" %>
<html>
<head>
<title>
ex08
</title>
</head>
<body bgcolor="#ffffff">
<%
	if((request.getParameter("id")).equals("1")){
%>
<jsp:forward page="ex09.jsp">
  <jsp:param name="user" value="ξ��"/>
  <jsp:param name="title" value="��ʦ"/>
</jsp:forward>
<%
	}
        else {
%>
<jsp:forward page="ex09.jsp">
  <jsp:param name="user" value="����"/>
  <jsp:param name="title" value="ѧ��"/>
</jsp:forward>
<%
	}
%>

</body>
</html>
