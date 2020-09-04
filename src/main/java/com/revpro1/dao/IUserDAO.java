package com.revpro1.dao;

import com.revpro1.models.User;

public interface IUserDAO {
	
	public User getByUsername(String username);

}
