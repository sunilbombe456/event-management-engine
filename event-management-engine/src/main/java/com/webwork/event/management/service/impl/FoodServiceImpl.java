package com.webwork.event.management.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webwork.event.management.entity.Food;
import com.webwork.event.management.entity.Venue;
import com.webwork.event.management.exception.DuplicateEntityException;
import com.webwork.event.management.exception.EntityNotFoundException;
import com.webwork.event.management.repository.FoodRepository;
import com.webwork.event.management.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodRepository foodRepo;

	@Override
	@Transactional
	public Food save(Food food) {
		if (null != food.getId()) {
			return foodRepo.save(food);
		} else if (null != foodRepo.findByName(food.getName())) {
			throw new DuplicateEntityException("food Aready Added..");
		}
		return foodRepo.save(food);
	}

	@Override
	@Transactional
	public boolean delete(String foodId) {
		// TODO Auto-generated method stub
		Optional<Food> result = foodRepo.findById(foodId);
		if (!result.isPresent()) {
			throw new EntityNotFoundException("Dish not present");
		} else {
			Food food = result.get();
			foodRepo.delete(food);
			return true;
		}
	}

	@Override
	public List<Food> getAll() {
		List<Food> foodList = foodRepo.findAll();
		if (foodList == null) {
			throw new EntityNotFoundException("Food List not found..!");
		}
		return foodList;
	}

	@Override
	public Food get(String id) {
		Optional<Food> result = foodRepo.findById(id);
		if (!result.isPresent()) {
			throw new EntityNotFoundException("Venue Not Found..!");
		} else {
			return result.get();
		}
	}

}
