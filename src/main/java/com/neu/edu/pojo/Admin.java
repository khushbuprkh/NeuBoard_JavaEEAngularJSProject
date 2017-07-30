package com.neu.edu.pojo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Admin_Table")
@PrimaryKeyJoinColumn(name="User_Id")
public class Admin extends User{


		
}
