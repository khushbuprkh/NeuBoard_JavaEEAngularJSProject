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
import com.neu.edu.dao.DepartmentDAO;
import com.neu.edu.dao.TeacherDAO;
import com.neu.edu.pojo.Courses;
import com.neu.edu.pojo.Department;
import com.neu.edu.pojo.Teacher;

@Controller
@RequestMapping("/addCourses.htm")
public class addCoursesController {
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String handleSaveMyData(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("courses") Courses courses) throws Exception {
        String crn = courses.getCrn();   //get posting user from addAdvertForm
        String courseName=courses.getName();
        String departmentName = courses.getDepartment_name();   //get category user from addAdvertForm
        String teacherName= courses.getTeacher_name();
        try {
             CoursesDAO cd = new CoursesDAO();
            DepartmentDAO dd = new DepartmentDAO();
            TeacherDAO td = new TeacherDAO();

            //searhing from database
            Teacher user = td.get(teacherName);

            //searching from database
            Department department = dd.get(departmentName);

            //insert a new advert
            Courses c = cd.create(crn, courseName,user.getUserId(),department.getDepartmentId());
            
            user.addCourses(c);
            department.addCourses(c);
            dd.save(department);
            td.save(user);
            
            JSONObject obj = new JSONObject();
    		obj.put("successmsg", "Course has been added successfully");
    		PrintWriter out = response.getWriter();
    		out.println(obj);
    		return null;

            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       	
	return "addCourses";
	}
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("courses") Courses courses, BindingResult result) {

		return "addCourses";
	}
}
