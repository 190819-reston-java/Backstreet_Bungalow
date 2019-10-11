package com.revature.service;

import com.revature.models.Users;

public interface IUserDAO {

	public Users Login(String username, String password);
	
	public void Logout();
	
	public void CreateUser(String username, String password, String email,
			String role, boolean showInfo);
}
