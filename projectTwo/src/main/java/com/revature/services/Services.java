package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.revature.beans.Users;
import com.revature.repositories.IUsersDAO;
import com.revature.repositories.UsersDAO;

@Service
public class Services {

	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

	IUsersDAO usersDAO = (UsersDAO) ac.getBean("usersDAO");
	//Above code might be trash/misplaced
	
	
	List<Users> users = usersDAO.getAllUsers();
	
	public Services() {
		super();
	}
	
	public List<Users> getAllUsers() {
		return usersDAO.getAllUsers();
	}
	
}
