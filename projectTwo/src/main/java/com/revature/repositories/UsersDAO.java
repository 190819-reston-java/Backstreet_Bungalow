package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Users;

@Repository
public class UsersDAO implements IUsersDAO {
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	@Transactional
	public Users getOneUser(long username) {
		Session s = sf.getCurrentSession();
		Users a = (Users) s.get(Users.class, username);
		
		return a;
		
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Users> getAllUsers() {
		Session s = sf.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<Users> users = s.createCriteria(Users.class).list();
		
		return users;
	}
	
	@Override
	public Users Login(String username, String password) {
		
		return null;
	}
	
}
