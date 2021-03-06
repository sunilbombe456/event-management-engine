package com.webwork.event.management.service.impl;

import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webwork.event.management.email.AbstractEmailContext;
import com.webwork.event.management.email.AccountDeletedEmailContext;
import com.webwork.event.management.entity.User;
import com.webwork.event.management.exception.EntityNotFoundException;
import com.webwork.event.management.repository.UserRepository;
import com.webwork.event.management.service.EmailService;
import com.webwork.event.management.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	@Transactional
	public User save(User user) {
		return userRepo.save(user);
	}

	@Override
	@Transactional
	public List<User> getAll() {
		List<User> userList = userRepo.findAll();
		if (userList == null) {
			throw new EntityNotFoundException("User List Not Found..!");
		}
		return userList;
	}

	@Override
	@Transactional
	public User get(int id) {
		Optional<User> result = userRepo.findById(id);
		if (!result.isPresent()) {
			throw new EntityNotFoundException("User Not Found");
		}
		return result.get();
	}

	@Override
	@Transactional
	public boolean delete(int id) throws MessagingException {
		Optional<User> result = userRepo.findById(id);
		if (!result.isPresent()) {
			throw new EntityNotFoundException("User Not Found");
		} else {
			User user = result.get();
			if(sendEmail(user)) {
				userRepo.delete(user);
				return true;
			}
			
		}
		return false;
	}

	private boolean sendEmail(User user) throws MessagingException {
		AbstractEmailContext emailContext = new AccountDeletedEmailContext();
		emailContext.init(user);
		emailService.sendMail(emailContext);
		return true;
	}

}
