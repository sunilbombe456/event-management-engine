package com.webwork.event.management.service.impl;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webwork.event.management.entity.User;
import com.webwork.event.management.service.AdminService;
import com.webwork.event.management.service.UserService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UserService userService;

	@Override
	public boolean deleteUser(int userId) throws MessagingException {
		if(userService.delete(userId)) {
			return true;
		}
		return false;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userService.getAll();
	}

	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		return userService.get(userId);
	}



}
