package com.webwork.event.management.dto;

import java.util.ArrayList;
import java.util.List;

public class JwtResponse {

	private String token;

	private int id;

	private String userName;

	private String email;

	private List<String> roles = new ArrayList<>();

	public JwtResponse() {
	}

	public JwtResponse(String token, int id, String userName, String email, List<String> roles) {
		this.token = token;
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.roles = roles;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "JwtResponse [token=" + token + ", id=" + id + ", userName=" + userName + ", email=" + email + ", roles="
				+ roles + "]";
	}

}
