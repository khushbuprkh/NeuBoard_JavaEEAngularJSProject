<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%
//get the department list
        com.neu.edu.dao.DepartmentDAO departmentDao = new com.neu.edu.dao.DepartmentDAO();
        java.util.List departmentList = departmentDao.list();
        pageContext.setAttribute("departments", departmentList);
        
      //get the department list
        com.neu.edu.dao.TeacherDAO teacherDao = new com.neu.edu.dao.TeacherDAO();
        java.util.List teacherList = teacherDao.list();
        pageContext.setAttribute("teachers", teacherList);
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
            xmlHttp.open("POST", "addCourses.htm", true);
            xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlHttp.send(query);
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
	<form:form role="form" commandName="courses" onsubmit="return saveCourses();" id="myForm">
<div class="col-sm-4">
<div class="form-group">
  <label for="crn">CRN:</label>
  <form:input type="text" path="crn" class="form-control" name="crn" id="crn"/>
</div>
<div class="form-group">
  <label for="name">Course Name:</label>
  <form:input type="text" path="name" class="form-control" name="name" id="name"/>
</div>

<div class="form-group">
  <label for="sel1">Department:</label>
  <form:select class="form-control" id="sel1" path="Department_name">
      <c:forEach var="dep" items="${departments}">
      <form:option value="${dep}"/>
      </c:forEach>
  </form:select>
</div> 

<!-- <div class="form-group">
  <label for="sel1">Major:</label>
  <select class="form-control" id="sel1">
    <option>1</option>
    <option>2</option>
    <option>3</option>
    <option>4</option>
  </select>
</div> -->

<div class="form-group">
  <label for="sel1">Professor:</label>
<form:select class="form-control" id="sel1" path="Teacher_name">
      <c:forEach var="t" items="${teachers}">
      <form:option value="${t}"/>
      </c:forEach>
  </form:select>
</div>

<%-- <div class="form-group">
  <label for="desc">Description:</label>
  <form:textarea path="" class="form-control" rows="4" id="desc"/>
</div> --%>
<!-- <button class="btn btn-default btn-primary">Add Another Course</button> -->

<%-- <div class="form-group">
  <label for="desc">Start Date:</label>
  <form:input type="date" path="startDate" rows="4" id="desc"/>
</div>
<!-- <button class="btn btn-default btn-primary">Add Another Course</button> -->
<div class="form-group">
  <label for="desc">End Date:</label>
  <form:input type="date" path="endDate" rows="4" id="desc"/>
</div> --%>
<button type="submit" class="btn btn-default btn-success">Submit</button>
<!-- <button class="btn btn-default btn-primary">Add Another Course</button> -->
</div>
</form:form>
</section>
