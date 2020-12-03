package com.webwork.event.management.service;

import java.io.IOException;

import javax.mail.MessagingException;

import com.webwork.event.management.dto.EmailContext;
import com.webwork.event.management.dto.EmailDTO;
import com.webwork.event.management.email.AccountVerificationEmailContext;

public interface EmailService {
	public boolean sendEmail(EmailDTO email);
	
	public boolean sendEmailWithAttachment(EmailDTO email) throws MessagingException, IOException;

	public boolean sendVerificationEmail(EmailDTO email)throws MessagingException;

	public void sendMail(AccountVerificationEmailContext emailContext) throws MessagingException;
}
