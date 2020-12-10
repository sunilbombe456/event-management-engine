package com.webwork.event.management.dto;

import java.util.Map;

public class EmailContext {
	private String from;
	private String to;
	private String subject;
	private String email;
	private String attachment;
	private String fromDisplayName;
	private String emailLanguage;
	private String displayName;
	private String templateLocation;
	private Map<String, Object> context;
	public EmailContext() {
	}
	public EmailContext(String from, String to, String subject, String email, String attachment, String fromDisplayName,
			String emailLanguage, String displayName, String templateLocation, Map<String, Object> context) {
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.email = email;
		this.attachment = attachment;
		this.fromDisplayName = fromDisplayName;
		this.emailLanguage = emailLanguage;
		this.displayName = displayName;
		this.templateLocation = templateLocation;
		this.context = context;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public String getFromDisplayName() {
		return fromDisplayName;
	}
	public void setFromDisplayName(String fromDisplayName) {
		this.fromDisplayName = fromDisplayName;
	}
	public String getEmailLanguage() {
		return emailLanguage;
	}
	public void setEmailLanguage(String emailLanguage) {
		this.emailLanguage = emailLanguage;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getTemplateLocation() {
		return templateLocation;
	}
	public void setTemplateLocation(String templateLocation) {
		this.templateLocation = templateLocation;
	}
	public Map<String, Object> getContext() {
		return context;
	}
	public void setContext(Map<String, Object> context) {
		this.context = context;
	}
	
}
