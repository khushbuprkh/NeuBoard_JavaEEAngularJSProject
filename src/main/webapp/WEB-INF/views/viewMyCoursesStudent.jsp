<%@page import="com.neu.edu.pojo.Student"%>
<%@page import="com.neu.edu.dao.UserDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.neu.edu.pojo.Courses"%>
<%@page import="com.neu.edu.pojo.User"%>
<%@page import="org.hibernate.Session"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
//get the department list
		Student s=(Student)session.getAttribute("user");
        com.neu.edu.dao.CoursesDAO coursesDao = new com.neu.edu.dao.CoursesDAO();
       out.println("<h1>Courses</h1>");
        for(Courses course: s.getCourseList())
        {     
        out.println("<section>");
        out.println("<form method='post' action='#/deletes.htm'>");
        out.println("<div class='col-sm-12 course'>");
        out.println("<div class='form-group'>");
        out.println("<h2> CRN:"+course.getCrn()+"</h2>");
        int userId=course.getUserId();
        com.neu.edu.dao.UserDAO userDao = new com.neu.edu.dao.UserDAO();
        User prof= userDao.list(userId);
        out.println("<p>Professor:"+prof.getUserName()+"</p>");
        out.println(" <label for='syllabus'>Syllabus</label>");
       	out.println("<textarea class='form-control' rows='4' id='syllabus'>"+course.getName()+"</textarea>");
       /* 	out.println("<input type='Submit' class='btn btn-danger' value='Delete Course'>"); */	
        out.println("<input type='Submit' class='btn btn-danger' value='Delete Course'>");
        out.println(" </div>");
        out.println(" </div>");
        out.println("</form>");
        out.println("</section>");
        }
       
%>
<%-- <section>
	<h1>Your Courses</h1>
	<div class="col-sm-6 course">
		<div class="form-group">
			<h2>${courses.Name}</h2>

			<p>{courses.}</p>
			<label for="syllabus">Syllabus</label>
			<textarea class="form-control" rows="4" id="syllabus"></textarea>
		</div>
	</div>
</section> --%>
