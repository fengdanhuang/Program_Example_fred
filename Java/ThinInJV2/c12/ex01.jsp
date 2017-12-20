<%@ page contentType="text/html; charset=GBK" %>
<html>
<head>
	<title>Square.jsp</title>
</head>
<body bgcolor="#ffffff">

	<%! int i = 5; %>
	<b>5的平方=</b> <%= i*i %> <br />

	<%!
		public int square(int i){
          		return (i*i);
		}
	%>
	<b>10的平方=</b> <%= square(10) %> <br />

</body>
</html>
