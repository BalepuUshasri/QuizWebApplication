<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<link rel="stylesheet" href="./resources/css/result.css">

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

</head>
<body>


            <div class="widget widget-black shadow" >
                <div class="widget-title">Exam Result<br><br>
                You Got  ${rank}  marks outof ${totalQuestions}
                </div>
           
                <div>
                    <span class="pull-right">
                        <h3 class="" style="color: white;">${totalQuestions}<i  style="color: #D3D3D3;"></i></h3>
                    </span>
                    <span class="pull-left text-warning">
                        <h3 class="" style="color: white;"><i ></i>${rank}</h3>
                    </span>
                </div>
                <div style="clear: both;"></div>
                <div class="" style="max-height: 5px;">
                    <div class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" style="width:20%">
                        <strong style="color: black;">${rank} %</strong>
                    </div>
                    <div class="progress-bar progress-bar-info progress-bar-striped active" role="progressbar" style="width:80%">
                        <strong style="color: black;">${totalQuestions} %</strong>
                    </div>

                </div>
                <div class="widget-controls hidden">
                
                    <a href="#" class="widget-control-right"><span class="fa fa-times"></span></a>
                    
                </div>
            </div>
    
     
</body>
</html>