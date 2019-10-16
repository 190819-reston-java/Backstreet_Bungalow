package com.revature.repositories;

import java.util.List;

import com.revature.beans.Users;

public interface IUsersDAO {

	public Users Login(String username, String password);

	public Users getOneUser(long id);

	public List<Users> getAllUsers();
}
