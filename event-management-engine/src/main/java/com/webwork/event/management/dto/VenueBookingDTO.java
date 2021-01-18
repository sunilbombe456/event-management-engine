package com.webwork.event.management.dto;

import javax.persistence.Id;

public class VenueBookingDTO {

	@Id
	private String id;
	
	private String venueId;
	
	private String venueName;
	
	private int userId;
	
	private String date;

	public VenueBookingDTO() {
	}

	public VenueBookingDTO(String id, String venueId, String venueName, int userId, String date) {
		this.id = id;
		this.venueId = venueId;
		this.venueName = venueName;
		this.userId = userId;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVenueId() {
		return venueId;
	}

	public void setVenueId(String venueId) {
		this.venueId = venueId;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "VenueBookingDTO [id=" + id + ", venueId=" + venueId + ", venueName=" + venueName + ", userId=" + userId
				+ ", date=" + date + "]";
	}

	
}
