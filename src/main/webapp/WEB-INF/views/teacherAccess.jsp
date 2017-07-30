<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="navigate">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Neu Board-Teacher Access</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-animate.min.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
          <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="/main.css">
  <script type="text/javascript">
  var navigate = angular.module('navigate', ['ngRoute']);

  navigate.config(['$routeProvider', function($routeProvider) {
    $routeProvider.
    when('/homePageTeacher', {
      templateUrl: 'homePageTeacher.htm',
      /*controller: 'Controller'*/
    }).
    when('/uploadAssignment', {
      templateUrl: 'uploadAssignment.htm',
      /*controller: 'Controller'*/
    }).
      when('/addUser', {
      templateUrl: 'addUser.html',
      /*controller: 'Controller'*/
    }).
    when('/viewMyCourses', {
    	templateUrl: 'viewMyCourses.htm',
    }).
    otherwise({
      redirectTo: '/list'
    });

  }]);

    navigate.directive('draggable', function($document) {
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
  </script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Neu Board</a>
    </div>
</br>
</br>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#/homePageTeacher">Home</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown">Manage Activites
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#/uploadAssignment">Upload Assignment</a></li>  
          <li><a href="#/addCourses">Upload Course Contents</a></li>  
          <li><a href="#/addCourses">Add an Anouncement</a></li>  
          <li><a href="#/viewMyCourses">View Courses</a></li>  
          <li><a href="#/viewCourses">Grade Assignments</a></li>
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
<div class="row" ng-view>

</div>
</div>
</body>

</html>
