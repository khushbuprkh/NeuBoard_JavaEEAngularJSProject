package com.neu.edu.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import com.neu.edu.pojo.User;

public class UserDAO extends DAO {

	public UserDAO() {
	}

	public User get(String username, String password) throws Exception {
		try {
			begin();
			Query t = getSession().createQuery("from User where userName = :username and password= :password");
			t.setString("username", username);
			t.setString("password", password);
			User ua = (User) t.uniqueResult();
			commit();

			return ua;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get user " + username, e);
		}
	}
	
	public User list(int userid) throws Exception {
        try {
            begin();
            Query q = getSession().createQuery("from User where userId= :userid");
            q.setInteger("userid", userid);
			User u = (User) q.uniqueResult();
            commit();
            return u;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not list the user", e);
        }
    }
}
