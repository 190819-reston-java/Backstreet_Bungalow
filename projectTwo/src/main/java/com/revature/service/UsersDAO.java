package com.revature.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Users;


public class UsersDAO {
	
	@Autowired
	private SessionFactory sf;
	
	@Transactional
	public Users getOne(long id) {
		Session s = sf.getCurrentSession();
		Users a = (Users) s.get(Users.class, id);
		
		return a;
		
	}
	
}
