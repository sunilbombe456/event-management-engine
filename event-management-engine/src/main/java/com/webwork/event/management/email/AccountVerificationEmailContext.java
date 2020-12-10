package com.webwork.event.management.email;

import org.springframework.web.util.UriComponentsBuilder;

import com.webwork.event.management.dto.AuthRequest;

public class AccountVerificationEmailContext extends AbstractEmailContext {

	private String token;

	@Override
	public <T> void init(T context) {
		// we can do comman config setup here
		// like setting up our basew url and context
		AuthRequest user = (AuthRequest) context;
		put("firstName", user.getFirstName());
		setTemplateLocation("verificationEmail");
		setSubject("Complete your registration");
		setFrom("no-reply@theoriginalapproach.com");
		setTo(user.getEmail());
	}

	public void setToken(String token) {
		this.token = token;
		put("token", token);
	}

	public void buildVerificationUrl(final String baseURL, final String token) {
		final String url = UriComponentsBuilder.fromHttpUrl(baseURL).path("/verifyEmail").queryParam("token", token)
				.toUriString();
		put("verificationURL", url);
	}

}
