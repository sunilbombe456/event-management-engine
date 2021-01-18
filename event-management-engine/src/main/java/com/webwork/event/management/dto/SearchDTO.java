package com.webwork.event.management.dto;

import com.webwork.event.management.enums.EventType;
import com.webwork.event.management.enums.LocationType;

public class SearchDTO {
	
	private EventType eventType;
	
	private String date;
	
	private int peopleCount;
	
	private LocationType location;

	public SearchDTO() {
	}

	public SearchDTO(EventType eventType, String date, int peopleCount, LocationType location) {
		this.eventType = eventType;
		this.date = date;
		this.peopleCount = peopleCount;
		this.location = location;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPeopleCount() {
		return peopleCount;
	}

	public void setPeopleCount(int peopleCount) {
		this.peopleCount = peopleCount;
	}

	public LocationType getLocation() {
		return location;
	}

	public void setLocation(LocationType location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "SearchDTO [eventType=" + eventType + ", date=" + date + ", peopleCount=" + peopleCount + ", location="
				+ location + "]";
	}

	
}
