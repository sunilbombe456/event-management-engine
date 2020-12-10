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
import com.webwork.event.management.dto.JwtResponse;
import com.webwork.event.management.email.AbstractEmailContext;
import com.webwork.event.management.email.AccountSuccessEmailContext;
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
	public JwtResponse login(AuthRequest authRequest) throws Exception {
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

		return new JwtResponse(userDetails.getId(), jwt, userDetails.getFirstName(), userDetails.getLastName(),
				userDetails.getEmail(), userDetails.isEnabled(), roles);
	}

	@Override
	@Transactional
	public boolean signup(AuthRequest authRequest) throws Exception {
		// TODO Auto-generated method stub
		if (userRepo.existsByEmail(authRequest.getUserName())) {
			throw new DuplicateEntityException("username is already Exists..!");
		}
		String jwt = jwtUtil.generateToken(authRequest.getEmail());
		User user = getUser(authRequest);
		userRepo.save(user);
		if (!sendAccountVerificationMail(authRequest, jwt)) {
			throw new Exception("Verification Email Not Sended !");
		} else {
			return true;
		}

	}


	private User getUser(AuthRequest authRequest) {
		User user = new User();
		user.setFirstName(authRequest.getFirstName());
		user.setLastName(authRequest.getLastName());
		user.setEmail(authRequest.getEmail());
		user.setUserPwd(authRequest.getPassword());
		user.setActive(false);
		user.setUserDetails(new UserDetails());
		Set<Roles> role = new HashSet<>();
		Roles roles = rolesRepo.findByName("ROLE_CUSTOMER");
		role.add(roles);
		user.setRoles(role);
		return user;
	}

	@Override
	public boolean verifyEmail(String token) throws Exception {
		String userName = jwtUtil.extractUsername(token);
		if (null == userName) {
			throw new UserNotFoundException("Verification Link Time out Resend Verification Link !");
		}
		User user = userRepo.findByEmail(userName);
		user.setActive(true);
		userRepo.save(user);
		if (!sendAccountActivationMail(user)) {
			throw new Exception("Verification Email Not Sended !");
		}
		return true;
	}

	private boolean sendAccountActivationMail(User user) throws MessagingException {
		AbstractEmailContext emailContext = new AccountSuccessEmailContext();
		emailContext.init(user);
		emailService.sendMail(emailContext);
		return true;
	}

}
