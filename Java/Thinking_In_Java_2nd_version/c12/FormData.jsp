<%@ page contentType="text/html; charset=GBK" %>
<html>
<head>
<title>
FormData
</title>
</head>
<body bgcolor="#ffffff">
<% java.util.Enumeration e = request.getParameterNames() ; %>
<table border="1">
  <tr >
    <th >name</th>
    <th >value</th>
  </tr>
  <%
     while (e.hasMoreElements() )
     {
       String name = new String(((String)e.nextElement()).getBytes("ISO_8859_1"),"GB2312");
       out.println("<tr><td>" + name + "</td>");
       out.println("<td>" + new String((request.getParameter(name)).getBytes("ISO_8859_1"),"GB2312") + "</td></tr>");
     }
%>
</table>
</body>
</html>
