package com.webwork.event.management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {
	
	@GetMapping("/All")
	public String demo() {
		return "Hello User";
	}

}
