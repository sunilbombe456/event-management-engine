package com.webwork.event.management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webwork.event.management.converter.Converter;
import com.webwork.event.management.converter.DecorationConverter;
import com.webwork.event.management.dto.DecorationDTO;
import com.webwork.event.management.dto.ResponseMessage;
import com.webwork.event.management.entity.Decoration;
import com.webwork.event.management.service.DecorationService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/private/event/1/0/decoration")
public class DecorationController {

	@Autowired
	private DecorationService decorationService;

	private Converter convert = new DecorationConverter();

	@PostMapping("/add")
	public ResponseEntity<?> addDecoration(@Valid @RequestBody DecorationDTO decorationDto) {
		Decoration decoration = (Decoration) convert.convertFromDto(decorationDto);
		decoration = decorationService.save(decoration);
		decorationDto = (DecorationDTO) convert.convertFromEntity(decoration);
		return new ResponseEntity<>(decorationDto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{decorationId}")
	public ResponseEntity<?> deleteDecoration(@PathVariable String decorationId) {
		ResponseMessage message = null;
		if (decorationService.delete(decorationId)) {
			message = new ResponseMessage("decoration Deleted Successfully.!");
		} 
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
