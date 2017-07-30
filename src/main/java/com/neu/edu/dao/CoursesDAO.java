package com.neu.edu.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.edu.pojo.Courses;

public class CoursesDAO extends DAO{
	
	public Courses get(String name) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from Courses where name = :name");
			q.setString("name", name);

			Courses courses = (Courses) q.uniqueResult();
			commit();
			return courses;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get department " + name, e);
		}
	}
	
	public Courses getCourse(int courseId) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from Courses where courseId = :courseId");
			q.setInteger("courseId", courseId);

			Courses courses = (Courses) q.uniqueResult();
			commit();
			return courses;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get Course " + courseId, e);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public List list() throws Exception {
        try {
            begin();
            Query q = getSession().createQuery("from Courses");
			List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not list the categories", e);
        }
    }

	public List list(int userid) throws Exception {
        try {
            begin();
            Query q = getSession().createQuery("from Courses where userId= :userid");
            q.setInteger("userid", userid);
			List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not list the categories", e);
        }
    }
	
	public Courses create(String crn,String courseName,int userId, int departmentId)
			throws Exception {
		try {
			begin();
			Courses courses = new Courses();
			courses.setCrn(crn);
			courses.setName(courseName);
			courses.setUserId(userId);
			courses.setDepartmentId(departmentId);
						
			getSession().save(courses);
			commit();
			return null;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create the category", e);
			throw new Exception("Exception while creating Courses: " + e.getMessage());
		}
	}

	public void save(Courses courses) throws Exception {
		try {
			begin();
			getSession().update(courses);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not save the Courses", e);
		}
	}

	public void delete(Courses courses) throws Exception {
		try {
			begin();
			getSession().delete(courses);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not delete the Courses", e);
		}
	}

}
