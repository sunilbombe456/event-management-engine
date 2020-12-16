package com.webwork.event.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webwork.event.management.dto.ResponseMessage;
import com.webwork.event.management.entity.VenueBooking;
import com.webwork.event.management.service.VenueService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/private/event/1/0/customer")
public class CustomerController {
	
	@Autowired
	private VenueService venueService;
	
	@PostMapping("/book/decoration")
	public ResponseEntity<?> bookDecoration(){
		return null;
	}
	
	@PostMapping("/book/food")
	public ResponseEntity<?> bookFood(){
		return null;
	}
	
	@PostMapping("/book/venue")
	public ResponseEntity<?> bookVenue(@RequestBody VenueBooking venueBooking){
		ResponseMessage message = null;
		if(venueService.bookVenue(venueBooking)) {
			message = new ResponseMessage("Booking Done");
		}else {
			message = new ResponseMessage("Booking not Done");
		}
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@GetMapping("/hello")
	public ResponseEntity<?> sayHello(){
		ResponseMessage message = new ResponseMessage("Say Hello..!");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
