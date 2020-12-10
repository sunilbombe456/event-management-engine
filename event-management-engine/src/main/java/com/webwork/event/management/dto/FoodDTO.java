package com.webwork.event.management.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import com.webwork.event.management.entity.Images;
import com.webwork.event.management.enums.FoodType;

public class FoodDTO {

	@Id
	private String id;

	private String name;

	private float price;

	private List<FoodType> foodType = new ArrayList<>();

	private List<String> imagesFile = new ArrayList<>();

	private int rId;

	public FoodDTO() {
		super();
	}

	public FoodDTO(String id, String name, float price, List<FoodType> foodType, List<String> imagesFile, int rId) {
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
		return "FoodDTO [id=" + id + ", name=" + name + ", price=" + price + ", foodType=" + foodType + ", imagesFile="
				+ imagesFile + ", rId=" + rId + "]";
	}

}
