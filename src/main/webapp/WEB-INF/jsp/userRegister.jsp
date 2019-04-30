<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./resources/css/userLogin.css" />
<script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<title>User Registration</title>
</head>
<body>
	<p>User Registration</ !</p>
	<div ng-app="QuizWebApplication" ng-controller="userRegister">
	<form ng-submit="UserRegistration()">
			<input type="text" placeholder="Username" ng-model="userform.userName">
			<input type="password" placeholder="Password" ng-model="userform.password">
		<input type="password" placeholder="Confirm Password" ng-model="userform.password1">
			 
				 <span style="color: red;" ng-show="invalid">Invalid Details</span>
				 <input type="submit" value="Register" ng-click="">
				 
				</form>
				
		<div>

</body>

<script type="text/javascript">
var app = angular.module('QuizWebApplication', []);

	app.controller('userRegister', function($scope, $http) {
		$scope.invalid=false;	

		$scope.userform = {
			userName : "",
			password : "",
			password1 : ""
		};
		debugger;
		
		$scope.UserRegistration = function() {
			
			if($scope.userform.userName===''){
				$scope.invalid=true;
			}else{
			debugger;
		if(	$scope.userform.password==	$scope.userform.password1){
			$http({
				method : 'post',
				url : 'saveUser',
				data : angular.toJson($scope.userform),
				headers : {
					'Content-Type' : 'application/json'
				}
			}).success(function(data) {
				 window.location.href = ('./');
			});

			
			
			
		}else{
			$scope.invalid=true;	
		}
		}}
	});
</script>


</html>