package com.webwork.event.management.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.webwork.event.management.enums.FoodType;

@Document
public class Food {

	@Id
	private String id;

	private String name;

	private float price;

	private List<FoodType> foodType = new ArrayList<>();

	private List<Images> imagesFile = new ArrayList<>();

	private int rId;


	public Food() {
	}


	public Food(String id, String name, float price, List<FoodType> foodType, List<Images> imagesFile, int rId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.foodType = foodType;
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


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public List<FoodType> getFoodType() {
		return foodType;
	}


	public void setFoodType(List<FoodType> foodType) {
		this.foodType = foodType;
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


	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", price=" + price + ", foodType=" + foodType + ", imagesFile="
				+ imagesFile + ", rId=" + rId + "]";
	}

	
}
