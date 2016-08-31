<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@include file="addItemheader.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="addProduct" commandName="item" enctype="multipart/form-data">
ItemName:<form:input path="itemName"></form:input><form:errors path="itemName" style="color:blue"></form:errors><br></br>
ItemDescription:<form:input path="description"></form:input><form:errors path="description" style="color:blue"></form:errors><br></br>
ItemPrice:<form:input path="price"></form:input><br></br>
Category:<form:select path="category"><br></br>
<form:option value="Reebok">Reebok</form:option><br></br>
<form:option value="Puma">Puma</form:option><br></br>
<form:option value="Addidas">Addidas</form:option><br></br>
</form:select><br></br>
Item Image:<input type="file" name="file"/><br></br>
<input type="submit" value="addItem"/><br></br>

</form:form>
<br></br><br></br><br></br><br></br>
<%@include file="footer.jsp"%>