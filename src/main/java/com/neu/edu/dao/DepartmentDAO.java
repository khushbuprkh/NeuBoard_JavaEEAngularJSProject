package com.neu.edu.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import com.neu.edu.pojo.Department;

public class DepartmentDAO extends DAO {

	public DepartmentDAO() {
	}

	public Department get(String departmentName) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from Department where departmentName = :departmentName");
			q.setString("departmentName", departmentName);

			Department department = (Department) q.uniqueResult();
			commit();
			return department;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get department " + departmentName, e);
		}
	}
	
	public Department getDep(int departmentId) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from Department where departmentId = :departmentId");
			q.setInteger("departmentId", departmentId);
			Department department = (Department) q.uniqueResult();
			commit();
			return department;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get department " + departmentId, e);
		}
	}

	@SuppressWarnings("rawtypes")
	public List list() throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from Department");
			List list = q.list();
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not list the categories", e);
		}
	}

	public Department create(String departmentName, String departmentDesc) throws Exception {
		try {
			begin();
			Department department = new Department(departmentName, departmentDesc);
			getSession().save(department);
			commit();
			return null;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create the category", e);
			throw new Exception("Exception while creating department: " + e.getMessage());
		}
	}

	public void save(Department department) throws Exception {
		try {
			begin();
			getSession().update(department);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not save the department", e);
		}
	}

	public void delete(int departmentId,Department department) throws Exception {
		try {
			begin();
			getSession().delete(department); 
			Query q1=getSession().createQuery("delete from Courses where departmentId = :departmentId");
			Query q2=getSession().createQuery("delete from Department where departmentId = :departmentId");
			q1.setInteger("departmentId", departmentId);
			q1.executeUpdate();
			q2.setInteger("departmentId", departmentId);
			q2.executeUpdate();
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not delete the department", e);
		}
	}
}
