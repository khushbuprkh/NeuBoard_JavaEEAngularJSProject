<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="drag">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Neu Board-Student Access</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-animate.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<style>
     <%@ include file="main.css"%>
</style>
  <script type="text/javascript">
var drag = angular.module('drag', ['ngRoute']);

  drag.directive('draggable', function($document) {
    return function(scope, element, attr) {
      var startX = 0, startY = 0, x = 0, y = 0;
      element.css({
       position: 'relative',
       border: '1px solid',
       backgroundColor: 'lightgrey',
       cursor: 'pointer',
       display: 'block',
      });
      element.on('mousedown', function(event) {
        // Prevent default dragging of selected content
        event.preventDefault();
        startX = event.screenX - x;
        startY = event.screenY - y;
        $document.on('mousemove', mousemove);
        $document.on('mouseup', mouseup);
      });

      function mousemove(event) {
        y = event.screenY - startY;
        x = event.screenX - startX;
        element.css({
          top: y + 'px',
          left:  x + 'px'
        });
      }

      function mouseup() {
        $document.off('mousemove', mousemove);
        $document.off('mouseup', mouseup);
      }
    };
  });
  
  drag.config(['$routeProvider', function($routeProvider) {
    $routeProvider.
 when('/addCoursesStudent', {
      templateUrl: 'addCoursesStudent.htm',
      /*controller: 'Controller'*/
    }).
    when('/homePageStudent', {
      templateUrl: 'homePageStudent.htm',
      /*controller: 'Controller'*/
    }).
    when('/viewMyCoursesStudent', {
      templateUrl: 'viewMyCoursesStudent.htm',
      /*controller: 'Controller'*/
    }).when('/submitAssignment', {
        templateUrl: 'submitAssignment.htm',
        /*controller: 'Controller'*/
      }).when('/delete', {
          templateUrl: 'viewMyCoursesStudent.htm',
          /*controller: 'Controller'*/
        }).    
    otherwise({
      redirectTo: '/list'
    });

  }]);
  </script>
</head>
<body class="mainpage">

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Neu Board</a>
    </div>
</br>
</br>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#/homePageStudent">Home</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown">Manage Activities
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
        <li><a href="#/addCoursesStudent">Add Courses</a></li>
          <li><a href="#/submitAssignment">My Assignment</a></li>
          <li><a href="#/viewMyCoursesStudent">View My Courses</a></li>
          <li><a href="#/viewMyGrades ">View My Grades</a></li> 
          <li><a href="#">Send Mail</a></li> 
        </ul>
      </li>

      <li><a href="#">Chat</a></li> 
      <li><a href="#">Discussion Board</a></li> 
    </ul>
    <ul class="nav navbar-nav navbar-right">
         <li><a href="#"><span class="glyphicon glyphicon-user"></span> Welcome ${user.userName}</a></li>
      <li><a href="/edu/"><span class="glyphicon glyphicon-off"></span>Logout</a></li>
    </ul>
  </div>
</nav>
<div class="row blackboard" ng-view>

</div>
</body>

</html>
