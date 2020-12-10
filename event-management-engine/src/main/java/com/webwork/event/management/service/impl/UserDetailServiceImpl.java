package com.webwork.event.management.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.webwork.event.management.entity.Roles;
import com.webwork.event.management.entity.User;

public class UserDetailServiceImpl implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	
	public UserDetailServiceImpl(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Set<Roles> roles = user.getRoles();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		for(Roles role :roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
			
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getUserPwd();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return user.isActive();
	}
	
	// new Added
	public String getEmail() {
		return user.getEmail();
	}
	
	public int getId() {
		return user.getId();
	}
	
	public String getFirstName() {
		return user.getFirstName();
	}
	
	public String getLastName() {
		return user.getLastName();
	}

}
