package com.webwork.event.management.controller;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webwork.event.management.converter.Converter;
import com.webwork.event.management.converter.VenueConverter;
import com.webwork.event.management.dto.VenueDTO;
import com.webwork.event.management.entity.Decoration;
import com.webwork.event.management.entity.Food;
import com.webwork.event.management.entity.Images;
import com.webwork.event.management.entity.Venue;
import com.webwork.event.management.enums.EventType;
import com.webwork.event.management.enums.FoodType;
import com.webwork.event.management.repository.ImagesRepository;
import com.webwork.event.management.service.DecorationService;
import com.webwork.event.management.service.FileService;
import com.webwork.event.management.service.FoodService;
import com.webwork.event.management.service.VenueService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/public/event/1/0")
public class PublicController {
	private final Path root = Paths.get("uploads");
	
	private Converter convert;

	@Autowired
	private FileService fileService;

	@Autowired
	private VenueService venueService;

	@Autowired
	private FoodService foodService;

	@Autowired
	private DecorationService decorationService;



	@Autowired
	private ImagesRepository imageRepo;

	

	@GetMapping("/food/type")
	public ResponseEntity<?> getFoodType() {
		ResponseEntity<?> response = null;
		FoodType[] foodType = FoodType.values();
		try {
			response = new ResponseEntity<>(foodType, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@GetMapping("/event/type")
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

	@GetMapping("/venue/all")
	public ResponseEntity<?> venueAll() {
		convert = new VenueConverter();
		List<Venue> venueList = venueService.getAll();
		List<VenueDTO> venueDtoList = convert.createFromEntities(venueList);
		return new ResponseEntity<>(venueDtoList, HttpStatus.OK);
	}

	@GetMapping("/venue/{venueId}")
	public ResponseEntity<?> venue(@PathVariable String venueId) {
		Venue venue = venueService.get(venueId);
		return new ResponseEntity<>(venue, HttpStatus.OK);
	}

	@GetMapping("/food/all")
	public ResponseEntity<?> foodAll() {
		List<Food> foodList = foodService.getAll();
		return new ResponseEntity<>(foodList, HttpStatus.OK);
	}

	@GetMapping("/food/{foodId}")
	public ResponseEntity<?> food(@PathVariable String foodId) {
		Food food = foodService.get(foodId);
		return new ResponseEntity<>(food, HttpStatus.OK);
	}
	
	@GetMapping("/decoration/all")
	public ResponseEntity<?> decorationAll(){
		List<Decoration> decorationList = decorationService.getAll();
		return new ResponseEntity<>(decorationList, HttpStatus.OK);
	}
	
	@GetMapping("/decoration/{decorationId}")
	public ResponseEntity<?> decoration(@PathVariable String decorationId){
		Decoration decoration = decorationService.get(decorationId);
		return new ResponseEntity<>(decoration, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/files/load/{fileName}", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] load(@PathVariable String fileName) throws IOException {
		return fileService.loadImage(fileName);
	}
	
	@GetMapping("/files/load/encoded/{fileName}")
	public ResponseEntity<?> loadFileString(@PathVariable String fileName){
		
		String encodedImage = null;
		try {
			 encodedImage = fileService.loadEncodedImage(fileName);
		} catch (NoSuchFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(encodedImage, HttpStatus.OK);
	}

	@GetMapping("/load/all")
	public List<Images> loadFile() {
		return imageRepo.findAll();
	}

}
