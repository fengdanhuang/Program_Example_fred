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
  <jsp:param name="user" value="尉斌"/>
  <jsp:param name="title" value="教师"/>
</jsp:forward>
<%
	}
        else {
%>
<jsp:forward page="ex09.jsp">
  <jsp:param name="user" value="张三"/>
  <jsp:param name="title" value="学生"/>
</jsp:forward>
<%
	}
%>

</body>
</html>
