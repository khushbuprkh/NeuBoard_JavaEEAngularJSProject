package com.neu.edu.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Transcript_Table")
public class Transcript {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Transcript_ID")
	private int transcriptId;
	@Column(name = "Marks")
	private int marks;
	@Column(name = "Grade")
	private String grade;
	@ManyToMany(mappedBy="transcriptList")
	private Set<Student> studentList = new HashSet<Student>();
	@ManyToMany(mappedBy="transcriptList")
	private Set<Courses> transcriptList = new HashSet<Courses>();
	private String remarks;

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

//	public Student getStudent() {
//		return student;
//	}
//
//	public void setStudent(Student student) {
//		this.student = student;
//	}
//
//	public Courses getCourses() {
//		return courses;
//	}
//
//	public void setCourses(Courses courses) {
//		this.courses = courses;
//	}

	public int getMarks() {
		return marks;
	}

	public int getTranscriptId() {
		return transcriptId;
	}

	public void setTranscriptId(int transcriptId) {
		this.transcriptId = transcriptId;
	}

	public Set<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(Set<Student> studentList) {
		this.studentList = studentList;
	}

	public Set<Courses> getTranscriptList() {
		return transcriptList;
	}

	public void setTranscriptList(Set<Courses> transcriptList) {
		this.transcriptList = transcriptList;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}
