package com.revpro1.models;

public class UserRole {

	private int id;
	private String role;
	
	public UserRole() {
		super();
	}
	
	public UserRole(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
