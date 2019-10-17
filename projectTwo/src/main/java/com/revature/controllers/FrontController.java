package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Users;
import com.revature.services.Services;

@Controller
public class FrontController {

	@Autowired
	private Services services;
	
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<Boolean> login(HttpServletRequest request, HttpServletResponse response) {
		Boolean b = services.login(request);
		//redirect
		return ResponseEntity.status(HttpStatus.OK).body(b);
	}
	
	@PostMapping("/getOneUser")
	@ResponseBody
	public ResponseEntity<Users> getOneUser(HttpServletRequest request, HttpServletResponse response) {
		String a = request.getParameter("id");
		Long id = Long.valueOf(a);
		return ResponseEntity.status(HttpStatus.OK).body(services.getOneUser(id));
	}
	
	@GetMapping("/getAllUsers")
	@ResponseBody
	public ResponseEntity<List<Users>> getAllUsers() {
		return ResponseEntity.status(HttpStatus.OK).body(services.getAllUsers());
	}
	
	@GetMapping("/updateUser")
	@ResponseBody
	public ResponseEntity<Boolean> updateUser(HttpServletRequest request, HttpServletResponse response) {
		Boolean b = services.updateUser(request);
		return ResponseEntity.status(HttpStatus.OK).body(b);
	}
	
	@GetMapping("/addNewUser")
	@ResponseBody
	public ResponseEntity<Boolean> addNewUser(HttpServletRequest request, HttpServletResponse response) {
		Boolean b = services.addNewUser(request);
		return ResponseEntity.status(HttpStatus.OK).body(b);
	}
}
