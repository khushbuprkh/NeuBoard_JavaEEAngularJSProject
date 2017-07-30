package com.neu.edu.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neu.edu.pojo.UploadFile;

@Repository
public class FileUploadDAOImpl implements FileUploadDAO {
	    
	SessionFactory sf=	new Configuration().configure().buildSessionFactory();
	Session session= sf.openSession();
//	session.beginTransaction();
//session.save(u);
//	session.save(ua);
//	session.save(course);
//	session.save(assignment);
//	session.getTransaction().commit();
	     
	    public FileUploadDAOImpl() {
	    }
	 
	    public FileUploadDAOImpl(SessionFactory sessionFactory) {
	        this.sf = sessionFactory;
	    }
	 
	    @Override
	    @Transactional
	    public void save(UploadFile uploadFile) {
	    	Session session= sf.openSession();
	    	session.beginTransaction();
	    	sf.getCurrentSession().save(uploadFile);
	       }
}
