package com.webwork.event.management.service.impl;

import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.webwork.event.management.email.AbstractEmailContext;
import com.webwork.event.management.email.AccountVerificationEmailContext;
import com.webwork.event.management.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private SpringTemplateEngine templateEngine;

	

	@Override
	public void sendMail(AccountVerificationEmailContext emailContext) throws MessagingException {
		// TODO Auto-generated method stub
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message,
				MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
		Context context = new Context();
		context.setVariables(emailContext.getContext());
		String emailContent = templateEngine.process(emailContext.getTemplateLocation(), context);

		mimeMessageHelper.setTo(emailContext.getTo());
		mimeMessageHelper.setSubject(emailContext.getSubject());
		mimeMessageHelper.setFrom(emailContext.getFrom());
		mimeMessageHelper.setText(emailContent, true);
		javaMailSender.send(message);
	}

	@Override
	public void sendMail(AbstractEmailContext emailContext) throws MessagingException {
		// TODO Auto-generated method stub
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message,
				MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
		Context context = new Context();
		context.setVariables(emailContext.getContext());
		String emailContent = templateEngine.process(emailContext.getTemplateLocation(), context);

		mimeMessageHelper.setTo(emailContext.getTo());
		mimeMessageHelper.setSubject(emailContext.getSubject());
		mimeMessageHelper.setFrom(emailContext.getFrom());
		mimeMessageHelper.setText(emailContent, true);
		javaMailSender.send(message);
	}
	
	


}
