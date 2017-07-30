package com.neu.edu.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import com.neu.edu.pojo.Address;
import com.neu.edu.pojo.Enums;
import com.neu.edu.pojo.Student;
import com.neu.edu.pojo.Teacher;


public class StudentDAO extends DAO{

	public Student create(String firstName, String lastName, String emailId, Enums.Gender gender, String streetOne,
			String streetTwo, String country, String state, String city, int phNo, String userName, String password,
			Enums.RoleType roletype, Enums.Status acntStatus) throws Exception {
		try {
			begin();
			Student student = new Student();
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setEmailId(emailId);
			student.setGender(gender);
			student.setPhoneNumber(phNo);
			student.setUserName(userName);
			student.setPassword(password);
			student.setAccntStatus(Enums.Status.ACTIVE);
			student.setRoleType(Enums.RoleType.STUDENT);

			Address addr = new Address();
			addr.setStreetOne(streetOne);
			addr.setStreetTwo(streetTwo);
			addr.setCountry(country);
			addr.setState(state);
			addr.setCity(city);

			student.setAddress(addr);
			getSession().save(student);
			commit();
			return null;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create the category", e);
			throw new Exception("Exception while creating department: " + e.getMessage());
		}
	}
	
	@SuppressWarnings("rawtypes")
	public List list() throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from User where roleType=2");
			List list = q.list();
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not list the categories", e);
		}
	}
	
	public Student get(String username) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from Student where userName = :username");
			q.setString("username", username);
			Student student = (Student) q.uniqueResult();
			commit();
			return student;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get user " + username, e);
		}
	}
	
	public void save(Student student) throws Exception {
		try {
			begin();
			getSession().update(student);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not save the category", e);
		}
	}
}
