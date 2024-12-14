package com.ayeldev.auth_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayeldev.auth_api.dto.LoginResponse;
import com.ayeldev.auth_api.dto.LoginUserDto;
import com.ayeldev.auth_api.dto.RegisterUserDto;
import com.ayeldev.auth_api.model.User;
import com.ayeldev.auth_api.service.AuthenticationService;
import com.ayeldev.auth_api.service.JwtService;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
	
	private final JwtService jwtService;
	private final AuthenticationService authenticationService;
	
	public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
		this.jwtService = jwtService;
		this.authenticationService = authenticationService;
	}
	
	@PostMapping("/signup")
	public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto){
		User regsiteredUser = authenticationService.signup(registerUserDto);
		
		return ResponseEntity.ok(regsiteredUser);
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto ){
		User authenticatedUser = authenticationService.authenticate(loginUserDto);
		
		String jwtToken = jwtService.generateToken(authenticatedUser);
		
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setToken(jwtToken);
		loginResponse.setExpiresIn(jwtService.getExpirationTime());
		return ResponseEntity.ok(loginResponse);
	}
}
