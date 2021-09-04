package com.webwork.event.management.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.webwork.event.management.entity.Roles;
import com.webwork.event.management.entity.UserDetails;

public class UserDTO {

	@Id
	private int id;
	
	private String firstName;

	private String middleName;

	private String lastName;

	private String email;

	private String userPwd;

	private boolean active;

	private UserDetails userDetails;

	private Set<Roles> roles = new HashSet<>();

	

}
