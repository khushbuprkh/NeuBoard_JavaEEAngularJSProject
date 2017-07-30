package com.neu.edu.dao;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.edu.pojo.Assignment;
import com.neu.edu.pojo.Courses;
import com.neu.edu.pojo.UploadFile;

public class AssignmentDAO extends DAO {
	
	public void save(Assignment assignment) throws Exception {
		try {
			begin();
			getSession().update(assignment);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not save the Assignment", e);
		}
	}
	public Assignment create(String writeQuestion, int possiblePoionts, Courses course) throws Exception {
		try {
			begin();
			Assignment assignment = new Assignment();
			assignment.setWriteQuestion(writeQuestion);
			assignment.setCourses(course);
			assignment.setPossiblepoints(possiblePoionts);
			getSession().save(assignment);
			commit();
			return null;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create the category", e);
			throw new Exception("Exception while creating Assignment: " + e.getMessage());
		}
	}

	public List getList( int id) throws Exception {
			 try {
		            begin();
		            Query q = getSession().createQuery("from Assignment where courses= :id");
		            q.setInteger("id", id);
					List a = q.list();
		            commit();
		            return a;
		        } catch (HibernateException e) {
		            rollback();
		            throw new Exception("Could not list the Assignment", e);
		        }
			}
	
	public Assignment getAssignment( int assignmentId) throws Exception {
		 try {
	            begin();
	            Query q = getSession().createQuery("from Assignment where assignmentId= :assignmentId");
	            q.setInteger("assignmentId", assignmentId);
				Assignment a = (Assignment) q.uniqueResult();
	            commit();
	            return a;
	        } catch (HibernateException e) {
	            rollback();
	            throw new Exception("Could not list the Assignment", e);
	        }
		}
	
	public void updateAssignment(int assignmentId,UploadFile uploadedQuestion,String writeAnswer) throws Exception {
		 try {
	            begin();
	            Query q = getSession().createQuery("update Assignment set question=:uploadedQuestion, writeAnswer=:writeAnswer where assignmentId= :assignmentId");
	            q.setInteger("assignmentId", assignmentId);
				q.setEntity("uploadedQuestion", uploadedQuestion);
				q.setString("writeAnswer", writeAnswer);
				q.executeUpdate();
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            throw new Exception("Could not list the Assignment", e);
	        }
		}
	}