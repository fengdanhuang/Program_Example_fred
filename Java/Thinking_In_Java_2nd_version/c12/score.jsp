<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="abc.JDBC_ODBC" %>
<html>
<head>
	<title>ѧ���ɼ���ѯϵͳ</title>
</head>
<body bgcolor="#ffffff">
	<h1>ϵͳ��ѯ���</h1>
<%
	String id = request.getParameter("id");
        JDBC_ODBC j = new JDBC_ODBC();
        String result = j.getScore(id);

        if(result.indexOf(":") == -1){
          out.println("<font color=red size=3><b> �Բ���ϵͳû�����ĳɼ� </b></font>");
        }
        else{
          out.println("������" + new String((result.substring(0,result.indexOf(":"))).getBytes("ISO_8859_1"),"GB2312") + "<br>");
          out.println("��ѧ��" + result.substring(result.indexOf(":")+1, result.indexOf(";")) + "<br>");
          out.println("Ӣ�" + result.substring(result.indexOf(";")+1));
        }

%>
</body>
</html>
