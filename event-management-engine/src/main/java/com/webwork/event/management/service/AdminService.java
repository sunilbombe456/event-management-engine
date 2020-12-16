package com.webwork.event.management.service;

import java.util.List;

import javax.mail.MessagingException;

import com.webwork.event.management.entity.User;
import com.webwork.event.management.entity.Venue;

public interface AdminService {

	public boolean deleteUser(int userId) throws MessagingException;

	public List<User> getAllUser();

	public User getUser(int userId);


}
