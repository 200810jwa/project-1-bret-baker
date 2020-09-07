package com.revpro1.services;

import com.revpro1.models.User;

import java.util.List;

import com.revpro1.dao.UserDAO;

public class UserService {

	private UserDAO userDao = new UserDAO();

	public List<User> getUser(String username) {

		List<User> user = userDao.getByUsername(username);

		if (user == null) {
//			throw exception
			return null;
		}

		return user;
	}

	public List<User> getUserById(int id) {

		List<User> user = userDao.getById(id);

		if (user == null) {
//			throw exception
			return null;
		}

		return user;
	}

}
