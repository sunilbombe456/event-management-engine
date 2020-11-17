package com.webwork.eventmanagementengine.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webwork.eventmanagementengine.dto.AuthRequest;
import com.webwork.eventmanagementengine.dto.JwtResponse;
import com.webwork.eventmanagementengine.dto.ResponseError;
import com.webwork.eventmanagementengine.dto.ResponseMessage;
import com.webwork.eventmanagementengine.dto.ResponseToken;
import com.webwork.eventmanagementengine.entity.User;
import com.webwork.eventmanagementengine.exception.UserNotFoundException;
import com.webwork.eventmanagementengine.repository.UserDetailsRepository;
import com.webwork.eventmanagementengine.repository.UserRepository;
import com.webwork.eventmanagementengine.service.FileStorageService;
import com.webwork.eventmanagementengine.service.UserService;
import com.webwork.eventmanagementengine.service.impl.UserDetailServiceImpl;
import com.webwork.eventmanagementengine.util.JwtUtil;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/public/event/1/0")
public class AuthController {

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
	public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) throws Exception {

//		try {
//			authenticationManager.authenticate(
//					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
//
//		} catch (Exception ex) {
//			throw new Exception("invalid username/password");
//		}

		// return jwtUtil.generateToken(authRequest.getUserName());
//		ResponseToken token = new ResponseToken(jwtUtil.generateToken(authRequest.getUserName()));
//
//		return new ResponseEntity<>(token, HttpStatus.OK);

		Authentication authentication;
		try {
			authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (Exception exe) {
			throw new Exception("invalid username/password");
		}
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtil.generateToken(authRequest.getUserName());

		UserDetailServiceImpl userDetails = (UserDetailServiceImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<ResponseToken> signUp(@RequestBody AuthRequest authRequest) throws Exception {
		if (userRepo.existsByUserName(authRequest.getUserName())) {
			throw new UserNotFoundException("username is already Exists..!");
		} else if (userDetailsRepo.existsByEmail(authRequest.getEmail())) {
			throw new UserNotFoundException("Email is already Exists..!");
		}
		User user = userService.signUp(authRequest);
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));

		} catch (Exception ex) {
			throw new Exception("invalid username/password");
		}

		ResponseToken token = new ResponseToken(jwtUtil.generateToken(authRequest.getUserName()));

		return new ResponseEntity<>(token, HttpStatus.OK);

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
	public ResponseEntity<?> getResponse(){
		
		ResponseMessage message = new ResponseMessage("Kiran weds ***");
		
		return new ResponseEntity<>(message, HttpStatus.OK);		
	}
}
