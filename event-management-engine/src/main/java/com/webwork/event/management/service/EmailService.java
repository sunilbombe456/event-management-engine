package com.webwork.event.management.service;

import javax.mail.MessagingException;

import com.webwork.event.management.email.AbstractEmailContext;
import com.webwork.event.management.email.AccountVerificationEmailContext;

public interface EmailService {
	
	public void sendMail(AbstractEmailContext emailContext) throws MessagingException;
	
	public void sendMail(AccountVerificationEmailContext emailContext) throws MessagingException;
	

}
