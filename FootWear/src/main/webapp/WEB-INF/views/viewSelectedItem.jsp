<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FootWear</title>
</head>
 <% 
 response.setHeader("pragma", "no-cache");
 response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
 response.setHeader("Expires", "0");
 %>
  <title>Shoe Clue's</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
  <script>document.write('<base href="' + document.location + '" />');</script>
    <link href="./resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="./resources/css/style.css" rel="stylesheet" media="screen">
    <script data-require="angular.js@1.0.x" src="http://code.angularjs.org/1.0.7/angular.min.js" data-semver="1.0.7"></script>

  <%@ include file="adminhead.jsp"%> 
</head>
<body>

    <hr></hr>
    <table class="table table-striped">
    <tr>
    <th>ProductId</th>
    <th>ProductName</th>
    <th>ProductDescription</th>
    <th>Category</th>
    <th>Price</th>
    <th>Image</th>
    </tr>
        <tr>
             <td>${item.itemId}</td>
             <td>${item.itemName}</td>
             <td>${item.description}</td>
             <td>${item.category}</td>
             <td>${item.price}</td>
            <td><img src="resources/images/${item.itemId}.jpg" style="width:100px;height:100px;"/></td>
        </tr>    
    </table>
</div>
</body>
</html>