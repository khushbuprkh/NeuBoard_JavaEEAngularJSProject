<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Neu Board-Admin</title>
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
	var navigate = angular.module('navigate', ['ngRoute']);

	navigate.config(['$routeProvider', function($routeProvider) {
	  $routeProvider.
	  when('/addCourses', {
	    templateUrl: 'addCourses.htm',
	    /*controller: 'Controller'*/
	  }).
	  when('/viewCourses', {
	    templateUrl: 'viewCourses.htm',
	    /*controller: 'Controller'*/
	  }).
	    when('/addAdmin', {
	    templateUrl: 'addAdmin.htm',
	    /*controller: 'Controller'*/
	  }).
         when('/addTeacher', {
      templateUrl: 'addTeacher.htm',
      /*controller: 'Controller'*/
    }).
            when('/addStudent', {
      templateUrl: 'addStudent.htm',
      /*controller: 'Controller'*/
    }).
            when('/addDepartment', {
      templateUrl: 'addDepartment.htm',
      /*controller: 'Controller'*/
    }).  when('/viewDepartment', {
        templateUrl: 'viewDepartment.htm',
        /*controller: 'Controller'*/
      }). 
	  otherwise({
	    redirectTo: '/list'
	  });

	}]);
	
	navigate.controller('department',function($scope,$http)
	{
		
	});
	</script>
</head>
<body ng-app="navigate">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Neu Board</a>
    </div>
</br>
</br>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown">Manage Departments
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#/addDepartment">Add Departments</a></li>
          <li><a href="#/viewDepartment">View Departments</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown">Manage Courses
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#/addCourses">Add Courses</a></li>  
          <li><a href="#/viewCourses">View Courses</a></li>
        </ul>
      </li>
 <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown">Manage Users
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#/addTeacher">Add Teacher</a></li>
          <li><a href="#/addStudent">Add Student</a></li>
          <li><a href="#/addAdmin">Add Admin</a></li> 
        </ul>
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown">Reporting
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">List Of Students</a></li>
          <li><a href="#">List of Teachers</a></li>
          <li><a href="#">List of Admins</a></li> 
        </ul>
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Welcome ${user.userName}</a></li>
      <li><a href="/edu/"><span class="glyphicon glyphicon-off"></span>Logout</a></li>
    </ul>
  </div>
</nav>
<div class="main blackboard" ng-view ></div>
</body>
</html>