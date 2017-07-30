package com.neu.edu.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.edu.pojo.Address;
import com.neu.edu.pojo.Enums;
import com.neu.edu.pojo.Teacher;

public class TeacherDAO extends DAO {

	public Teacher create(String firstName, String lastName, String emailId, Enums.Gender gender, String streetOne,
			String streetTwo, String country, String state, String city, int phNo, String userName, String password,
			Enums.RoleType roletype, Enums.Status acntStatus) throws Exception {
		try {
			begin();
			Teacher teacher = new Teacher();
			teacher.setFirstName(firstName);
			teacher.setLastName(lastName);
			teacher.setEmailId(emailId);
			teacher.setGender(gender);
			teacher.setPhoneNumber(phNo);
			teacher.setUserName(userName);
			teacher.setPassword(password);
			teacher.setAccntStatus(Enums.Status.ACTIVE);
			teacher.setRoleType(Enums.RoleType.TEACHER);

			Address addr = new Address();
			addr.setStreetOne(streetOne);
			addr.setStreetTwo(streetTwo);
			addr.setCountry(country);
			addr.setState(state);
			addr.setCity(city);

			teacher.setAddress(addr);
			getSession().save(teacher);
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
			Query q = getSession().createQuery("from User where roleType=1");
			List list = q.list();
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not list the categories", e);
		}
	}

	public TeacherDAO() {

	}

	public Teacher get(String username) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from Teacher where userName = :username");
			q.setString("username", username);
			Teacher teacher = (Teacher) q.uniqueResult();
			commit();
			return teacher;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get user " + username, e);
		}
	}

	public void save(Teacher teacher) throws Exception {
		try {
			begin();
			getSession().update(teacher);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not save the category", e);
		}
	}

}
