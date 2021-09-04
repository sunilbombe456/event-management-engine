package com.webwork.event.management.service;

import com.webwork.event.management.dto.AuthRequest;
import com.webwork.event.management.dto.JwtResponse;

public interface LoginService {
	
	public JwtResponse login(AuthRequest authRequest) throws Exception;
	
	public boolean signup(AuthRequest authRequest) throws Exception;

	public boolean verifyEmail(String token) throws Exception;

}
