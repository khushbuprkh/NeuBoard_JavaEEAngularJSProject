package com.neu.edu.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
@Embeddable
public class UploadFile {
/*	@Id
	@GeneratedValue
	@Column(name = "FILE_ID")
	private long id;*/
	@Column(name = "FILE_NAME")
	private String fileName;
	@Column(name = "FILE_DATA")
	private byte[] data;
	@OneToOne(fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn(name="question_id")
	private Assignment question;
/*	@OneToOne(fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn(name="answer_id")
	private Assignment question;*/

/*	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}*/

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Assignment getQuestion() {
		return question;
	}

	public void setQuestion(Assignment question) {
		this.question = question;
	}

}
