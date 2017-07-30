package com.neu.edu.controller;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.neu.edu.dao.CoursesDAO;
import com.neu.edu.dao.StudentDAO;
import com.neu.edu.pojo.Courses;
import com.neu.edu.pojo.Student;

@Controller
@RequestMapping("/addCoursesStudent.htm")
public class addCoursesStudentController {
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String handleSaveMyData(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("student")Student student) throws Exception {
        String[] courselist = student.getCourseLists();
        String name=student.getName();
        //get posting user from addAdvertForm
           try {
        	CoursesDAO cd=new CoursesDAO();
        	StudentDAO sd=new StudentDAO();
        	Student s=sd.get(name);
        	
        	
        		for(int i=0; i<=courselist.length;i++)
        		{
        			Courses c= cd.get(courselist[i]);	
        			s.addCourses(c);
        			sd.save(s);
        		}
            
            JSONObject obj = new JSONObject();
    		obj.put("successmsg", "Courses have been added successfully");
    		PrintWriter out = response.getWriter();
    		out.println(obj);
    		return null;

            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       	
	return "addCoursesStudent";
	}
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("student") Student student, BindingResult result) {

		return "addCoursesStudent";
	}

}
