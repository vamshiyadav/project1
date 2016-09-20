<%@include file="header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<style>
body
{
background-image:url(resources/images/signup-background.jpg);
background-size: 100% 100%;
    background-repeat: no-repeat;
}
#center1{
margin-top:-4%;
margin-left:40%;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id=center1>
<table>
<form:form commandName="customer" >
<tr><td>UserName:</td><td><form:input path="username"></form:input><form:errors path="username" style="color:blue"></form:errors></td></tr><br>
<tr><td>Password:</td><td><form:password path="password"></form:password><form:errors path="password" style="color:blue"></form:errors></td></tr><br>
<tr><td>EmailId:</td><td><form:input path="emailid"></form:input><form:errors path="emailid" style="color:blue"></form:errors></td></tr><br>
<tr><td><input class="col-offset-3" type="submit" name="_eventId=submit" value="Register"/></td></tr>
</form:form>
</table>
</div>

<br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br></br><br></br><br></br></br><br></br><br></br>
<%@include file="footer.jsp"%>