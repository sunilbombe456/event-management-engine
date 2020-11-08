package com.webwork.eventmanagementengine.entity;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Decoration {

	private int id;
	
	private String name;

	private String Description;
	
	private String decorationSize;
	
	private int price;
	
	private List<String> eventType;
	
	private List<MultipartFile> imagesFile;
	
	private List<String> imagesUrls;
	
	private int rId;
	
	
}
