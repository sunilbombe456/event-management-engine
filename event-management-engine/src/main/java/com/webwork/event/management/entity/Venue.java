package com.webwork.event.management.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.webwork.event.management.dto.Address;
import com.webwork.event.management.enums.EventType;

@Document
public class Venue {

	@Id
	private String id;

	private String name;

	private Address address;

	private List<String> imagesFile = new ArrayList<>();

	private int rId;

	@Enumerated(EnumType.STRING)
	private List<EventType> eventType = new ArrayList<>();

	private int peopleCapacity;

	private float rent;

	private List<String> bookingId;

	public Venue() {
	}

	public Venue(String id, String name, Address address, List<String> imagesFile, int rId, List<EventType> eventType,
			int peopleCapacity, float rent, List<String> bookingId) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.imagesFile = imagesFile;
		this.rId = rId;
		this.eventType = eventType;
		this.peopleCapacity = peopleCapacity;
		this.rent = rent;
		this.bookingId = bookingId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<String> getImagesFile() {
		return imagesFile;
	}

	public void setImagesFile(List<String> imagesFile) {
		this.imagesFile = imagesFile;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public List<EventType> getEventType() {
		return eventType;
	}

	public void setEventType(List<EventType> eventType) {
		this.eventType = eventType;
	}

	public int getPeopleCapacity() {
		return peopleCapacity;
	}

	public void setPeopleCapacity(int peopleCapacity) {
		this.peopleCapacity = peopleCapacity;
	}

	public float getRent() {
		return rent;
	}

	public void setRent(float rent) {
		this.rent = rent;
	}

	public List<String> getBookingId() {
		return bookingId;
	}

	public void setBookingId(List<String> bookingId) {
		this.bookingId = bookingId;
	}

	@Override
	public String toString() {
		return "Venue [id=" + id + ", name=" + name + ", address=" + address + ", imagesFile=" + imagesFile + ", rId="
				+ rId + ", eventType=" + eventType + ", peopleCapacity=" + peopleCapacity + ", rent=" + rent
				+ ", bookingId=" + bookingId + "]";
	}

	public void addBooking(String id) {
		if (this.bookingId == null) {
			this.bookingId = new ArrayList<>();
		}
		this.bookingId.add(id);
	}

}
