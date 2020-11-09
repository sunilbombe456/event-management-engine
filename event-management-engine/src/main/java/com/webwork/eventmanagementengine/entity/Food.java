package com.webwork.eventmanagementengine.entity;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Food {
	private int id;
	
	private int name;
	
	private float price;
	
	private String foodCatagory;
	
	private List<MultipartFile> imagesFile;
	
	private List<String> imagesUrls;
	
	private int rId;

	public Food() {
	}

	public Food(int name, float price, String foodCatagory, List<MultipartFile> imagesFile, List<String> imagesUrls,
			int rId) {
		this.name = name;
		this.price = price;
		this.foodCatagory = foodCatagory;
		this.imagesFile = imagesFile;
		this.imagesUrls = imagesUrls;
		this.rId = rId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getFoodCatagory() {
		return foodCatagory;
	}

	public void setFoodCatagory(String foodCatagory) {
		this.foodCatagory = foodCatagory;
	}

	public List<MultipartFile> getImagesFile() {
		return imagesFile;
	}

	public void setImagesFile(List<MultipartFile> imagesFile) {
		this.imagesFile = imagesFile;
	}

	public List<String> getImagesUrls() {
		return imagesUrls;
	}

	public void setImagesUrls(List<String> imagesUrls) {
		this.imagesUrls = imagesUrls;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", price=" + price + ", foodCatagory=" + foodCatagory
				+ ", imagesFile=" + imagesFile + ", imagesUrls=" + imagesUrls + ", rId=" + rId + "]";
	}
	

}
