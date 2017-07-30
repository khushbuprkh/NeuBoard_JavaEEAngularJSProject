<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Neu Board</title>
<!-- 	<script src="lib/angular/angular.min.js"></script>
	<script src="js/app.js"></script> -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<style>
<%@ include file="main.css"%>
</style>
</head>
<body class="loginpage">
<div class="container">
  <div class="jumbotron bgcolor">
    <h1 class="cntrbtn">Neu Board</h1>
  </div>
  <div class="row">
  	<div class="col-sm-4">
  	</div>
    <div class="col-sm-4">
 <form:form role="form" method="post" commandName="user" action="login.htm" >
    <div class="form-group">
      <label for="email" >User Name:</label>
      <form:input path="userName" type="text" class="form-control" id="email" placeholder="Enter UserName"/>
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <form:input path="password" type="password" class="form-control" id="pwd" placeholder="Enter password"/>
    </div>
    <div class="checkbox cntrbtn">
      <label><input type="checkbox"> Remember me</label>
    </div>
  <span style="color:#ffffff;text-align:center">${LoginErrors}</span>
    <form:button type="submit" class="btn btn-default center-block">Submit</form:button>
      
  </form:form>
 </div>
 <div class="col-sm-4">
  	</div>
  </div>
</div>
</body>
