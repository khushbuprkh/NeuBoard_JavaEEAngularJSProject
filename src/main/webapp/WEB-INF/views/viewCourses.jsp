<%@page import="com.neu.edu.dao.UserDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.neu.edu.pojo.Courses"%>
<%@page import="com.neu.edu.pojo.User"%>
<%@page import="org.hibernate.Session"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
 var xmlHttp;
        xmlHttp = GetXmlHttpObject();
        function deleteCourses() {
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
            xmlHttp.open("POST", "viewCourses.htm", true);
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
        com.neu.edu.dao.CoursesDAO coursesDao = new com.neu.edu.dao.CoursesDAO();
        ArrayList<Courses> coursesList = (ArrayList<Courses>)coursesDao.list();
        pageContext.setAttribute("courses", coursesList);
        out.println("<h1>Course List</h1>");
        for(Courses course: coursesList)
        {
        course.getStudentList();
        %>
        <section>
               
       <form:form role="form" commandName="courses" onsubmit="return deleteCourses();" id="myForm">
        <div class='col-sm-12 course'>
        <div class='form-group'>
        <%
        out.println("<h2> CRN:"+course.getCrn()+"</h2>");
        int userId=course.getUserId();
        com.neu.edu.dao.UserDAO userDao = new com.neu.edu.dao.UserDAO();
        User u= userDao.list(userId);
        out.println("<p>Professor:"+u.getUserName()+"</p>");
        out.println(" <label for='syllabus'>Syllabus</label>");
       	out.println("<textarea class='form-control' rows='4' id='syllabus'>"+course.getName()+"</textarea>");
       	%>
       	<form:input type='hidden' path='courseId' value="<%=course.getCourseId()%>" id='courseId'/>
       	<button type="submit" class="btn btn-default btn-danger">Delete Courses</button>
       
        </div>
        </div>
        </form:form>  
       </section>
       <%
       }
       %>