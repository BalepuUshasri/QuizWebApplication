package com.quizwebapplication.repositry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.quizwebapplication.bean.User;

@Repository
public class UserRepositry {

	@Autowired
	HibernateTemplate dbConnection;

	@Transactional
	public User getUserByUserName(String userName) {
		return dbConnection.get(User.class, userName);
	}

	@Transactional
	public void save(User user) {
		  dbConnection.save(user);
	}

}
