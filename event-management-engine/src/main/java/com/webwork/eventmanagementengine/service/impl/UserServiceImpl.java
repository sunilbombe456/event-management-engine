package com.webwork.eventmanagementengine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webwork.eventmanagementengine.entity.User;
import com.webwork.eventmanagementengine.repository.UserRepository;
import com.webwork.eventmanagementengine.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
	}

}
