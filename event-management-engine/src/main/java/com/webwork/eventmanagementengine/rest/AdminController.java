package com.webwork.eventmanagementengine.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Admin")
public class AdminController {

	@GetMapping("/SaveEvent")
	public String saveEvent() {
		return "Only Admin Can Access This Credentials...!";
	}
}
