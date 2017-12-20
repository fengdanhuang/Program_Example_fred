<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="abc.JDBC_ODBC" %>
<html>
<head>
	<title>学生成绩查询系统</title>
</head>
<body bgcolor="#ffffff">
	<h1>系统查询结果</h1>
<%
	String id = request.getParameter("id");
        JDBC_ODBC j = new JDBC_ODBC();
        String result = j.getScore(id);

        if(result.indexOf(":") == -1){
          out.println("<font color=red size=3><b> 对不起，系统没有您的成绩 </b></font>");
        }
        else{
          out.println("姓名：" + new String((result.substring(0,result.indexOf(":"))).getBytes("ISO_8859_1"),"GB2312") + "<br>");
          out.println("数学：" + result.substring(result.indexOf(":")+1, result.indexOf(";")) + "<br>");
          out.println("英语：" + result.substring(result.indexOf(";")+1));
        }

%>
</body>
</html>
