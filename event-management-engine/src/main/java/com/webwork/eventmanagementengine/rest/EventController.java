package com.webwork.eventmanagementengine.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webwork.eventmanagementengine.dto.ResponseMessage;

@RestController
@RequestMapping("/Event")
public class EventController {

	@GetMapping("/All")
	public ResponseEntity<ResponseMessage> allEvents(){
		ResponseMessage message = new ResponseMessage("All Event Accessed");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
}
