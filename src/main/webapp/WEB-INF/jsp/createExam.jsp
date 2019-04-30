<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
     <link rel="stylesheet" href="./resources/css/examcreate.css">
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
     
     <script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
     
   <script src="<c:url value="./resources/js/welcomepage.js"/>" type="text/javascript"></script>
     
<title>Create Exam</title>
</head>
<body>
<div ng-app="QuizWebApplication" ng-controller="createExamController"> 
<div id="newQuestion" ng-show="newQuestion">
<form  ng-submit="submitCrateExam()" method="post">
  <div class="container">
    <h1>Create Exam</h1>
    <hr>

 <label for="psw"><b>Exam Title</b></label>
                <input type="text" placeholder="Enter Question " name="examInfo" required ng-model="Exam.examInfo">

    <label for="typeOfQuestion"><b>Type of Question</b></label>
                   <select id="description" ng-model="Exam.typeOfQuestion" placeholder="Type of Question"  class="form-control" name="typeOfQuestion">
					<option  value="MCQ">MCQ</option>
					<option value="TEXT">TEXT</option>
					<option value="BOOLEAN">BOOLEAN</option>
					</select>
			    <label for="psw"><b>Question</b></label>
                <input type="text" placeholder="Enter Question " name="questionText" required ng-model="Exam.questionText">

                  <label for="psw"><b>option1</b></label>
                <input type="text" placeholder="option1 " name="option1" required ng-model="Exam.option1">

                <label for="psw"><b>option2</b></label>
                <input type="text" placeholder="option2" name="option2" required ng-model="Exam.option2">
                
                <label for="psw"><b>option3</b></label>
                <input type="text" placeholder="option3" name="option3" required ng-model="Exam.option3">
                
                <label for="psw"><b>option4</b></label>
                <input type="text" placeholder="option4" name="questionText" required ng-model="Exam.option4">
                
                
                <label for="psw"><b>Correct Answer</b></label>
                <input type="text" placeholder="Enter Answer " name="correctAnswer" required ng-model="Exam.correctAnswer">
                
                
                
                
    <hr></div>

    <button type="submit" class="registerbtn">Register</button>
     </div>
     <div ng-show="btn1" >
          <button type="button" id="btn1" class="registerbtn"  ng-click="showform()">Add one more Question</button>
 
           <button type="button"  class="registerbtn" ng-click="Cancel()">Cancel</button>
  </div>
  </div>
  
</form>
</body>

</html>