package com.webwork.event.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webwork.event.management.entity.Event;
import com.webwork.event.management.repository.EventRepository;
import com.webwork.event.management.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/private/event/1/0/Admin")
public class AdminController {

	@Autowired
	private EventRepository eventRepo;



	@Autowired
	private UserService userService;




	@PostMapping("/SaveEvent")
	public ResponseEntity<Event> saveEvent(@RequestBody Event event) {

//		adminValidator.validate(event, ); 
		Event theEvent = eventRepo.save(event);
		return new ResponseEntity<>(theEvent, HttpStatus.OK);
	}


	

}
