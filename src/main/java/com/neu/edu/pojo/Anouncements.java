package com.neu.edu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Anouncements_Table")
public class Anouncements {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Anouncement_Id")
	private int anouncementId;
	@Column(name="Title")
	private String title;
	@Column(name="Content")
	private String Content;
	
//	private Courses course;
//	private Teacher teacher;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

//	public Courses getCourse() {
//		return course;
//	}
//
//	public void setCourse(Courses course) {
//		this.course = course;
//	}
//
//	public Teacher getTeacher() {
//		return teacher;
//	}
//
//	public void setTeacher(Teacher teacher) {
//		this.teacher = teacher;
//	}

}
