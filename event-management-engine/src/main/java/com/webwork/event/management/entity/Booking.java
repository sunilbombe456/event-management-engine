package com.webwork.event.management.entity;

import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Booking {

	@Id
	private String id;
	
	private String name;
	
	private Date date;
	
	private int userId;
	
	private float rate ;
	
	
	
	
}
