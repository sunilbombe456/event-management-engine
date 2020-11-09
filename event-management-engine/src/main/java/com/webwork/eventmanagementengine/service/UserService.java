package com.webwork.eventmanagementengine.service;

import com.webwork.eventmanagementengine.dto.AuthRequest;
import com.webwork.eventmanagementengine.entity.User;

public interface UserService {

	void save(User user);

	User signUp(AuthRequest authRequest);

}
