<%@page import="java.util.Set"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%
//get the department list
        com.neu.edu.dao.CoursesDAO coursesDao = new com.neu.edu.dao.CoursesDAO();
		java.util.List courseList = coursesDao.list();
        pageContext.setAttribute("courses", courseList);

%>

<script>
 var xmlHttp;
        xmlHttp = GetXmlHttpObject();
        function saveCourses() {
            //alert("hello1");

            if (xmlHttp == null)
            {
                alert("Your browser does not support AJAX!");
                return;
            }
            var Depname = document.getElementById("name").value;
            var Depdesc = document.getElementById("desc").value;
    

            var query = "action=register&name=" + Depname + "&desc=" + Depdesc

            xmlHttp.onreadystatechange = function stateChanged()
            {
                if (xmlHttp.readyState == 4)
                {
                    //alert(xmlHttp.responseText);
                    var json = JSON.parse(xmlHttp.responseText);
                    document.getElementById("success").innerHTML = json.successmsg;
                }
            };
            xmlHttp.open("POST", "addCoursesStudent.htm", true);
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
	<h1>Add Courses</h1>
	<form:form role="form" commandName="student" onsubmit="return saveCourses();" id="myForm">
<div class="form-group">
  <label for="sel1">Course 1:</label>
<form:select class="form-control" id="sel1" path="name">
     <%--  <c:forEach var="t" items="${students}"> --%>
      <form:option value="${user.userName}"/>
     <%--  </c:forEach> --%>
  </form:select>
</div>
<div class="form-group">
  <label for="sel1">Course 1:</label>
<form:select multiple="true" class="form-control" id="sel1" path="courseLists">
<%--       <c:forEach var="c" items="${courses}">
      <form:option value="${c.crn}"/>
      </c:forEach> --%>
      <form:options items="${courses}"/>
  </form:select>
</div>

<button type="submit" class="btn btn-default btn-success">Submit</button>
<!-- <button class="btn btn-default btn-primary">Add Another Course</button> -->
</form:form>
</section>
