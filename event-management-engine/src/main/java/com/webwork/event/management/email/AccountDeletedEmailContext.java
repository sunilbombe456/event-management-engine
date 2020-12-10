package com.webwork.event.management.email;

import com.webwork.event.management.entity.User;

public class AccountDeletedEmailContext extends AbstractEmailContext {

	@Override
	public <T> void init(T context) {
		// we can do comman config setup here
		// like setting up our basew url and context
		User user = (User) context;
		put("firstName", user.getFirstName());
		setTemplateLocation("account-delete-email");
		setSubject("Account Deleted");
		setFrom("no-reply@theoriginalapproach.com");
		setTo(user.getEmail());
	}
	
}
