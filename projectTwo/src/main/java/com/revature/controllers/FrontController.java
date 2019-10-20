package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.revature.beans.Posts;
import com.revature.beans.Users;
import com.revature.services.Services;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class FrontController {

	
	@Autowired
	private Services services;
	
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<Users> login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Users u = services.login(request);
		if (u == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(u);
		}
		else
			return ResponseEntity.status(HttpStatus.OK).body(u);
	}
	
	//****Needs validation****//
	@PostMapping("/logout")
	@ResponseBody
	public ResponseEntity<Boolean> logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath() + "SomethingSomething.html");
		return ResponseEntity.status(HttpStatus.OK).body(true);
	}
	
	@PostMapping("/getOneUser")
	@ResponseBody
	public ResponseEntity<Users> getOneUser(HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		Users u = services.getOneUser(request);
		if (u == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(u);
		}
		else
			return ResponseEntity.status(HttpStatus.OK).body(u);
	}
	
	@GetMapping("/getAllUsers")
	@ResponseBody
	public ResponseEntity<List<Users>> getAllUsers() {
		return ResponseEntity.status(HttpStatus.OK).body(services.getAllUsers());
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/updateUser")
	@ResponseBody
	public ResponseEntity<Boolean> updateUser(HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		Boolean b = services.updateUser(request);
		if (b == false)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(b);
		else
			return ResponseEntity.status(HttpStatus.OK).body(b);
	}
	
	@PostMapping("/addNewUser")
	@ResponseBody
	public ResponseEntity<Boolean> addNewUser(HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		Boolean b = services.addNewUser(request);
		if (b == false)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(b);
		else
			return ResponseEntity.status(HttpStatus.OK).body(b);
	}
	
	@PostMapping("/postsFromOneUser")
	@ResponseBody
	public ResponseEntity<List<Posts>> getAllPostsFromOneUser(HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		List<Posts> list = services.getAllPostsFromOneUser(request);
		if (list == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(list);
		else
			return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@PostMapping("/newPost")
	@ResponseBody
	public ResponseEntity<Boolean> addNewPost(HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		Boolean b = services.addNewPost(request);
		if (b == false)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(b);
		else
			return ResponseEntity.status(HttpStatus.OK).body(b);
	}
}
