package com.webwork.event.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webwork.event.management.entity.Event;
import com.webwork.event.management.repository.EventRepository;

@RestController
@RequestMapping("/public/event/1/0")
public class EventController {

	@Autowired
	private EventRepository eventRepo;
	
	@GetMapping("/shows")
	public ResponseEntity<List<Event>> allEvents(){
		List<Event> events = eventRepo.findAll();
		return new ResponseEntity<>(events, HttpStatus.OK);
	}
	
	
}
