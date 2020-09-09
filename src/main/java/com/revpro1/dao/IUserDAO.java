package com.revpro1.dao;

import java.util.List;

import com.revpro1.models.User;

public interface IUserDAO {
	
	public List<User> getByUsername(String username);
	public List<User> getById(int id);
	public void updatePassword(String password, String username);

}
