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
@RequestMapping("/deletes.htm")
public class deletesController {
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String handleSaveMyData(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("department") Department department) throws Exception {

		int depId = department.getDepartmentId();
		DepartmentDAO depart = new DepartmentDAO();
		
		Department dep = depart.getDep(depId);
		depart.delete(depId,dep);

		JSONObject obj = new JSONObject();
		obj.put("successmsg", "Department "+dep.getDepartmentName()+" has been deleted successfully");
		PrintWriter out = response.getWriter();
		out.println(obj);
		return null;
	}

	public static void main(String[] args) {
		
	}

}
