package com.webwork.event.management.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.webwork.event.management.enums.EventType;

@Document
public class Decoration {

	@Id
	private String id;
	
	private String name;

	private String description;
	
	private String decorationSize;
	
	private int price;
	
	private List<EventType> eventType = new ArrayList<>();
	
	private List<String> imagesFile = new ArrayList<>();
	
	private int rId;

	public Decoration() {
	}

	public Decoration(String name, String description, String decorationSize, int price, List<EventType> eventType,
			List<String> imagesFile, int rId) {
		this.name = name;
		this.description = description;
		this.decorationSize = decorationSize;
		this.price = price;
		this.eventType = eventType;
		this.imagesFile = imagesFile;
		this.rId = rId;
	}
	
	

	public Decoration(String id, String name, String description, String decorationSize, int price,
			List<EventType> eventType, List<String> imagesFile, int rId) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.decorationSize = decorationSize;
		this.price = price;
		this.eventType = eventType;
		this.imagesFile = imagesFile;
		this.rId = rId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDecorationSize() {
		return decorationSize;
	}

	public void setDecorationSize(String decorationSize) {
		this.decorationSize = decorationSize;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<EventType> getEventType() {
		return eventType;
	}

	public void setEventType(List<EventType> eventType) {
		this.eventType = eventType;
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

	@Override
	public String toString() {
		return "Decoration [id=" + id + ", name=" + name + ", description=" + description + ", decorationSize="
				+ decorationSize + ", price=" + price + ", eventType=" + eventType + ", imagesFile=" + imagesFile
				+ ", rId=" + rId + "]";
	}
	
}
