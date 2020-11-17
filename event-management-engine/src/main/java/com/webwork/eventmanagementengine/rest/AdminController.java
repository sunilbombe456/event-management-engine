package com.webwork.eventmanagementengine.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webwork.eventmanagementengine.dto.ResponseMessage;
import com.webwork.eventmanagementengine.entity.Event;
import com.webwork.eventmanagementengine.entity.Venue;
import com.webwork.eventmanagementengine.repository.EventRepository;
import com.webwork.eventmanagementengine.repository.VenueRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/private/event/1/0/Admin")
public class AdminController {
	
	@Autowired
	private EventRepository eventRepo;
	
	@Autowired
	private VenueRepository venueRepo;

	@PostMapping("/SaveEvent")
	public ResponseEntity<Event> saveEvent(@RequestBody Event event) {
		Event theEvent = eventRepo.save(event);
		return new ResponseEntity<>(theEvent, HttpStatus.OK);
	}
	
	@GetMapping("/demo")
	public ResponseEntity<?> getResponse(){
		
		ResponseMessage message = new ResponseMessage("Kiran weds ***");
		
		return new ResponseEntity<>(message, HttpStatus.OK);		
	}
	
	@PostMapping("/Venue/Add")
	public ResponseEntity<?> addVenue(@RequestBody Venue venue){
		ResponseMessage message = new ResponseMessage();
		if(venueRepo.save(venue) != null) {
			message.setMessage("Entity Added..!");
		}else {
			message.setMessage("Entity is not Added..!");
		}
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
