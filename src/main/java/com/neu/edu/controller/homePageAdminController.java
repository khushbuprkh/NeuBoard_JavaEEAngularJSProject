package com.neu.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.pojo.User;

@Controller
@RequestMapping("/homePageAdmin.htm")
public class homePageAdminController {
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("user") User  user) throws Exception {
	return "homePageAdmin";
	}
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result) {

		return "homePageAdmin";
	}
}
