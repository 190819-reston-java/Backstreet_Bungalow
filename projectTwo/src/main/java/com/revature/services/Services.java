package com.revature.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Users;
import com.revature.repositories.UsersDAO;

@Service
public class Services {

	@Autowired
	private UsersDAO usersDAO;
	
	@Autowired
	//private 
	
	public Services() {
		super();
	}
	
	public Users login(HttpServletRequest request) throws ServletException, IOException {
		Users u = null;
		ObjectMapper om = new ObjectMapper();
		u = om.readValue(request.getReader(), Users.class);
		String password = u.getPassword();
		String username = u.getUsername();
		u = usersDAO.login(username, password, request);
		return u;
	}
	
	public List<Users> getAllUsers() {
		return usersDAO.getAllUsers();
	}
	
	public Users getOneUser(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException {
		Users u = null;
		ObjectMapper om = new ObjectMapper();
		u = om.readValue(request.getReader(), Users.class);
		String username = u.getUsername();
		u = usersDAO.getOneUser(username);
		return u;
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
	
	public boolean addNewUser(HttpServletRequest request) {
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
