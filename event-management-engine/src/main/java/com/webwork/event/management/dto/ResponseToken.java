package com.webwork.event.management.dto;

public class ResponseToken {
	
	private String token;

	public ResponseToken() {
	}

	public ResponseToken(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "Token [token=" + token + "]";
	}
	
	

}
