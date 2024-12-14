package com.ayeldev.auth_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ayeldev.auth_api.model.User;
import com.ayeldev.auth_api.repository.IUserRepository;

@Service
public class UserService {
	
	private final IUserRepository iUserRepository;
	
	public UserService(IUserRepository iUserRepositry) {
		this.iUserRepository = iUserRepositry;
	}
	
	public List<User> allUsers(){
		List<User> users = new ArrayList<>();
		
		iUserRepository.findAll().forEach(users::add);
		
		return users;
	}
}
