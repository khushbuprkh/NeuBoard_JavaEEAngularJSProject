package com.neu.edu;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neu.edu.pojo.User;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
				
		return "login";
	}
	
	@RequestMapping(value="/login.htm",method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user){
		
//		Admin u=new Admin();
//		u.setFirstName("Khushbu");
//		u.setLastName("Parekh");
//		u.setDob(new Date());
//		u.setEmailId("khushbuprkh@gmail.com");
//		u.setGender(Enums.Gender.FEMALE);
//		u.setPhoneNumber(1234);
//		u.setUserName("Khushbuprkh");
//		u.setPassword( "12345");
//		u.setRoleType(Enums.RoleType.ADMIN);
//		u.setAccntStatus(Enums.Status.ACTIVE);
		
//		UserAccount ua=new UserAccount("Khushbuprkh", "12345", Enums.RoleType.ADMIN,Enums.Status.ACTIVE );
//		u.setUserName("Khushbuprkh");
//		u.setPassword("12345");
//		u.setRoleType(Enums.RoleType.ADMIN);
//		u.setAccntStatus(Enums.Status.ACTIVE);
//	
//	u.setUserAccount(ua);
//	ua.setUser(u);
//		Address add= new Address();
//		add.setStreetOne("s1");
//		add.setStreetTwo("s2");
//		add.setCity("city");
//		add.setState("state");
//		add.setCountry("country");
//		
//		u.setAddress(add);
//		Courses course= new Courses();
//		course.setCrn("CRN1");
//		course.setName("Java");
////		course.setStartDate("11-22-11");
////		course.setEndDate("11-22-11");
//		
//		Assignment assignment=new Assignment();
//		assignment.setGrade(100);
//		course.getAssignment().add(assignment);
//		assignment.setCourses(course);
		
//		@SuppressWarnings("deprecation")
//		SessionFactory sf=	new Configuration().configure().buildSessionFactory();
//		Session session= sf.openSession();
//		session.beginTransaction();
//	session.save(u);
//		session.save(ua);
//		session.save(course);
//		session.save(assignment);
//		session.getTransaction().commit();
		return "login";
	}
}
