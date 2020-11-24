package com.webwork.event.management.controller;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webwork.event.management.dto.ResponseMessage;
import com.webwork.event.management.dto.VenueDTO;
import com.webwork.event.management.entity.Event;
import com.webwork.event.management.entity.Food;
import com.webwork.event.management.entity.Venue;
import com.webwork.event.management.repository.EventRepository;
import com.webwork.event.management.repository.FoodRepository;
import com.webwork.event.management.service.AdminService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/private/event/1/0/Admin")
public class AdminController extends BaseController {

	@Autowired
	private EventRepository eventRepo;

	@Autowired
	private FoodRepository foodRepo;

	@Autowired
	private AdminService adminService;

	@Autowired
	private AdminValidator adminValidator;

	@InitBinder("venueDTO")
	public void initMerchantOnlyBinder(WebDataBinder binder) {
		binder.addValidators(adminValidator);
	}

	@PostMapping("/SaveEvent")
	public ResponseEntity<Event> saveEvent(@RequestBody Event event) {

//		adminValidator.validate(event, ); 
		Event theEvent = eventRepo.save(event);
		return new ResponseEntity<>(theEvent, HttpStatus.OK);
	}

	@GetMapping("/demo")
	public ResponseEntity<?> getResponse() {

		ResponseMessage message = new ResponseMessage("Kiran weds ***");

		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@PostMapping("/Venue/Add")
	public ResponseEntity<?> addVenue(@Validated @RequestBody VenueDTO venueDTO) throws ParseException {
		Venue venue = convertToEntity(venueDTO);
		ResponseMessage message = new ResponseMessage();

		if (adminService.saveVenue(venue) != null) {
			message.setMessage("Venue Added Successfully..!");
		} else {
			message.setMessage("Venue Not Added..!");
		}
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

//	 for save food items
	@PostMapping("/Food/Save")
	public ResponseEntity<?> addFood(@RequestBody Food food) {

		ResponseEntity response = null;

		ResponseMessage message = new ResponseMessage();
		food = foodRepo.save(food);
		if (food != null) {
			response = new ResponseEntity<>(food, HttpStatus.OK);
		} else {
			message.setMessage("Not Inserted");
			response = new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
		}

		return response;
	}

}
