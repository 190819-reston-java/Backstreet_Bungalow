package com.revature.service;

import com.revature.beans.Users;

public interface IUserDAO {

	public Users Login(String username, String password);
}
