package com.revature.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Users;
import com.revature.repositories.UsersDAO;

@Service
public class Services {

	@Autowired
	private UsersDAO usersDAO;
	
	public Services() {
		super();
	}
	
	public boolean login(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (usersDAO.login(username, password, request)) {
			return true;
		}
		else
			return false;
	}
	
	public List<Users> getAllUsers() {
		return usersDAO.getAllUsers();
	}
	
	public Users getOneUser(long id) {
		return usersDAO.getOneUser(id);
	}

	public boolean updateUser(HttpServletRequest request) {
		Users u = null;
		u.setId(Long.valueOf(request.getParameter("id")));
		u.setFirstName(request.getParameter("firstname"));
		u.setLastName(request.getParameter("lastname"));
		u.setUsername(request.getParameter("username"));
		u.setEmail(request.getParameter("email"));
		u.setPassword(request.getParameter("password"));
		u.setShowInfo(Boolean.valueOf(request.getParameter("showinfo")));
		return usersDAO.updateUser(u);
		
	}
	
	public boolean createNewUser(HttpServletRequest request) {
		Users u = null;
		u.setId(Long.valueOf(request.getParameter("id")));
		u.setFirstName(request.getParameter("firstname"));
		u.setLastName(request.getParameter("lastname"));
		u.setUsername(request.getParameter("username"));
		u.setEmail(request.getParameter("email"));
		u.setPassword(request.getParameter("password"));
		u.setShowInfo(Boolean.valueOf(request.getParameter("showinfo")));
		return usersDAO.addNewUser(u);
		
	}
	
}
