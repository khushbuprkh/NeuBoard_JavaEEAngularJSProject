<%@page import="com.neu.edu.pojo.Assignment"%>
<%@page import="com.neu.edu.dao.AssignmentDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.neu.edu.pojo.Courses"%>
<%@page import="com.neu.edu.pojo.User"%>
<%@page import="org.hibernate.Session"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
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
 
 <%
//get the department list
		User u=(User)session.getAttribute( "user" );
        com.neu.edu.dao.CoursesDAO coursesDao = new com.neu.edu.dao.CoursesDAO();
        com.neu.edu.dao.AssignmentDAO assignmentDao=  new com.neu.edu.dao.AssignmentDAO();
        ArrayList<Courses> coursesList =( ArrayList<Courses>) coursesDao.list(u.getUserId());
        pageContext.setAttribute("courses", coursesList);
        for(Courses c:coursesList)
        {  ArrayList<Assignment> assignmentList =( ArrayList<Assignment>)  assignmentDao.getList(c.getCourseId());
        	for(Assignment a:assignmentList)
        	{
%> 
<section>
	<div class="col-sm-12">
		<h1>Upload Assignment</h1>
<form:form role="form" commandName="assignment" onsubmit="return saveAssignment();" id="myForm" enctype="multipart/form-data">
<div class="form-group">
  <label for="sel1">Course:</label>
  <h3> <%=c.getName()%></h3>
</div> 
<div class="form-group">
  <label for="question">Question:</label>
  <form:textarea name="writeQuestion" class="form-control" rows="4" path="writeQuestion" id="question" value="<%=a.getWriteQuestion()%>" readonly></form:textarea>
</div>
 <div class="form-group">
  <label for="name">Attachments:</label>
  <form:input id="input-folder-1"  path="question" type="file" class="file-loading" name="uploadQuestion"/>
</div> 
 
<div class="form-group">
  <label for="possiblepoints">Possible Points:</label>
   <form:input type="text" class="form-control" value="<%=a.getPossiblepoints()%>" path="possiblepoints" id="possiblepoints"/>
</div>

 <div class="form-group">
  <label for="submission">Write Submission:</label>
   <form:textarea path="writeAnswer" class="form-control" rows="4" id="submission"/>
</div>

<form:input type='hidden' path='assignmentId' value="<%=a.getAssignmentId()%>" id='assignmentId'/>
<button type="submit" class="btn btn-default btn-success">Submit</button>
</form:form>
</div>
</section>
<%
}}
%>
