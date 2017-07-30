package com.neu.edu.pojo;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Student_Table")
@PrimaryKeyJoinColumn(name="User_Id")
public class Student extends User {

	@Column(name="Major")
	private String major;	
	@Column(name="Department")
	private String depatment;
	@ManyToMany
	@JoinTable(joinColumns=@JoinColumn(name="User_Id"),inverseJoinColumns=@JoinColumn(name="Course_Id"))
	private Set<Courses> courseList = new HashSet<Courses>();
	@ManyToMany
	@JoinTable(joinColumns=@JoinColumn(name="User_Id"),inverseJoinColumns=@JoinColumn(name="Transcript_ID"))
	private Set<Transcript> transcriptList = new HashSet<Transcript>();
	@Column(name="Semester")
	private String semester;
	@Transient
	private String[] courseLists;
	
	@Transient
	private String name;
	
	public Student(int userId, Set<Courses> courses) {
		super(userId);
		this.courseList = courses;
	}
	
	public Student()
	{
		//super(RoleType.STUDENT);
	}
	

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getDepatment() {
		return depatment;
	}

	public void setDepatment(String depatment) {
		this.depatment = depatment;
	}

//	public Set<Courses> getCourseList() {
//		return courseList;
//	}
//
//	public void setCourseList(Set<Courses> courseList) {
//		this.courseList = courseList;
//	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}


	public Set<Courses> getCourseList() {
		return courseList;
	}


	public void setCourseList(Set<Courses> courseList) {
		this.courseList = courseList;
	}


	public Set<Transcript> getTranscriptList() {
		return transcriptList;
	}


	public void setTranscriptList(Set<Transcript> transcriptList) {
		this.transcriptList = transcriptList;
	}
	
    public void addCourses(Courses courses) {
        getCourseList().add(courses);
    }
    
    public void addTranscripts(Transcript transcript) {
        getTranscriptList().add(transcript);
    }

	public String[] getCourseLists() {
		return courseLists;
	}

	public void setCourseLists(String[] courseLists) {
		this.courseLists = courseLists;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
