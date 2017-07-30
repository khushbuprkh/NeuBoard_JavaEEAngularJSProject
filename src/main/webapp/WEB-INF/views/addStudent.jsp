<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<script>
 var xmlHttp;
        xmlHttp = GetXmlHttpObject();
        function saveStudent() {
            //alert("hello1");

            if (xmlHttp == null)
            {
                alert("Your browser does not support AJAX!");
                return;
            }  

            xmlHttp.onreadystatechange = function stateChanged()
            {
                if (xmlHttp.readyState == 4)
                {
                    //alert(xmlHttp.responseText);
                    var json = JSON.parse(xmlHttp.responseText);
                    document.getElementById("success").innerHTML = json.successmsg;
                }
            };
            xmlHttp.open("POST", "addStudent.htm", true);
            xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            return false;
        }
        
        function GetXmlHttpObject()
        {
            var xmlHttp = null;
            try
            {
                // Firefox, Opera 8.0+, Safari
                xmlHttp = new XMLHttpRequest();
            } catch (e)
            {
                // Internet Explorer
                try
                {
                    xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e)
                {
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
            }
            return xmlHttp;
        }
        </script>
<section>
</br>
	<h1>Add Student</h1>

<span id="success"></span>
<form:form role="form" commandName="student" onsubmit="return saveStudent()"></br>
<div class="form-group">
  <label for="firstName">First Name</label>
  <form:input path="firstName" type="text" class="form-control" name="firstName" id="firstName"/>
</div>
<div class="form-group">
  <label for="lastName">Last Name:</label>
  <form:input path="lastName" type="text" class="form-control" name="lastName" id="lastName"/>
</div>
<div class="form-group">
  <label for="email">Email Id:</label>
  <form:input path="emailId" type="email" class="form-control" name="emailId" id="emailId"/>
</div>
<div class="form-group">
  <label for="phNo">Phone Number:</label>
  <form:input path="phoneNumber" type="text" class="form-control" name="phNo" id="phNo"/>
</div>
<%-- <div class="form-group">
  <label for="sel1">Role:</label>
  <form:select path="userAccount.roleType" class="form-control" id="sel1">
  </form:select>
</div>  --%>
  <div class="form-group">
  <label for="strt1">Street 1</label>
  <form:input path="address.streetOne" type="text" class="form-control" name="strt1" id="strt1"/>
</div>
<div class="form-group">
  <label for="strt2">Street 2</label>
  <form:input path="address.streetTwo" type="text" class="form-control" name="strt2" id="strt2"/>
</div>
<div class="form-group">
  <label for="country">Country</label>
  <form:input path="address.country" type="text" class="form-control" name="country" id="country"/>
</div>
<div class="form-group">
  <label for="state">State</label>
  <form:input path="address.state" type="text" class="form-control" name="state" id="state"/>
</div>
<div class="form-group">
  <label for="city">City</label>
  <form:input path="address.city" type="text" class="form-control" name="city" id="city"/>
</div>
<%--   <div class="form-group">
  <label for="sel1">Department:</label>
  <form:select class="form-control" id="sel1" path="department">
      <c:forEach var="dep" items="${departments}">
      <form:option value="${dep}"/>
      </c:forEach>
  </form:select>
</div> --%>
 <div class="form-group">
  <label for="userName">User Name</label>
  <form:input path="userName" type="text" class="form-control" name="userName" id="userName"/>
</div>
<div class="form-group">
  <label for="password">Password</label>
  <form:input type="password" path="password" class="form-control" name="password" id="pwd"/>
</div>
</br>
<!-- <div class="radio">
  Status: <label><input type="radio" name="status">Active</label>
  <label><input type="radio" name="status">Inactive</label>
</div> -->
<form:button type="submit" class="btn btn-default btn-success">Submit</form:button>
</form:form>
</section>
