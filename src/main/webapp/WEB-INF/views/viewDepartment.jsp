<%@page import="java.util.List"%>
<%@page import="com.neu.edu.pojo.Department"%>
<%@page import="com.neu.edu.dao.DepartmentDAO"%>
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
        function deleteDepartment() {
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
            xmlHttp.open("POST", "viewDepartment.htm", true);
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
<%
//get the department list
		/* User u=(User)session.getAttribute( "user" ); */
        com.neu.edu.dao.DepartmentDAO department = new com.neu.edu.dao.DepartmentDAO();
        ArrayList<Department> departmentList = (ArrayList<Department>)department.list();
        pageContext.setAttribute("department", departmentList);
        out.println("<h1>Department List</h1>");
        for(Department d: departmentList)
        {
        d.getCourseList();
        %>
       
        <form:form role="form" commandName="department" onsubmit="return deleteDepartment();" id="myForm">
        <div class='col-sm-12 course'>
        <div class='form-group'>
        <%
        out.println("<h2> Department Name:"+d.getDepartmentName()+"</h2>");
        out.println("<textarea class='form-control' rows='2' id='syllabus'>"+d.getDepartmentDesc()+"</textarea>");
        
         for(Courses course:d.getCourseList())
         {
        	 out.println("<h2> CRN:"+course.getCrn()+"</h2>");
        	 out.println("<h4> CouraseName:"+course.getName()+"</h4>");
         }
         %>
        <form:input type='hidden' path='departmentId' value="<%=d.getDepartmentId()%>" id='departmentid'/>
        
        <form:button type="submit" class="btn btn-default btn-danger">Delete Department</form:button>
       	</div>
        </div>
        </form:form>
       
      <%
        }
       %>
 </section>