package com.webwork.event.management.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Id;

import com.webwork.event.management.entity.Roles;

public class JwtResponse {

	@Id
	private int id;
	
	private String token;

	private String firstName;
	
	private String lastName;

	private String email;
	
	private boolean active;

	private List<String> roles = new ArrayList<>();

	public JwtResponse() {
	}

	public JwtResponse(int id, String token, String firstName, String lastName, String email, boolean active,
			List<String> roles) {
		this.id = id;
		this.token = token;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.active = active;
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

	@Override
	public String toString() {
		return "JwtResponse [id=" + id + ", token=" + token + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", active=" + active + ", roles=" + roles + "]";
	}


	
}
