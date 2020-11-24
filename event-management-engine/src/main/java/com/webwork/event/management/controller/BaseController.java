package com.webwork.event.management.controller;

import org.apache.tomcat.util.json.ParseException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.webwork.event.management.dto.FoodDTO;
import com.webwork.event.management.dto.VenueDTO;
import com.webwork.event.management.entity.Food;
import com.webwork.event.management.entity.Venue;

@RestController
public class BaseController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	// Venue Converter
	
	protected Venue convertToEntity(VenueDTO venueDTO) throws ParseException {
		Venue venue = modelMapper.map(venueDTO, Venue.class);
		return venue;
	}
	
	protected VenueDTO convertToDto(Venue venue) throws ParseException {
	    VenueDTO venueDTO = modelMapper.map(venue, VenueDTO.class);
	    return venueDTO;
	}
	
	// food Converter
	
	protected Food convertToEntity(FoodDTO foodDTO) throws ParseException {
		Food food = modelMapper.map(foodDTO, Food.class);
		return food;
	}
	
	protected FoodDTO convertToDto(Food food) throws ParseException {
	    FoodDTO foodDTO = modelMapper.map(food, FoodDTO.class);
	    return foodDTO;
	}

}
