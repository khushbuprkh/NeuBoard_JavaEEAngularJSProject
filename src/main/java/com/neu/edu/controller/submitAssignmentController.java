package com.neu.edu.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.neu.edu.dao.AssignmentDAO;
import com.neu.edu.dao.CoursesDAO;
import com.neu.edu.dao.FileUploadDAO;
import com.neu.edu.pojo.Assignment;
import com.neu.edu.pojo.Courses;
import com.neu.edu.pojo.UploadFile;

@Controller
@RequestMapping("/submitAssignment.htm")
public class submitAssignmentController {
	
	FileUploadDAO fileUploadDAO= new FileUploadDAO() {
		
		@Override
		public void save(UploadFile uploadFile) {
			// TODO Auto-generated method stub
			
		}
	};

	@RequestMapping(method = RequestMethod.POST)
	public String handleFileUpload(HttpServletRequest request, HttpServletResponse response,
			@RequestParam CommonsMultipartFile[] uploadQuestion,@ModelAttribute("assignment") Assignment assignment) throws Exception {

		try {
			CoursesDAO cd = new CoursesDAO();
			AssignmentDAO assignmentDao = new AssignmentDAO();
			
			int id= assignment.getAssignmentId();
		    String writeAnswer= assignment.getWriteAnswer();

			if (uploadQuestion != null && uploadQuestion.length > 0) {
				for (CommonsMultipartFile aFile : uploadQuestion) {

					System.out.println("Saving file: " + aFile.getOriginalFilename());

					UploadFile uploadFile = new UploadFile();
					uploadFile.setFileName(aFile.getOriginalFilename());
					uploadFile.setData(aFile.getBytes());
					fileUploadDAO.save(uploadFile);

					Assignment a=assignmentDao.getAssignment(id);
					assignmentDao.updateAssignment(assignment.getAssignmentId(),uploadFile,writeAnswer);
		            
		            JSONObject obj = new JSONObject();
		    		obj.put("successmsg", "Assignment has been added successfully");
		    		PrintWriter out = response.getWriter();
		    		out.println(obj);
		    		return null;
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "uploadAssignment";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("assignment") Assignment assignment, BindingResult result,HttpSession session,
			Model model) {
		session.getAttribute("user");
		return "uploadAssignment";
	}
}

