<%@ page contentType="text/html; charset=GBK" %>
<html>
<head>
	<title>Square.jsp</title>
</head>
<body bgcolor="#ffffff">

	<%! int i = 5; %>
	<b>5��ƽ��=</b> <%= i*i %> <br />

	<%!
		public int square(int i){
          		return (i*i);
		}
	%>
	<b>10��ƽ��=</b> <%= square(10) %> <br />

</body>
</html>
