package com.ayeldev.auth_api.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ayeldev.auth_api.dto.LoginUserDto;
import com.ayeldev.auth_api.dto.RegisterUserDto;
import com.ayeldev.auth_api.model.User;
import com.ayeldev.auth_api.repository.IUserRepository;

@Service
public class AuthenticationService {
	
	private final IUserRepository iUserRepository;
	private final PasswordEncoder passwordEncoder;	
	private final AuthenticationManager authenticationManager;
	
	public AuthenticationService(
			IUserRepository iUserRepository,
			AuthenticationManager authenticationManager,
			PasswordEncoder passwordEncoder
			) {
		this.authenticationManager = authenticationManager;
		this.iUserRepository = iUserRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public User signup(RegisterUserDto input) {
		User user = new User();
			user.setFirstname(input.getFirstname());
			user.setMiddlename(input.getMiddlename());
			user.setLastname(input.getLastname());
			user.setEmail(input.getEmail());
			user.setPassword(passwordEncoder.encode(input.getPassword()));
			
		return iUserRepository.save(user);
	}
	
	public User authenticate(LoginUserDto input) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						input.getEmail(), 
						input.getPassword()
						)
		);
		
		return iUserRepository.findByEmail(input.getEmail()).orElseThrow();
	}
}
