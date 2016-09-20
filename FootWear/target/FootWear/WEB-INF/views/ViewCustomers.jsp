<%@ include file="adminhead.jsp"%> 
 <%response.setHeader("pragma", "no-cache");
 response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
 response.setHeader("Expires", "0");%>
 
<div>
<div class="container">
  <div ng-app="myApp" ng-controller="dataCtrl">
  Data:${ss}
Enter Name/Email ID: <input type="text"  ng-model="search">&nbsp&nbsp<span class="glyphicon glyphicon-search"></span>
    <hr></hr>
    <table class="table table-striped">
    <tr>
    <th>Id</th>
    <th>username</th>
    <th>Email</th>
    </tr>
        <tr ng-repeat="resource in names | filter:search">
             <td>{{ resource.customerid}}</td>
             <td>{{resource.username}}</td>
            <td>{{ resource.emailid}}</td>
        </tr>    
    </table>
</div>
<script>
angular.module('myApp',[]).controller('dataCtrl',function($scope)
		{
	
		$scope.names=${listOfCustomers};
		$scope.orderByMe=function(x)
		{
			$scope.myOrderBy=x;
			}
		});
</script>
<br></br><br></br><br></br><br></br>
<%@include file="footer.jsp"%>
