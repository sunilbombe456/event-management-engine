package com.webwork.event.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.webwork.event.management.entity.User;
import com.webwork.event.management.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//
//		User user = userRepo.findByUserName(username);
//		if(user == null) {
//			throw new UsernameNotFoundException("User NoT found..!");
//		}
//		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPwd(),
//				new ArrayList<>());
//	}

	@Override
	public UserDetailServiceImpl loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		User user = userRepo.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("User NoT found..!");
		}
		return new UserDetailServiceImpl(user);
	}

}
