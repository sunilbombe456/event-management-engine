package com.webwork.event.management.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webwork.event.management.dto.AuthRequest;
import com.webwork.event.management.email.AccountVerificationEmailContext;
import com.webwork.event.management.service.EmailService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/public/event/1/0")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
//	@PostMapping("/sendEmail")
//	public ResponseEntity<?> sendEmail(@RequestBody EmailContext email) throws MessagingException {
//		emailService.sendMail(email);
//		return new ResponseEntity<>("Successfull", HttpStatus.OK);
//	}
	
	@PostMapping("/sendEmail")
	public ResponseEntity<?> sendEmail(@RequestBody AuthRequest user) throws MessagingException {
		AccountVerificationEmailContext emailContext = new AccountVerificationEmailContext();
		emailContext.init(user);
		emailContext.setToken("ABCEDDHSJDJDFHJVHJDF");
		emailContext.buildVerificationUrl("http://localhost:8080/public/event/1/0", "ABCDHSGFGSJFDFF");
		emailService.sendMail(emailContext);
		return new ResponseEntity<>("Successfull", HttpStatus.OK);
	}
	
	

}
