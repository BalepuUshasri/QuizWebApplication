<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./resources/css/examstrat.css" />

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
<script src="https://code.angularjs.org/1.4.5/angular-route.js"></script>

<title>Start Exam</title>
</head>
<body>

	<div ng-app="QuizWebApplication" ng-controller="startExam">


		<div id="MCQ" ng-show="MCQ">
			<h1>{{questions.questionText}}</h1>
			<input type="radio" ng-model="ans" value="{{questions.option1}}">{{questions.option1}}<br>
			<input type="radio" ng-model="ans" value="{{questions.option2}}">{{questions.option2}}<br>
			<input type="radio" ng-model="ans" value="{{questions.option3}}">{{questions.option3}}<br>
			<input type="radio" ng-model="ans" value="{{questions.option4}}">{{questions.option4}}<br>
			<input type="button" value="Next Question"
				ng-click="starteExam(questions.questionId,ans)">

			</dbiv>

		</div>

		<div id="Text" ng-show="Text">
			<h1>{{questions.questionText}}</h1>
			<input type="text" ng-model="ans"><br> 
			<input
				type="hidden" ng-model="ans" value="{{questions.questionId}}"><br>

			<input type="button" value="Next Question"
				ng-click="starteExam(questions.questionId,ans)">

		</div>

		<div id="BOOLEAN" ng-show="BOOLEAN">
			<h1>{{questions.questionText}}</h1>
			<input type="hidden" ng-model="ans" value="{{questions.questionId}}"><br>

			<input type="radio" ng-model="ans" value="TRUE">TRUE<br>
			<input type="radio" ng-model="ans" value="FALSE">FALSE<br>
			<input type="button" value="Next Question" ng-click="starteExam(questions.questionId,ans)">

		</div>


<div class="startexambtn">
		<input type="button" value="Start" ng-click="starteExam(1,ans)"
			ng-show="startbtn"> </div>
			<input type="button" value="Submit"
			onclick="location.href='./submit';" ng-show="submitbtn">
</body>

<script type="text/javascript">
	var app = angular.module('QuizWebApplication', []);
	app.controller('startExam', function($scope, $http) {
		debugger;
		$scope.questions = []
		$scope.MCQ = false;
		$scope.startbtn = true;
		$scope.submitbtn = false;

		
		$scope.starteExam = function(id, ans) {
			debugger;
			$http({
				method : 'POST',
				url : 'getQuestionsbyID/' + id + '/' + ans,
				data : angular.toJson(id, ans),
				headers : {
					'Content-Type' : 'application/json'
				}
			}).success(function(data) {
				if(data==""){
					alert("Exam has Ended ");
					 window.location.href = ('./submit');

					$scope.startbtn = false;
					$scope.submitbtn = true;

				}else
				$scope.startbtn = false;

				if (data.typeOfQuestion == "BOOLEAN") {
					$scope.startbtn = false;

					$scope.MCQ = false;
					$scope.BOOLEAN = true;
					$scope.Text = false;

				} else if (data.typeOfQuestion == "TEXT") {
					$scope.ans="";
					$scope.startbtn = false;

					$scope.MCQ = false;
					$scope.BOOLEAN = false;
					$scope.Text = true;
				} else {
					$scope.startbtn = false;

					$scope.MCQ = true;
					$scope.BOOLEAN = false;
					$scope.Text = false;
				}
				$scope.questions = data;
				
				$scope.submitbtn = true;
				$scope.startbtn = false;
			}, function errorCallback(response) {
				alert("Exam has Ended ");
				$scope.submitbtn = true;

			});
			
		};
	});
</script>

</html>