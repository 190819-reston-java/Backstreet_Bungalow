package com.revature.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Users;
import com.revature.repositories.UsersDAO;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		UsersDAO usersDAO = (UsersDAO) ac.getBean("usersDAO");
		
		Users example = usersDAO.getOne(1);
		
		System.out.println(example);
	}

}
