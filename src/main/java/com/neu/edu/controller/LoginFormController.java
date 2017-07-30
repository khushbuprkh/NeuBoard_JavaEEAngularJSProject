package com.neu.edu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.dao.UserDAO;
import com.neu.edu.pojo.Enums;
import com.neu.edu.pojo.User;

@Controller
public class LoginFormController {
	String mv;

	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result, HttpSession session,
			Model model) throws Exception {

		UserDAO userDao = new UserDAO();
		User ua = userDao.get(user.getUserName(), user.getPassword());
		try {

			System.out.print("test");

			if (ua == null) {
				model.addAttribute("LoginErrors", "Either the User Name or the Password Incorrect!!Try again");
				mv = null;

			} else {
				if (ua.getRoleType().equals(Enums.RoleType.ADMIN)) {

					mv = "adminAccess";
				} else if (ua.getRoleType().equals(Enums.RoleType.TEACHER)) {

					mv = "teacherAccess";
				} else if (ua.getRoleType().equals(Enums.RoleType.STUDENT)) {

					mv = "studentAccess";
				}
			}
			// DAO.close();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		session.setAttribute("user", ua);
		return mv;
	}
	
}
