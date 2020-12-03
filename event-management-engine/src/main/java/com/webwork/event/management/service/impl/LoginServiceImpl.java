package com.webwork.event.management.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webwork.event.management.dto.AuthRequest;
import com.webwork.event.management.dto.EmailDTO;
import com.webwork.event.management.dto.UserDTO;
import com.webwork.event.management.email.AccountVerificationEmailContext;
import com.webwork.event.management.entity.Roles;
import com.webwork.event.management.entity.User;
import com.webwork.event.management.entity.UserDetails;
import com.webwork.event.management.exception.DuplicateEntityException;
import com.webwork.event.management.exception.UserNotFoundException;
import com.webwork.event.management.repository.RolesRepository;
import com.webwork.event.management.repository.UserDetailsRepository;
import com.webwork.event.management.repository.UserRepository;
import com.webwork.event.management.service.EmailService;
import com.webwork.event.management.service.LoginService;
import com.webwork.event.management.util.JwtUtil;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserDetailsRepository userDetailsRepo;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private EmailService emailService;

	@Autowired
	private RolesRepository rolesRepo;
	
	private boolean sendAccountVerificationMail(AuthRequest authRequest, String token) throws MessagingException {
		AccountVerificationEmailContext emailContext = new AccountVerificationEmailContext();
		emailContext.init(authRequest);
		emailContext.setToken(token);
		emailContext.buildVerificationUrl("http://localhost:8080/public/event/1/0", token);
		emailService.sendMail(emailContext);
		return true;
	}

	@Override
	@Transactional
	public UserDTO login(AuthRequest authRequest) throws Exception {
		// TODO Auto-generated method stub

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

		UserDTO userDto = new UserDTO(userDetails.getId(), jwt, userDetails.getUsername(), userDetails.getEmail(),
				roles, userDetails.isEnabled());

		return userDto;
	}

	@Override
	@Transactional
	public boolean signup(AuthRequest authRequest) throws Exception {
		// TODO Auto-generated method stub
		if (userRepo.existsByUserName(authRequest.getUserName())) {
			throw new DuplicateEntityException("username is already Exists..!");
		} else if (userDetailsRepo.existsByEmail(authRequest.getEmail())) {
			throw new DuplicateEntityException("Email is already Exists..!");
		}
		String jwt = jwtUtil.generateToken(authRequest.getUserName());
		User user = getUser(authRequest);
		userRepo.save(user);
		if (!sendAccountVerificationMail(authRequest,jwt)) {
			throw new Exception("Verification Email Not Sended !");
		} else {
			return true;
		}

	}

	private User getUser(AuthRequest authRequest) {
		UserDetails userDetails = new UserDetails();
		userDetails.setFirstName(authRequest.getFirstName());
		userDetails.setLastName(authRequest.getLastName());
		userDetails.setEmail(authRequest.getEmail());
		Set<Roles> role = new HashSet<>();
		Roles roles = rolesRepo.findByName("ROLE_CUSTOMER");
		role.add(roles);
		User user = new User(authRequest.getUserName(), authRequest.getPassword(), false, userDetails);
		user.setRoles(role);
		return user;
	}

	@Override
	public boolean verifyEmail(String token) {
		String userName = jwtUtil.extractUsername(token);
		if (null == userName) {
			throw new UserNotFoundException("Verification Link Time out Resend Verification Link !");
		}
		User user = userRepo.findByUserName(userName);
		user.setActive(true);
		userRepo.save(user);
		return true;
	}

}
