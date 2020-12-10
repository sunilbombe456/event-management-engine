package com.webwork.event.management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/private/event/1/0/customer")
public class CustomerController {
	
	@PostMapping("/book/venue")
	public ResponseEntity<?> bookVenue(){
		return null;
	}
	
	@PostMapping("/book/decoration")
	public ResponseEntity<?> bookDecoration(){
		return null;
	}
	
	@PostMapping("/book/food")
	public ResponseEntity<?> bookFood(){
		return null;
	}

}
