package com.webwork.event.management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webwork.event.management.converter.Converter;
import com.webwork.event.management.converter.VenueConverter;
import com.webwork.event.management.dto.ResponseMessage;
import com.webwork.event.management.dto.VenueDTO;
import com.webwork.event.management.entity.Venue;
import com.webwork.event.management.service.VenueService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/private/event/1/0/venue")
public class VenueController {

	@Autowired
	private VenueService venueService;

	private Converter convert = new VenueConverter();

	@PostMapping("/add")
	public ResponseEntity<?> addVenue(@Valid @RequestBody VenueDTO venueDto){
		Venue venue = (Venue) convert.convertFromDto(venueDto);
		 venue = venueService.save(venue);
		 venueDto =(VenueDTO) convert.convertFromEntity(venue);
		return new ResponseEntity<>(venueDto, HttpStatus.OK);
	}

	@PutMapping("/add")
	public ResponseEntity<?> updateVenue(@Valid @RequestBody VenueDTO venueDto) {
		Venue venue = (Venue) convert.convertFromDto(venueDto);
		venue = venueService.save(venue);
		venueDto = (VenueDTO) convert.convertFromEntity(venue);
		return new ResponseEntity<>(venueDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{venueId}")
	public ResponseEntity<?> deleteVenue(@PathVariable String venueId) {
		ResponseMessage message = null;
		if (venueService.delete(venueId)) {
			message = new ResponseMessage("Deleted Successfull..!");
		}
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	
}
