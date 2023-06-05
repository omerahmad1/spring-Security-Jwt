package com.spring.security.jwt.Models;

public class CreateUserRequest {
	private String firstName;
	private String lastName;
	private String username;
	private CharSequence password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public CharSequence getPassword() {
		return password;
	}

	public void setPassword(CharSequence password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "CreateUserRequest [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + "]";
	}

}
