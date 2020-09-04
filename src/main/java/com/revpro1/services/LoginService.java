package com.revpro1.services;

import com.revpro1.models.User;
import com.revpro1.models.templates.LoginTemplate;
import com.revpro1.dao.UserDAO;

public class LoginService {
	
	private UserDAO userDao = new UserDAO();
	
	public User login(LoginTemplate loginTemplate) {
		
		User user = userDao.getByUsername(loginTemplate.getUsername());
		
		if (user == null) {
//			throw exception
			return null;
		}
		
		if (user.getPassword().equals(loginTemplate.getPassword())) {
			return user;
		}
		
		return null;
	}

}
