package com.webwork.event.management.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.webwork.event.management.entity.Food;

public interface FoodRepository extends MongoRepository<Food, String> {

	Object findByName(String name);

}
