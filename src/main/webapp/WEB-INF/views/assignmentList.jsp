<%@page import="com.neu.edu.pojo.Assignment"%>
<%@page import="com.neu.edu.dao.AssignmentDAO"%>
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
        com.neu.edu.dao.AssignmentDAO assignmentDAO = new com.neu.edu.dao.AssignmentDAO();
       out.println("<h1>Assignment List</h1>");
        for(Courses course: s.getCourseList())
        {     
        	ArrayList<Assignment> assign= (ArrayList<Assignment>)assignmentDAO.getList(course.getCourseId());
             for(Assignment a: assign)
            		 {
            	            		
        out.println("<section>");
        out.println("<form method='post' action='uploadAssignment.htm'>");
        out.println("<div class='col-sm-12 course'>");
        out.println("<div class='form-group'>");
        out.println("<h2> CRN:"+course.getCrn()+"</h2>");
        out.println("<h3>"+a.getWriteQuestion()+"<h3>");
        out.println("<h3>"+a.getPossiblepoints()+"<h3>");
        out.println("<input type='Submit' class='btn btn-primary' value='View & Complete Assignment'>");
        out.println("</div>");
        out.println("</div>");
        out.println("</form>");
        out.println("</section>");
            		 }
        }
       
%>