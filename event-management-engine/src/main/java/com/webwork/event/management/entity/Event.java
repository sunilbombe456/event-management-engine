package com.webwork.event.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "event_name")
	private String name;

	@Column(name = "event_description")
	private String description;

	@Column(name = "venue")
	private String venue;

	@Column(name = "event_date")
	private String date;

	@Column(name = "event_start_time")
	private String startTime;

	@Column(name = "evnt_end_time")
	private String endTime;

	@Column(name = "event_images")
	private String images;

	@Column(name = "ponser")
	private String ponsers;

	@Column(name = "brand")
	private String brand;

	@Column(name = "booking")
	private String booking;

	public Event() {
	}

	public Event(String name, String description, String venue, String date, String startTime, String endTime,
			String images, String ponsers, String brand, String booking) {
		this.name = name;
		this.description = description;
		this.venue = venue;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.images = images;
		this.ponsers = ponsers;
		this.brand = brand;
		this.booking = booking;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getPonsers() {
		return ponsers;
	}

	public void setPonsers(String ponsers) {
		this.ponsers = ponsers;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBooking() {
		return booking;
	}

	public void setBooking(String booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", description=" + description + ", venue=" + venue + ", date="
				+ date + ", startTime=" + startTime + ", endTime=" + endTime + ", images=" + images + ", ponsers="
				+ ponsers + ", brand=" + brand + ", booking=" + booking + "]";
	}

}
