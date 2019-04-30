package com.quizwebapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizwebapplication.bean.User;
import com.quizwebapplication.exception.UserDefinedException;
import com.quizwebapplication.repositry.UserRepositry;

@Service
public class UserService {

	@Autowired
	private UserRepositry userRepositry;

	public User submitUserForm(User user) {
		if (user != null) {
			User getuser = userRepositry.getUserByUserName(user.getUserName());
			if (getuser != null) {

				if (getuser.getUserName().equals(user.getUserName())
						&& getuser.getPassword().contentEquals(user.getPassword())) {
					return getuser;
				} else {
					throw new UserDefinedException(user.getUserName() + " Password incorect");
				}
			} else {
				throw new UserDefinedException(user.getUserName() + " Not registred");

			}
		}

		return user;

	}

	public void saveNewUser(User user) {
		 userRepositry.save(user);
	}

}
