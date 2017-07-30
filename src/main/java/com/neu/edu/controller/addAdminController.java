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

import com.neu.edu.dao.AdminDAO;
import com.neu.edu.pojo.Admin;
import com.neu.edu.pojo.Enums;

@Controller
@RequestMapping("/addAdmin.htm")
public class addAdminController {
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String handleSaveMyData(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("admins") Admin admins) throws Exception {

		String firstName = admins.getFirstName();
		String lastName = admins.getLastName();
		String emailId = admins.getEmailId();
		Enums.Gender gender = admins.getGender();
		String streetOne = admins.getAddress().getStreetOne();
		String streetTwo = admins.getAddress().getStreetTwo();
		String country = admins.getAddress().getCountry();
		String state = admins.getAddress().getState();
		String city = admins.getAddress().getCity();
		int phNo = admins.getPhoneNumber();
		String userName = admins.getUserName();
		String password = admins.getPassword();

		// Department d=teacher.getDepartment();

		AdminDAO adminDao = new AdminDAO();
		@SuppressWarnings("unused")
		Admin a = adminDao.create(firstName, lastName, emailId, gender, streetOne, streetTwo, country, state, city,
				phNo, userName, password, Enums.RoleType.ADMIN, Enums.Status.ACTIVE);

		JSONObject obj = new JSONObject();
		obj.put("successmsg", "Admin has been added successfully");
		PrintWriter out = response.getWriter();
		out.println(obj);
		return null;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("admins") Admin admins, BindingResult result) {

		return "addAdmin";
	}
}
