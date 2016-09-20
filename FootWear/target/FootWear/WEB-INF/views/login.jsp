<%@include file="headerlogin.jsp" %>

<form action="<c:url value='j_spring_security_check'/>" method="post">
<div class="container" align="center">
Email:<br>
<input type="text" name="j_username" placeholder="Email" required><br>
Password:<br>
<input type="password" name="j_password" placeholder="password" required><br>
<br>
<input type="Submit" placeholder="Submit">
</div>
</form>
<br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br><br>
<%@include file="footer.jsp"%>