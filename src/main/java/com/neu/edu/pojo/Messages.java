package com.neu.edu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Messages_Table")
public class Messages {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Message_Id")
	private int messageTd;
//	private User fromUser;
//	private User ToUser;

	public int getMessageTd() {
		return messageTd;
	}

	public void setMessageTd(int messageTd) {
		this.messageTd = messageTd;
	}

//	public User getFromUser() {
//		return fromUser;
//	}
//
//	public void setFromUser(User fromUser) {
//		this.fromUser = fromUser;
//	}
//
//	public User getToUser() {
//		return ToUser;
//	}
//
//	public void setToUser(User toUser) {
//		ToUser = toUser;
//	}
	
}
