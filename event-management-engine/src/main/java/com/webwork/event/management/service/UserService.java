package com.webwork.event.management.service;

import java.util.List;

import com.webwork.event.management.entity.User;

public interface UserService {

	public User save(User user);

	public List<User> getAll();
	
	public User get(int id);
	
	public boolean delete(int id);
	

}
