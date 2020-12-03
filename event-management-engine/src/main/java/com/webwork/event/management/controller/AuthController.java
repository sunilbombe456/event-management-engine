package com.webwork.event.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webwork.event.management.dto.AuthRequest;
import com.webwork.event.management.dto.ResponseError;
import com.webwork.event.management.dto.ResponseMessage;
import com.webwork.event.management.dto.UserDTO;
import com.webwork.event.management.repository.UserDetailsRepository;
import com.webwork.event.management.repository.UserRepository;
import com.webwork.event.management.service.FileStorageService;
import com.webwork.event.management.service.LoginService;
import com.webwork.event.management.service.UserService;
import com.webwork.event.management.util.JwtUtil;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/public/event/1/0")
public class AuthController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@Autowired
	private FileStorageService storageService;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserDetailsRepository userDetailsRepo;

	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping("/")
	public String sayHello() {
		return "Hello Word";
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> signIn(@RequestBody AuthRequest authRequest) throws Exception {

		UserDTO userDto = loginService.login(authRequest);

		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody AuthRequest authRequest) throws Exception {
		ResponseMessage message = null;
		if(loginService.signup(authRequest)) {
			message = new ResponseMessage("Check Your Email And Verify Your Email Account..!");
		}
		return new ResponseEntity<>(message, HttpStatus.OK);
	}


	@GetMapping("/verifyEmail")
	public ResponseEntity<?> verifyEmail(@RequestParam String token) {
		if (!loginService.verifyEmail(token)) {
			return new ResponseEntity<>(" Email is Not Verified..!", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(" Email is Verified..!", HttpStatus.OK);
		}
	}

	@GetMapping("/access-denied")
	public ResponseEntity<ResponseError> accessDenied() {
		ResponseError error = new ResponseError();
		error.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		error.setMessage("You Are Not Allowed to Access that Credential..!");
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
	}

	@GetMapping("/demo")
	public ResponseEntity<?> getResponse() {

		ResponseMessage message = new ResponseMessage("Kiran weds ***");

		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
