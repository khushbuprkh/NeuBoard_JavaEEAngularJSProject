package com.neu.edu.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Teacher_Table")
@PrimaryKeyJoinColumn(name="User_Id")
public class Teacher extends User {

	@OneToMany(fetch=FetchType.LAZY,mappedBy = "userId")
	private Set<Courses> courseList = new HashSet<Courses>();
	
	
/*	public Teacher(String firstName, String lastName,String emailId,Enums.Gender gender,String streetOne,String streetTwo,String country,String state,String city,int phNo,String userName,String password)
	{
		super(firstName, lastName,emailId,gender,streetOne,streetTwo,country,state,city,phNo,userName,password);
		
	}*/
	
	public Teacher()
	{
		super();
		
	}

	public Set<Courses> getCourseList() {
		return courseList;
	}

	public void setCourseList(Set<Courses> courseList) {
		this.courseList = courseList;
	}
    public void addCourses(Courses courses) {
        getCourseList().add(courses);
    }
}
