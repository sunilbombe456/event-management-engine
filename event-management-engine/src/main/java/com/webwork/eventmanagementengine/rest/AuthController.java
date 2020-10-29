package com.webwork.eventmanagementengine.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webwork.eventmanagementengine.dto.AuthRequest;
import com.webwork.eventmanagementengine.dto.ResponseError;
import com.webwork.eventmanagementengine.entity.User;
import com.webwork.eventmanagementengine.exception.UserNotFoundException;
import com.webwork.eventmanagementengine.service.UserService;
import com.webwork.eventmanagementengine.util.JwtUtil;

@RestController
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping("/")
	public String sayHello() {
		return "Hello Word";
	}

	@PostMapping("/authenticate")
	String generateToken(@RequestBody AuthRequest authRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));

		} catch (Exception ex) {
			throw new Exception("invalid username/password");
		}

		return jwtUtil.generateToken(authRequest.getUserName());

	}

	@GetMapping("/save")
	public User save() {
		String username = null;
		if (username == null) {
			throw new UserNotFoundException("User Not Found");
		}
		return null;
	}
	
	@GetMapping("/access-denied")
	public ResponseEntity<ResponseError> accessDenied(){
		ResponseError error = new ResponseError();
		error.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		error.setMessage("You Are Not Allowed to Access that Credential..!");
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.NOT_ACCEPTABLE);
	}
}
