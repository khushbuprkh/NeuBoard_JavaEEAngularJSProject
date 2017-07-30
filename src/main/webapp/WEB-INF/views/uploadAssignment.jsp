<%@page import="com.neu.edu.pojo.User"%>
<%@page import="org.hibernate.Session"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
//get the department list
		User u=(User)session.getAttribute( "user" );
        com.neu.edu.dao.CoursesDAO coursesDao = new com.neu.edu.dao.CoursesDAO();
        java.util.List coursesList = coursesDao.list(u.getUserId());
        pageContext.setAttribute("courses", coursesList);
%>
<script>
 var xmlHttp;
        xmlHttp = GetXmlHttpObject();
        function saveAssignment() {
            //alert("hello1");

            if (xmlHttp == null)
            {
                alert("Your browser does not support AJAX!");
                return;
            }
            var firstName = document.getElementById("name").value;
            var Depdesc = document.getElementById("desc").value;
   

            xmlHttp.onreadystatechange = function stateChanged()
            {
                if (xmlHttp.readyState == 4)
                {
                    //alert(xmlHttp.responseText);
                    var json = JSON.parse(xmlHttp.responseText);
                    document.getElementById("success").innerHTML = json.successmsg;
                }
            };
            xmlHttp.open("POST", "uploadAssignment.htm", true);
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
	<div class="col-sm-12">
		<h1>Upload Assignment</h1>
<form:form role="form" commandName="assignment" onsubmit="return saveAssignment();" id="myForm">
<div class="form-group">
  <label for="sel1">Course:</label>
  <form:select class="form-control" id="sel1" path="CourseName">
      <c:forEach var="c" items="${courses}">
      <form:option value="${c}"/>
      </c:forEach>
  </form:select>
</div> 
<div class="form-group">
  <label for="question">Question:</label>
  <form:textarea name="writeQuestion" class="form-control" rows="4" path="writeQuestion" id="question"></form:textarea>
</div>
<div class="form-group">
  <label for="possiblepoints">Possible Points:</label>
   <form:input type="text" class="form-control" path="possiblepoints" id="possiblepoints"/>
</div>

<button type="submit" class="btn btn-default btn-success">Submit</button>
</form:form>
</div>
</section>
