package com.webwork.eventmanagementengine.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	@GetMapping("/")
	public String sayHello() {
		return "Hello Word";
	}
}
