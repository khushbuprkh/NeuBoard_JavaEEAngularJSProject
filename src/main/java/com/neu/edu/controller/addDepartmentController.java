package com.neu.edu.controller;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.neu.edu.dao.DepartmentDAO;
import com.neu.edu.pojo.Department;

@Controller
public class addDepartmentController {
	/*
	 * @RequestMapping(value="/addDepartment",method = RequestMethod.POST)
	 * protected void doSubmitAction(@ModelAttribute("department") Department
	 * department) throws Exception { try { DepartmentDAO departmentDAO = new
	 * DepartmentDAO(); departmentDAO.create(department.getDepartmentName(),
	 * department.getLevelList(), department.getDepartmentDesc());
	 * 
	 * } catch (Exception e) { System.out.println("Exception: " +
	 * e.getMessage()); } }
	 */

	@RequestMapping(value = "/addDepartment.htm", method = RequestMethod.POST)
	@ResponseBody
	public String handleSaveMyData(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("department") Department department) throws Exception {

		String name = department.getDepartmentName();
		String desc = department.getDepartmentDesc();
		DepartmentDAO depart = new DepartmentDAO();
		@SuppressWarnings("unused")
		Department dep = depart.create(name, desc);

		JSONObject obj = new JSONObject();
		obj.put("successmsg", "Department has been added successfully");
		PrintWriter out = response.getWriter();
		out.println(obj);
		return null;
	}

	@RequestMapping(value = "/addDepartment.htm", method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("department") Department department) {

		return "addDepartment";
	}
}
