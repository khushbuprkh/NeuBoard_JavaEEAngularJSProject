 package com.neu.edu.pojo;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="UserDetails_Table")
@Inheritance(strategy=InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue
	@PrimaryKeyJoinColumn(name="User_Id")
	@Column(name="User_Id", insertable = false, updatable = false) 
	private int userId;
	@Column(name="First_Name", insertable = false, updatable = false)
	private String firstName;
	@Column(name="First_Name")
	private String lastName;
	@Column(name="DOB")
	@Temporal(TemporalType.DATE)
	private Date dob;
	@Column(name="Email_Id")
	private String emailId;
	@Enumerated(EnumType.ORDINAL)
	@AttributeOverride(name="value",column=@Column(name="Gender"))
	private Enums.Gender gender;
	@Embedded
	@AttributeOverrides({@AttributeOverride(name="street1",column=@Column(name="Street1")),
		@AttributeOverride(name="street2",column=@Column(name="Street1")),
		@AttributeOverride(name="city",column=@Column(name="City")),
		@AttributeOverride(name="state",column=@Column(name="State")),	
		@AttributeOverride(name="country",column=@Column(name="Country"))
	})
	private Address address;
	@Column(name="Ph_No")
	private int phoneNumber;
//	@OneToOne(fetch=FetchType.LAZY, mappedBy="user", cascade=CascadeType.ALL)
//	private UserAccount userAccount;
//	@OneToOne
//	@JoinColumn(name="Department_ID")
//	private Department department;
	@Transient
	private MultipartFile image;
	@Column(name = "User_Name")
	private String userName;
	@Column(name = "Password")
	private String password;
	@Column(name = "Account_Status")
	@Enumerated(EnumType.ORDINAL)
	private Enums.Status accntStatus;
	@Enumerated(EnumType.ORDINAL)
	@AttributeOverride(name = "value", column = @Column(name = "RoleType"))
	private Enums.RoleType roleType;

	
/*	public User(String firstName, String lastName,String emailId,Enums.Gender gender,String streetOne,String streetTwo,String country,String state,String city,int phNo,String userName,String password)
	{
		
		this.firstName=firstName; 
		this.lastName=lastName;
		this.emailId=emailId;
		this.gender=gender;
		new Address(streetOne,streetTwo,country,state,city);
		this.phoneNumber=phNo;
//		this.department=d;
	}*/
	
	public User()
	{}
	public User(int userId)
	{
		this.userId=userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public Enums.Gender getGender() {
		return gender;
	}

	public void setGender(Enums.Gender gender) {
		this.gender = gender;
	}

//	public UserAccount getUserAccount() {
//		return userAccount;
//	}
//
//	public void setUserAccount(UserAccount userAccount) {
//		this.userAccount = userAccount;
//	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Enums.Status getAccntStatus() {
		return accntStatus;
	}

	public void setAccntStatus(Enums.Status accntStatus) {
		this.accntStatus = accntStatus;
	}

	public Enums.RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(Enums.RoleType roleType) {
		this.roleType = roleType;
	}

	@Override
	public String toString() {
		return userName;
	}


}
