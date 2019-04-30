var app = angular.module('QuizWebApplication', []);
app.controller('createExamController', function($scope, $http) {
	$scope.Exam = {
		typeOfQuestion : "MCQ",
		questionText : "",
		option1 : "",
		option2 : "",
		option3 : "",
		option4 : "",
		correctAnswer : "",
		examInfo : ""
	};
	$scope.newQuestion = true;

	$scope.btn1 = false;

	$scope.submitCrateExam = function() {
		$http({
			method : 'POST',
			url : 'saveExam',
			data : angular.toJson($scope.Exam),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).success(function(data) {
			$scope.Exam = {
				typeOfQuestion : "MCQ",
				examInfo : $scope.Exam.examInfo

			};
			$scope.newQuestion = false;
			$scope.btn1 = true;

		}, function errorCallback(response) {
		});

	};

	$scope.showform = function() {
		$scope.newQuestion = true;
		$scope.btn1 = false;
	};

	$scope.Cancel = function() {
		$http({
			method : 'GET',
			url : 'cancelsubmitExam',
			data : angular.toJson($scope.Exam),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).success(function(data) {
			 window.location.href = ('./homepage');

		}, function errorCallback(response) {
		});
	};

});