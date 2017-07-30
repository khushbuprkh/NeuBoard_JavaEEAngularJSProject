package com.neu.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neu.edu.pojo.Assignment;

@Controller
@RequestMapping("/assignmentList.htm")
public class assignmentListController {
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("assignment") Assignment  assignment) throws Exception {
	return "assignmentList";
	}
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("assignment") Assignment assignment, BindingResult result) {

		return "assignmentList";
	}


}
