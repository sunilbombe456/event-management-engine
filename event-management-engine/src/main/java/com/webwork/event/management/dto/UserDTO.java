package com.webwork.event.management.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Id;

import com.webwork.event.management.entity.Roles;
import com.webwork.event.management.entity.UserDetails;

public class UserDTO {

	@Id
	private int id;
	
	private String token;

	private String userName;

	private String email;
	
	private boolean active;

	private List<String> roles = new ArrayList<>();

	public UserDTO() {
	}

	public UserDTO(String token, String userName, String email, boolean active,
			List<String> roles) {
		this.token = token;
		this.userName = userName;
		this.email = email;
		this.active = active;
		this.roles = roles;
	}
	
	public UserDTO(int id, String token, String userName, String email, List<String> roles) {
		this.id = id;
		this.token = token;
		this.userName = userName;
		this.email = email;
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
}
