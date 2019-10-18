package com.revature.services;

import java.io.File;
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
import com.revature.repositories.PhotosDAO;
import com.revature.repositories.PostsDAO;
import com.revature.repositories.UsersDAO;

@Service
public class Services {

	@Autowired
	private UsersDAO usersDAO;
	private PostsDAO postsDAO;
	private PhotosDAO photosDAO;
	
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

	public boolean updateUser(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException {
		Users u = null;
		ObjectMapper om = new ObjectMapper();
		u = om.readValue(request.getReader(), Users.class);
		return usersDAO.updateUser(u);
		
	}
	
	public boolean addNewUser(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException {
		Users u = null;
		ObjectMapper om = new ObjectMapper();
		u = om.readValue(request.getReader(), Users.class);
		System.out.println(u.toString());
		u.setId(0);
		return usersDAO.addNewUser(u);
		
	}
	
	public boolean addNewphoto(File file, HttpServletRequest request) {
		//photosDAO.addNewphoto(file, request)
		return false;
	}
}
