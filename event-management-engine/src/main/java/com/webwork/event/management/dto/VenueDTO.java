package com.webwork.event.management.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.webwork.event.management.enums.EventType;

public class VenueDTO {

	@Id
	private String id;

	@NotBlank(message = "Name Should not be Empty")
	private String name;

	@NotNull(message = "Address Should not be Empty")
	private Address address;

	@NotNull(message = "Images Should not be Empty.")
	private List<String> imagesFile = new ArrayList<>();
	

	private int rId;

	@Enumerated(EnumType.STRING)
	private List<EventType> eventType = new ArrayList<>();

	@Min(100)
	private int peopleCapacity;

	private float rent;
	
	private List<String> bookingId;

	public VenueDTO() {
	}

	public VenueDTO(String id, @NotBlank(message = "Name Should not be Empty") String name,
			@NotNull(message = "Address Should not be Empty") Address address,
			@NotNull(message = "Images Should not be Empty.") List<String> imagesFile, int rId,
			List<EventType> eventType, @Min(100) int peopleCapacity, float rent, List<String> bookingId) {
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
		return "VenueDTO [id=" + id + ", name=" + name + ", address=" + address + ", imagesFile=" + imagesFile
				+ ", rId=" + rId + ", eventType=" + eventType + ", peopleCapacity=" + peopleCapacity + ", rent=" + rent
				+ ", bookingId=" + bookingId + "]";
	}
	
	



}
