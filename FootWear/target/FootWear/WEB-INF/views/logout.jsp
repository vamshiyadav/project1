 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>
</head>
<body>
<% 
session.invalidate();
%>

<h1 style="text-align: center;">THANK YOU and VISIT AGAIN </h1>
<a href="/FootWear/">Home</a>
</body>
 <div>
    <h4 >Copy Rights @ HYPE PVT LTD.</h4>
    </div>
    <br></br><br></br><br></br><br></br>
<%@include file="footer.jsp"%>