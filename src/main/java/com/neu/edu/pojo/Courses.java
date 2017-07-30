package com.neu.edu.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Courses_Table")
public class Courses {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Course_Id")
	private int courseId;
	@Column(name="CRN")
	private String crn;
	@Column(name="Course_Name")
	private String name;
/*	@Column(name="Course_StartDate")
	private Date startDate;
	@Column(name="Course_EndDate")
	private Date endDate;*/
	@OneToMany(mappedBy="courses",cascade=CascadeType.ALL)
	private Set<Assignment> assignment = new HashSet<Assignment>();
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Student> studentList = new HashSet<Student>();
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(joinColumns=@JoinColumn(name="Course_Id"),inverseJoinColumns=@JoinColumn(name="Transcript_ID"))
	private Set<Transcript> transcriptList = new HashSet<Transcript>();
	@OneToMany(mappedBy="course",cascade=CascadeType.ALL)
	private Set<Contents> contentList = new HashSet<Contents>();
/*	@ManyToOne
	@JoinColumn(name="Teacher_Id")
	private Teacher teacher;
	@ManyToOne
	@JoinColumn(name="Department_Id")
	private Department department;*/
	
	@JoinColumn(name="userId") //check all columns and if pkjoincolum then only primary key columns in whole db
	    private int userId;
	  
	@JoinColumn(name="departmentId") //check all columns and if pkjoincolum then only primary key columns in whole db
    private int departmentId;
	
    @Transient
    private String Department_name;
    
    @Transient
    private String Teacher_name;
	
	public Set<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(Set<Student> studentList) {
		this.studentList = studentList;
	}

	public String getCrn() {
		return crn;
	}

	public void setCrn(String crn) {
		this.crn = crn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

/*	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}*/

//	public Set<Assignment> getAssignment() {
//		return assignment;
//	}
//
//	public void setAssignment(Set<Assignment> assignment) {
//		this.assignment = assignment;
//	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Set<Transcript> getTranscriptList() {
		return transcriptList;
	}

	public void setTranscriptList(Set<Transcript> transcriptList) {
		this.transcriptList = transcriptList;
	}

	public Set<Contents> getContentList() {
		return contentList;
	}

	public void setContentList(Set<Contents> contentList) {
		this.contentList = contentList;
	}

/*	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}*/



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartment_name() {
		return Department_name;
	}

	public void setDepartment_name(String department_name) {
		Department_name = department_name;
	}

	public String getTeacher_name() {
		return Teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		Teacher_name = teacher_name;
	}
	@Override
	public String toString() {
		return name;
	}
}
