package com.webwork.eventmanagementengine.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.webwork.eventmanagementengine.dto.Address;

public class Venue {

	private int id;

	private String name;

	private Address address;

	private List<MultipartFile> imagesFile;

	private List<String> imagesUrls;

	private int rId;

	private List<String> eventType = new ArrayList<String>();

	private int peopleCapacity;

	public Venue() {
	}

	public Venue(String name, Address address, List<MultipartFile> imagesFile, List<String> imagesUrls, int rId,
			List<String> eventType, int peopleCapacity) {
		this.name = name;
		this.address = address;
		this.imagesFile = imagesFile;
		this.imagesUrls = imagesUrls;
		this.rId = rId;
		this.eventType = eventType;
		this.peopleCapacity = peopleCapacity;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public List<String> getEventType() {
		return eventType;
	}

	public void setEventType(List<String> eventType) {
		this.eventType = eventType;
	}

	public int getPeopleCapacity() {
		return peopleCapacity;
	}

	public void setPeopleCapacity(int peopleCapacity) {
		this.peopleCapacity = peopleCapacity;
	}

	public List<MultipartFile> getImagesList() {
		return imagesFile;
	}

	public void setImagesList(List<MultipartFile> imagesFile) {
		this.imagesFile = imagesFile;
	}

	public List<String> getImagesUrls() {
		return imagesUrls;
	}

	public void setImagesUrls(List<String> imagesUrls) {
		this.imagesUrls = imagesUrls;
	}

	@Override
	public String toString() {
		return "Venue [id=" + id + ", name=" + name + ", address=" + address + ", rId=" + rId + ", eventType="
				+ eventType + ", peopleCapacity=" + peopleCapacity + "]";
	}

}
