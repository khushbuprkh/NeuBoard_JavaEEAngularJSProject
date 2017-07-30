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

import com.neu.edu.dao.StudentDAO;
import com.neu.edu.pojo.Enums;
import com.neu.edu.pojo.Student;

@Controller
@RequestMapping("/addStudent.htm")
public class addStudentController {
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String handleSaveMyData(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("student") Student student) throws Exception {

		String firstName = student.getFirstName();
		String lastName = student.getLastName();
		String emailId = student.getEmailId();
		Enums.Gender gender = student.getGender();
		String streetOne = student.getAddress().getStreetOne();
		String streetTwo = student.getAddress().getStreetTwo();
		String country = student.getAddress().getCountry();
		String state = student.getAddress().getState();
		String city = student.getAddress().getCity();
		int phNo = student.getPhoneNumber();
		String userName = student.getUserName();
		String password = student.getPassword();

		// Department d=teacher.getDepartment();

		StudentDAO studentDao = new StudentDAO();
		@SuppressWarnings("unused")
		Student s = studentDao.create(firstName, lastName, emailId, gender, streetOne, streetTwo, country, state, city,
				phNo, userName, password, Enums.RoleType.STUDENT, Enums.Status.ACTIVE);

		JSONObject obj = new JSONObject();
		obj.put("successmsg", "Student has been added successfully");
		PrintWriter out = response.getWriter();
		out.println(obj);
		return null;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("student") Student student, BindingResult result) {

		return "addStudent";
	}
}
