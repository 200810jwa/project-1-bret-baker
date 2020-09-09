package com.revpro1.services;

import com.revpro1.models.User;
import com.revpro1.models.templates.LoginTemplate;

import java.util.List;

import com.revpro1.dao.UserDAO;
import com.revpro1.hash.PasswordAuthentication;
import com.revpro1.logger.Log4J;

public class LoginService {
	
//	public static Log4J log = new Log4J();
	
	public final PasswordAuthentication auth = new PasswordAuthentication();
	
	private UserDAO userDao = new UserDAO();
	
	public User login(LoginTemplate loginTemplate) {
		
		String username = loginTemplate.getUsername();
		
		List<User> user = userDao.getByUsername(username);
		
		if (user == null) {
//			throw exception
//			log.loginF();
			return null;
		}
		
		String password = user.get(0).getPassword();
		String password1 = loginTemplate.getPassword();
		
		if (password.equals(password1)) {
			String hashedPass = auth.hash(password.toCharArray());
			userDao.updatePassword(hashedPass, username);
//			log.loginS();
			return user.get(0);
		} else {
			if (auth.authenticate(password1.toCharArray(), password)) {
//				log.loginS();
				return user.get(0);
			} else {
				return null;
			}
		}
		
		// return null;
	}

}
