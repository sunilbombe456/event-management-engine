package com.webwork.event.management.dto;

import java.util.ArrayList;
import java.util.List;

import com.webwork.event.management.entity.Images;


public class VenueDTO {
	
	private String id;

	private String name;

	private Address address;

	private List<Images> imagesFile = new ArrayList<>();

	private int rId;

	private String eventType;

	private int peopleCapacity;

	public VenueDTO() {
	}

	public VenueDTO(String name, Address address, List<Images> imagesFile, int rId, String eventType,
			int peopleCapacity) {
		this.name = name;
		this.address = address;
		this.imagesFile = imagesFile;
		this.rId = rId;
		this.eventType = eventType;
		this.peopleCapacity = peopleCapacity;
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

	public List<Images> getImagesFile() {
		return imagesFile;
	}

	public void setImagesFile(List<Images> imagesFile) {
		this.imagesFile = imagesFile;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public int getPeopleCapacity() {
		return peopleCapacity;
	}

	public void setPeopleCapacity(int peopleCapacity) {
		this.peopleCapacity = peopleCapacity;
	}

	@Override
	public String toString() {
		return "VenueDTO [id=" + id + ", name=" + name + ", address=" + address + ", imagesFile=" + imagesFile
				+ ", rId=" + rId + ", eventType=" + eventType + ", peopleCapacity=" + peopleCapacity + "]";
	}


}
