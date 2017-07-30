package com.neu.edu.pojo;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Department_Table")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Department_Id")
	private int departmentId;
	@Column(name = "Department_Name")
	private String departmentName;
	@OneToMany(fetch=FetchType.LAZY,mappedBy = "departmentId",cascade=CascadeType.ALL)
	private Set<Courses> courseList = new HashSet<Courses>();
	
	@Column(name = "Department_Desc")
	private String departmentDesc;

	public Department(String departmentName,String departmentDesc)
	{
		this.departmentName=departmentName;
//		this.levelList=levelList;
		this.departmentDesc=departmentDesc;
		
	}
	public Department()
	{}
	
	public String getDepartmentDesc() {
		return departmentDesc;
	}
	public void setDepartmentDesc(String departmentDesc) {
		this.departmentDesc = departmentDesc;
	}
	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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
	
	@Override
	public String toString() {
		return  departmentName;
	}
	
}
