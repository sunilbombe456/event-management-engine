package com.webwork.event.management.service;

import com.webwork.event.management.dto.AuthRequest;
import com.webwork.event.management.entity.User;

public interface UserService {

	void save(User user);

	User signUp(AuthRequest authRequest);

}
