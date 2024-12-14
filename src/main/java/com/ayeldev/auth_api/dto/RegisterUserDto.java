package com.ayeldev.auth_api.dto;

public class RegisterUserDto {
	
	private String firstname;
	private String middlename;
	private String lastname;
	
	private String email;
	private String password;
	
	public RegisterUserDto() {
		super();
	}
	
	public RegisterUserDto(String firstname, String middlename, String lastname, String email, String password) {
		super();
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String username) {
		this.firstname = username;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "RegisterUserDto [firstname=" + firstname + ", middlename=" + middlename + ", lastname=" + lastname
				+ ", email=" + email + ", password=" + password + "]";
	}
	
}
