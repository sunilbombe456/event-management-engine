package com.webwork.eventmanagementengine.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_pwd")
	private String userPwd;

	@Column(name = "enabled")
	private int active;

	@Column(name = "authority")
	private String role;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="user_detail_id")
	private UserDetails userDetails;

	public User() {
	}

	public User(String userName, String userPwd, int active, String role, UserDetails userDetails) {
		this.userName = userName;
		this.userPwd = userPwd;
		this.active = active;
		this.role = role;
		this.userDetails = userDetails;
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

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userPwd=" + userPwd + ", active=" + active + ", role="
				+ role + ", userDetails=" + userDetails + "]";
	}

}
