<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="./resources/css/welcomepage.css" />
<script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
	<title>Grid Test</title>
	<link href='https://fonts.googleapis.com/css?family=Lobster+Two|Raleway|Oswald:300' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
</head>
<body>


	<header class="top-bar">
		<a class="social-link" href="/"><i class="fa fa-google-plus"></i></a>
		<a class="social-link" href="/"><i class="fa fa-tumblr"></i></a>
		<a class="social-link" href="/"><i class="fa fa-twitter"></i></a>
		<a class="social-link" href="/"><i class="fa fa-linkedin"></i></a>
		<a class="social-link" href="/"><i class="fa fa-facebook"></i></a>
		<a class="contact-link" href="tel:+9131234567"><i class="fa fa-phone"></i> ${userName}</a>
		
	</header>

	<header class="main-header">
		<div class="logo-container">
			<p class="logo"><span>The</span> <span>Quiz web Application </span> <span>of France City</span></p>
		</div>
		<nav class="main-nav">
 			<ul>
				<li><a href="./homepage">Home</a></li>
				<li><a href="./createExam">Create Exam</a></li>
				<li><a href="./logout">Logout</a></li>
			</ul>
		</nav>
			</header>
 
	<section class="hero">
	    
		<div class="message">
			<p><span>Small Rodents.</span><br /><span>Big Ideas.</span></p>
			<a href="/join" class="message-button button">Join the SRSKC!</a>
		</div>
		<div class="award">
			<img src="http://chris.house/images/award.png" alt="Award">
			<blockquote>"One of Kansas City's<br /> Finest Rodent Societies!"<br />
				<cite>-Rat Fancy Magazine</cite>
			</blockquote>			
		</div>
		<div ng-app="QuizWebApplication" ng-controller="getallexams" style="position: absolute; right: 25%; bottom: 10%;">
		<h1>Exam List :</h1><hr><br>
			<h1 ng-repeat="exam in exams">
				<a href ng-click="getQuestionsById(exam)" >{{ exam.examInfo }}</a> <br><br>
			</h1>
		</div>
	</section>



	               
	

</body>
<script type="text/javascript">
var app = angular.module('QuizWebApplication', []);
app.controller('getallexams', function($scope, $http) {
	$scope.exams = []
	
	getUserDetails();
	function getUserDetails() {
		debugger;
		$http({
			method : 'GET',
			url : 'getAllExamList'
		}).then(function successCallback(response) {
			$scope.exams = response.data;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});


	}
		;
		$scope.getQuestionsById = function(exam) {

			$http({
				 method : 'POST',
				 url : 'getExamByExamID',
				 data : angular.toJson(exam),
				 headers : {
					 'Content-Type' : 'application/json'
					 }
			}).success( function (data) {
			window.location.href = ('./StartExam');
 		});
		};
	});
</script>
</html>