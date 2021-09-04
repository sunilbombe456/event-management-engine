package com.webwork.event.management.email;

import com.webwork.event.management.entity.User;

public class AccountSuccessEmailContext extends AbstractEmailContext {

	@Override
	public <T> void init(T context) {
		// we can do comman config setup here
		// like setting up our basew url and context
		User user = (User) context;
		put("firstName", user.getFirstName());
		setTemplateLocation("welcome-account");
		setSubject("Account Activated");
		setFrom("no-reply@theoriginalapproach.com");
		setTo(user.getEmail());
	}


	
}
