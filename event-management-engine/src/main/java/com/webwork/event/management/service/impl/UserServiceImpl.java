package com.webwork.event.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webwork.event.management.dto.AuthRequest;
import com.webwork.event.management.entity.User;
import com.webwork.event.management.entity.UserDetails;
import com.webwork.event.management.repository.UserRepository;
import com.webwork.event.management.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
	}

	@Override
	public User signUp(AuthRequest authRequest) {
		UserDetails userDetails = new UserDetails();
		userDetails.setFirstName(authRequest.getFirstName());
		userDetails.setLastName(authRequest.getLastName());
		userDetails.setEmail(authRequest.getEmail());
		User user = new User(authRequest.getUserName(),authRequest.getPassword(),true,userDetails);
		
		return userRepo.save(user);
	}


}
