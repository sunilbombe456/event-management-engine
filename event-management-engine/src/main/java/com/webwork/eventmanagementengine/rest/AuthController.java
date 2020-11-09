package com.webwork.eventmanagementengine.rest;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webwork.eventmanagementengine.dto.AuthRequest;
import com.webwork.eventmanagementengine.dto.ResponseError;
import com.webwork.eventmanagementengine.entity.User;
import com.webwork.eventmanagementengine.exception.UserNotFoundException;
import com.webwork.eventmanagementengine.repository.UserDetailsRepository;
import com.webwork.eventmanagementengine.repository.UserRepository;
import com.webwork.eventmanagementengine.service.FileStorageService;
import com.webwork.eventmanagementengine.service.UserService;
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
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));

		} catch (Exception ex) {
			throw new Exception("invalid username/password");
		}

		return jwtUtil.generateToken(authRequest.getUserName());

	}
	
	@PostMapping("/signup")
	public String signUp(@RequestBody AuthRequest authRequest) throws Exception {
		if(userRepo.existsByUserName(authRequest.getUserName())) {
			throw new UserNotFoundException("username is already Exists..!");
		}else if(userDetailsRepo.existsByEmail(authRequest.getEmail())){
			throw new UserNotFoundException("Email is already Exists..!");
		}
		 User user = userService.signUp(authRequest);
		 try {
				authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));

			} catch (Exception ex) {
				throw new Exception("invalid username/password");
			}

			return jwtUtil.generateToken(authRequest.getUserName());
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
