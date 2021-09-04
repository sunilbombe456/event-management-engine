package com.webwork.event.management.service;

import java.util.List;

import com.webwork.event.management.entity.Food;

public interface FoodService {

	public Food save(Food food);

	public boolean delete(String foodId);

	public List<Food> getAll();

	public Food get(String id);

	public List<Food> saveAll(List<Food> foodList);

}
