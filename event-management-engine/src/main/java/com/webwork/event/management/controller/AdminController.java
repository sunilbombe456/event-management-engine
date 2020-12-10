package com.webwork.event.management.controller;

import java.util.List;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webwork.event.management.dto.ResponseMessage;
import com.webwork.event.management.dto.JwtResponse;
import com.webwork.event.management.entity.User;
import com.webwork.event.management.service.AdminService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/private/event/1/0/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;


	@DeleteMapping("/user/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable int userId) throws MessagingException{
		ResponseMessage message = null;
		if(adminService.deleteUser(userId)) {
			message = new ResponseMessage("User Deleted Successfully..!");
		}
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@PostMapping("/user/add")
	public ResponseEntity<?> updateUser(@Valid @RequestBody JwtResponse userDto){
		return null;
	}
	
	@GetMapping("/user/all")
	public ResponseEntity<?> getALlUser(){
		List<User> userList = adminService.getAllUser();
		return new ResponseEntity<>(userList , HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<?> getUser(@PathVariable int userId){
		User user = adminService.getUser(userId);
		return new ResponseEntity<>(user , HttpStatus.OK);
	}

	

}
