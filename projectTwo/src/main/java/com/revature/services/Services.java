package com.revature.services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Photos;
import com.revature.beans.Posts;
import com.revature.beans.TempFile;
import com.revature.beans.Users;
import com.revature.repositories.PhotosDAO;
import com.revature.repositories.PostsDAO;
import com.revature.repositories.UsersDAO;

@Service
public class Services {

	@Autowired
	private UsersDAO usersDAO;
	
	@Autowired
	private PostsDAO postsDAO;
	
	@Autowired
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
		u.setId(0);
		return usersDAO.addNewUser(u);
		
	}
	
	public List<Posts> getAllPostsFromOneUser(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException {
		Users u = null;
		ObjectMapper om = new ObjectMapper();
		u = om.readValue(request.getReader(), Users.class);
		String username = u.getUsername();
		return postsDAO.getAllPostsFromOneUser(username);
	}
	
	public List<Posts> getRecentPosts() {
		return postsDAO.getRecentPosts();
	}
	
	public boolean addNewPost(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException {
		Posts p = null;
		ObjectMapper om = new ObjectMapper();
		p = om.readValue(request.getReader(), Posts.class);
		p.setId(0);
		return postsDAO.addNewPost(p);
	}
	
	public boolean addNewPhoto(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException, ServletException {
		Photos f = null;
		ObjectMapper om = new ObjectMapper();
		f = om.readValue(request.getReader(), Photos.class);
		System.out.println(f.toString());
		return false;
	//	return photosDAO.addNewphoto(f.getFile(), request);
	}
}
