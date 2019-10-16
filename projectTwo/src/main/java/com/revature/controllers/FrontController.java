package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Users;
import com.revature.services.Services;

@Controller
public class FrontController {

	@Autowired
	private Services services;
	
	@RequestMapping(method = RequestMethod.GET, value = "/home")
	public String login() {
		String s = null;
		return s;
	}
	
	@GetMapping("/allUsers")
	@ResponseBody
	public List<Users> getAllUsers() {
		return services.getAllUsers();
	}
}
