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
import com.neu.edu.pojo.Courses;
import com.neu.edu.pojo.Department;
import com.neu.edu.pojo.User;

@Controller
@RequestMapping("/viewCourses.htm")
public class viewCoursesController {
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String handleSaveMyData(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("courses") Courses courses) throws Exception {

		int courseId = courses.getCourseId();
		CoursesDAO cd = new CoursesDAO();
		
		Courses cr = cd.getCourse(courseId);
		cd.delete(cr);

		JSONObject obj = new JSONObject();
		obj.put("successmsg", "Course "+cr.getCrn()+" has been deleted successfully");
		PrintWriter out = response.getWriter();
		out.println(obj);
		return null;
	}
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("courses") Courses courses, BindingResult result) {

		return "viewCourses";
	}

}
