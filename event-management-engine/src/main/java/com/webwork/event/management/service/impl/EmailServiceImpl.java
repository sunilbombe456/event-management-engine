package com.webwork.event.management.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.webwork.event.management.dto.EmailDTO;
import com.webwork.event.management.email.AccountVerificationEmailContext;
import com.webwork.event.management.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private SpringTemplateEngine templateEngine;

	@Override
	public boolean sendEmail(EmailDTO email) {
		// TODO Auto-generated method stub

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(email.getEmailId());
		msg.setSubject(email.getSubject());
		msg.setText(email.getContent());
		javaMailSender.send(msg);
		return true;
	}

	@Override
	public boolean sendEmailWithAttachment(EmailDTO email) throws MessagingException, IOException {
		// TODO Auto-generated method stub

		MimeMessage msg = javaMailSender.createMimeMessage();

		// true = multipart message
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);

		helper.setTo(email.getEmailId());

		helper.setSubject(email.getSubject());

		// default = text/plain
		// helper.setText("Check attachment for image!");

		// true = text/html
		helper.setText(email.getContent(), true);

		// hardcoded a file path
		FileSystemResource file = new FileSystemResource(
				new File("C:/Users/Sunil Bombe/Pictures/Screenshots/Screenshot (14).png"));

		helper.addAttachment("Screenshot (14)", file);

		javaMailSender.send(msg);

		return true;
	}

	@Override
	public boolean sendVerificationEmail(EmailDTO email) throws MessagingException {
		// TODO Auto-generated method stub

		String htmlContent = "<html></html>";

		MimeMessage msg = javaMailSender.createMimeMessage();

		// true = multipart message
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);

		helper.setTo(email.getEmailId());

		helper.setSubject(email.getSubject());

		// default = text/plain
		// helper.setText("Check attachment for image!");

		// true = text/html
		helper.setText(htmlContent, true);

		// hardcoded a file path
		FileSystemResource file = new FileSystemResource(
				new File("C:/Users/Sunil Bombe/Pictures/theoriginalapporach.jpg"));

		helper.addAttachment("theoriginalapporach.jpg", file);

		javaMailSender.send(msg);

		return true;
	}

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

}
