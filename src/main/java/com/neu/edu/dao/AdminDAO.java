package com.neu.edu.dao;

import org.hibernate.HibernateException;

import com.neu.edu.pojo.Address;
import com.neu.edu.pojo.Admin;
import com.neu.edu.pojo.Enums;


public class AdminDAO extends DAO{

	public Admin create(String firstName, String lastName, String emailId, Enums.Gender gender, String streetOne,
			String streetTwo, String country, String state, String city, int phNo, String userName, String password,
			Enums.RoleType roletype, Enums.Status acntStatus) throws Exception {
		try {
			begin();
			Admin admins = new Admin();
			admins.setFirstName(firstName);
			admins.setLastName(lastName);
			admins.setEmailId(emailId);
			admins.setGender(gender);
			admins.setPhoneNumber(phNo);
			admins.setUserName(userName);
			admins.setPassword(password);
			admins.setAccntStatus(Enums.Status.ACTIVE);
			admins.setRoleType(Enums.RoleType.ADMIN);

			Address addr = new Address();
			addr.setStreetOne(streetOne);
			addr.setStreetTwo(streetTwo);
			addr.setCountry(country);
			addr.setState(state);
			addr.setCity(city);

			admins.setAddress(addr);
			getSession().save(admins);
			commit();
			return null;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create the category", e);
			throw new Exception("Exception while creating department: " + e.getMessage());
		}
	}

}
