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
<title>Login</title>
</head>
<body>

	<h1>Quiz</h1>
	<p>I love anything quiz related !</p>
	<div ng-app="QuizWebApplication" ng-controller="userlogin">


		<form ng-submit="submitUserForm()">
		<span style="color: red;  position: absolute; line-height: 0px; right: 43%;" ng-show="errormsg">Username and Password incorrect</span>
			<input type="text" placeholder="Username" ng-model="userform.userName">
			<input type="password" placeholder="Password"
				ng-model="userform.password">
				 <input type="submit"
				value="Sign In">	
				 <input type="button" value="Sign Up" ng-click="userRegister()">
				</form>
		<div>
</body>
<script>
	var app = angular.module('QuizWebApplication', []);
	app.controller('userlogin', function($scope, $http) {
		$scope.errormsg=false;
		$scope.userform = {
				userName : "",
			password : ""
		};
		
		$scope.userRegister = function() {
			 window.location.href = ('./userRegister');

		}
		$scope.submitUserForm = function() {
			debugger;
			if($scope.userform.userName==''|$scope.userform.password==''){
				$scope.errormsg=true;

			}else
			
			$http({
				method : 'post',
				url : 'uservalidation',
				data : angular.toJson($scope.userform),
				headers : {
					'Content-Type' : 'application/json'
				}
			}).success(function(data) {
				 window.location.href = ('./homepage');
			},	 function errorCallback(response) {
				$scope.errormsg=true;

					}).catch(function (reason) {
						$scope.errormsg=true;
					   });
		}
	});
</script>
</html>