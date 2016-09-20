<%@include file="header2.jsp" %>
 <% 
 response.setHeader("pragma", "no-cache");
 response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
 response.setHeader("Expires", "0");
 %>
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

<div>
<div class="container">
  <div ng-app="myApp" ng-controller="dataCtrl">
Enter Name/Email ID: <input type="text"  ng-model="search">&nbsp&nbsp<span class="glyphicon glyphicon-search"></span>
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
        <tr ng-repeat="resource in names | filter:search">
             <td>{{resource.itemId}}</td>
             <td>{{resource.itemName}}</td>
            <td>{{resource.description}}</td>
            <td>{{resource.category}}</td>
            <td>{{resource.price}}</td>
            <td><img src="resources/images/{{resource.itemId}}.jpg" style="width:100px;height:100px;"/></td>
            <td><a href="viewSelectedItem?id={{resource.itemId}}">View Products</a></td>
            
            
         
    </table>
</div>
<script>
angular.module('myApp',[]).controller('dataCtrl',function($scope)
		{
	
		$scope.names=${items};
		$scope.orderByMe=function(x)
		{
			$scope.myOrderBy=x;
			}
		});
</script>
<br></br><br></br><br></br><br></br>
<%@include file="footer.jsp"%>