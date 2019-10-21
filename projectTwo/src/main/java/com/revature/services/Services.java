package com.revature.services;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	ServletContext servletContext;
	
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
//		u.setId((long) request.getSession().getAttribute("id"));
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
		System.out.println(u.toString());
		String username = u.getUsername();
		System.out.println(username);
		return postsDAO.getAllPostsFromOneUser(username);
	}
	
	public List<Posts> getRecentPosts() {
		return postsDAO.getRecentPosts();
	}
	
	public boolean addNewPost(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException {
		Posts p = null;
		ObjectMapper om = new ObjectMapper();
		p = om.readValue(request.getReader(), Posts.class);
//		p.setId(0);
		return postsDAO.addNewPost(p);
	}
	
	public List<Photos> getRecentPhotos() {
		return photosDAO.getRecentPhotos();
	}
	
	public boolean addNewPhoto(MultipartHttpServletRequest request) throws JsonParseException, JsonMappingException, IOException, ServletException {
		
		MultipartFile f = request.getFile("image");
		byte[] bytes = f.getBytes();
		long id = Long.valueOf(request.getParameter("id"));
		return photosDAO.addNewPhoto(bytes, id);
	}

	public List<Photos> getPhotosUser(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException {
		Users u = null;
		ObjectMapper om = new ObjectMapper();
		u = om.readValue(request.getReader(), Users.class);
		String username = u.getUsername();
		return photosDAO.getAllPhotosFromOneUser(username);
	}
	
//	public byte[] createLocalFile(MultipartHttpServletRequest request) throws IOException, ServletException {
//		
//		MultipartFile f = request.getFile("image");		
//		byte[] bytes = f.getBytes();
//		
//		return bytes;
//	}
}
