package com.ayeldev.auth_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayeldev.auth_api.model.User;
import com.ayeldev.auth_api.service.UserService;

@RequestMapping("/users")
@RestController
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/me")
	public ResponseEntity<User> authenticatedUser(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		User currentUser = (User) authentication.getPrincipal();
		
		if(currentUser == null)
		return ResponseEntity.ofNullable(currentUser);
					
		return ResponseEntity.ok(currentUser);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<User>> allUsers(){
		List<User> users = userService.allUsers();
		
		return ResponseEntity.ok(users);
	}
}
