package com.webwork.event.management.converter;

import com.webwork.event.management.dto.FoodDTO;
import com.webwork.event.management.entity.Food;

public class FoodConverter extends Converter<FoodDTO, Food> {
	public FoodConverter() {
		super(FoodConverter::convertToEntity, FoodConverter::convertToDto);
	}

	private static FoodDTO convertToDto(Food food) {
		return new FoodDTO(food.getId(), food.getName(), food.getPrice(), food.getFoodType(), food.getImagesFile(), food.getrId());
	}

	private static Food convertToEntity(FoodDTO foodDto) {
		return new Food(foodDto.getId(),foodDto.getName(),foodDto.getPrice(),foodDto.getFoodType(),foodDto.getImagesFile(),foodDto.getrId());
	}


}
