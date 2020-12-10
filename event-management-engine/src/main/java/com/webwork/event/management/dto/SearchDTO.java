package com.webwork.event.management.dto;

import java.util.Date;

import com.webwork.event.management.enums.EventType;

public class SearchDTO {
	
	private EventType eventType;
	
	private Date date;
	
	private int peopleCount;

	public SearchDTO() {
	}

	public SearchDTO(EventType eventType, Date date, int peopleCount) {
		this.eventType = eventType;
		this.date = date;
		this.peopleCount = peopleCount;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getPeopleCount() {
		return peopleCount;
	}

	public void setPeopleCount(int peopleCount) {
		this.peopleCount = peopleCount;
	}

	@Override
	public String toString() {
		return "SearchDTO [eventType=" + eventType + ", date=" + date + ", peopleCount=" + peopleCount + "]";
	}
	
}
