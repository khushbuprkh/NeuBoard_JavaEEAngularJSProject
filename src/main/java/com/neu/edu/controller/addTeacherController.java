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
import com.neu.edu.dao.TeacherDAO;
import com.neu.edu.pojo.Enums;
import com.neu.edu.pojo.Teacher;

@Controller
@RequestMapping("/addTeacher.htm")
public class addTeacherController {
	/*
	 * @RequestMapping(method = RequestMethod.POST) protected String
	 * doSubmitAction(@ModelAttribute("teacher") Teacher teacher) throws
	 * Exception { return "addTeacher"; }
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String handleSaveMyData(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("teacher") Teacher teacher) throws Exception {

		String firstName = teacher.getFirstName();
		String lastName = teacher.getLastName();
		String emailId = teacher.getEmailId();
		Enums.Gender gender = teacher.getGender();
		String streetOne = teacher.getAddress().getStreetOne();
		String streetTwo = teacher.getAddress().getStreetTwo();
		String country = teacher.getAddress().getCountry();
		String state = teacher.getAddress().getState();
		String city = teacher.getAddress().getCity();
		int phNo = teacher.getPhoneNumber();
		String userName = teacher.getUserName();
		String password = teacher.getPassword();

		// Department d=teacher.getDepartment();

		TeacherDAO teacherDao = new TeacherDAO();
		@SuppressWarnings("unused")
		Teacher t = teacherDao.create(firstName, lastName, emailId, gender, streetOne, streetTwo, country, state, city,
				phNo, userName, password, Enums.RoleType.TEACHER, Enums.Status.ACTIVE);

		JSONObject obj = new JSONObject();
		obj.put("successmsg", "Teacher has been added successfully");
		PrintWriter out = response.getWriter();
		out.println(obj);
		return null;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("teacher") Teacher teacher, BindingResult result) {

		return "addTeacher";
	}
}
