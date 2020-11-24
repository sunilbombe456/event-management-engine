package com.webwork.event.management.entity;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Images {

	@Id
	private String id;

	private String name;

	private String urls = "http://localhost:8080/public/event/1/0/load/";

	public Images() {
	}

	public Images(String name) {
		this.name = name;
		this.urls += name;
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
		this.urls += name;
	}

	public String getUrls() {
		return urls;
	}

	public void setUrls(String urls) {
		this.urls = urls;
	}

	@Override
	public String toString() {
		return "Images [id=" + id + ", name=" + name + "]";
	}

}
