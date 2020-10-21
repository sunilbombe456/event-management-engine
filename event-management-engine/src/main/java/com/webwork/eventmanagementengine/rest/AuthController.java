package com.webwork.eventmanagementengine.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webwork.eventmanagementengine.entity.User;
import com.webwork.eventmanagementengine.entity.UserDetails;
import com.webwork.eventmanagementengine.service.UserService;

@RestController
public class AuthController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello Word";
	}
	
	@GetMapping("/save")
	public User save() {
		UserDetails theUserDetails = new UserDetails("ganesh","dadabhau","bombe","ganeshbombe@gmail.com","7218332379","pimpri","pune","pune","maharashtra","410504");
		
		User user = new User("ganeshbombe@gmail.com","ganesh",1,"ROLE_CUSTOMER", theUserDetails);
		
		userService.save(user);
		
		return user;
	}
}
