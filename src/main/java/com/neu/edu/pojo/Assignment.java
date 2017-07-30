package com.neu.edu.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "Assignment_Table")
public class Assignment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Assignment_Id")
	private int assignmentId;
	// @Transient
	// private MultipartFile Question;
	@Embedded
	private UploadFile question;
	@Column(name = "Question_Text")
	private String writeQuestion;
	@Column(name = "Reference")
	private String reference;
	// @Transient
	// private MultipartFile Answer;
/*	@OneToOne(fetch = FetchType.LAZY, mappedBy = "answer", cascade = CascadeType.ALL)
	private UploadFile answerFile;*/
/*	@Embedded
	private UploadFile answerFile;*/
	@Column(name = "Answer_Text")
	private String writeAnswer;
	@Column(name = "Possible_Points")
	private int possiblepoints;
	@Column(name = "Assigned_Date")
	private Date assignedDttm;
	@Column(name = "Due_Date")
	private Date dueDttm;
	@Column(name = "Grade")
	private int grade;
	@ManyToOne
	@JoinColumn(name = "Course_ID")
	private Courses courses;

	@Transient
	private String CourseName;

	public Courses getCourses() {
		return courses;
	}

	public void setCourses(Courses courses) {
		this.courses = courses;
	}

	public int getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(int assignmentId) {
		this.assignmentId = assignmentId;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Date getAssignedDttm() {
		return assignedDttm;
	}

	public void setAssignedDttm(Date assignedDttm) {
		this.assignedDttm = assignedDttm;
	}

	/*
	 * public MultipartFile getQuestion() { return Question; }
	 * 
	 * public void setQuestion(MultipartFile question) { Question = question; }
	 */

	public String getWriteQuestion() {
		return writeQuestion;
	}

	public void setWriteQuestion(String writeQuestion) {
		this.writeQuestion = writeQuestion;
	}

	public int getPossiblepoints() {
		return possiblepoints;
	}

	public void setPossiblepoints(int possiblepoints) {
		this.possiblepoints = possiblepoints;
	}

	public Date getDueDttm() {
		return dueDttm;
	}

	public void setDueDttm(Date dueDttm) {
		this.dueDttm = dueDttm;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	/*
	 * public MultipartFile getAnswer() { return Answer; }
	 * 
	 * public void setAnswer(MultipartFile answer) { Answer = answer; }
	 */
	public String getWriteAnswer() {
		return writeAnswer;
	}

	public void setWriteAnswer(String writeAnswer) {
		this.writeAnswer = writeAnswer;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public UploadFile getQuestion() {
		return question;
	}

	public void setQuestion(UploadFile question) {
		this.question = question;
	}

/*	public UploadFile getAnswerFile() {
		return answerFile;
	}

	public void setAnswerFile(UploadFile answerFile) {
		this.answerFile = answerFile;
	}*/

/*	public UploadFile getAnswerFile() {
		return answerFile;
	}

	public void setAnswerFile(UploadFile answerFile) {
		this.answerFile = answerFile;
	}*/

}
