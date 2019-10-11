package com.revature.repositories;

import com.revature.beans.Users;

public interface IUsersDAO {

	public Users Login(String username, String password);
}
