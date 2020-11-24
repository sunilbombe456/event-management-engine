package com.webwork.event.management.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webwork.event.management.dto.EventType;
import com.webwork.event.management.dto.ResponseError;
import com.webwork.event.management.entity.Food;
import com.webwork.event.management.entity.Images;
import com.webwork.event.management.entity.Venue;
import com.webwork.event.management.exception.FileNotFoundException;
import com.webwork.event.management.repository.FoodRepository;
import com.webwork.event.management.repository.ImagesRepository;
import com.webwork.event.management.repository.VenueRepository;
import com.webwork.event.management.service.FileService;

@RestController
@RequestMapping("/public/event/1/0")
public class PublicController {
	private final Path root = Paths.get("uploads");

	@Autowired
	private FileService fileService;
	
	@Autowired
	private VenueRepository venueRepo;


	@Autowired
	private ImagesRepository imageRepo;

	@Autowired
	private FoodRepository foodRepo;

	@RequestMapping(value = "/load/{fileName}", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] load(@PathVariable String fileName) throws IOException {
//
//		File file = null;
//		byte[] loadedFile = null;
//		try {
//			 file = new File(this.root.toString() + "/" + fileName);
//			 System.out.println("\n==>" + this.root.toString() + "/" + fileName);
//			 loadedFile = Files.readAllBytes(file.toPath());
//		}catch(NoSuchFileException exe) {
//			throw new FileNotFoundException("File Resources not Found");
//		}
		return fileService.loadImage(fileName);
	}

	@RequestMapping("/venue/all")
	public ResponseEntity<?> loadVenue() {
		List<Venue> venue = venueRepo.findAll();
		ResponseError error = null;
		ResponseEntity<?> response = null;
		if (null != venue) {
			response = new ResponseEntity<>(venue, HttpStatus.OK);
		} else {
			error = new ResponseError(HttpStatus.NOT_FOUND.value(), "NO VENUES FOUND", System.currentTimeMillis());
			response = new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		}
		return response;
	}

	@GetMapping("/load/all")
	public List<Images> loadFile() {
		return imageRepo.findAll();
	}

	@GetMapping("/food/all")
	public ResponseEntity<?> getFood() {
		ResponseEntity<?> response = null;
		List<Food> food = foodRepo.findAll();
		if (food != null) {
			response = new ResponseEntity<>(food, HttpStatus.OK);
		} else {
			throw new FileNotFoundException("No dishes present");
		}
		return response;
	}
	
	@GetMapping("/EventType")
	public ResponseEntity<?> getEventType() {

		ResponseEntity<?> response = null;
		EventType[] eventType = EventType.values();
		try {
			response = new ResponseEntity<>(eventType, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

}
