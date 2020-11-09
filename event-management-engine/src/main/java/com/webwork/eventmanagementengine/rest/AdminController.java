package com.webwork.eventmanagementengine.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webwork.eventmanagementengine.entity.Event;
import com.webwork.eventmanagementengine.repository.EventRepository;

@RestController
@RequestMapping("/private/event/1/0/Admin")
public class AdminController {
	
	@Autowired
	private EventRepository eventRepo;

	@PostMapping("/SaveEvent")
	public ResponseEntity<Event> saveEvent(@RequestBody Event event) {
		Event theEvent = eventRepo.save(event);
		return new ResponseEntity<>(theEvent, HttpStatus.OK);
	}
}
