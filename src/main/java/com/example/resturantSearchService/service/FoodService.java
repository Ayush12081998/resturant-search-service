package com.example.resturantSearchService.service;

import org.springframework.stereotype.Service;

import com.example.resturantSearchService.dto.FoodDto;

@Service
public interface FoodService {

	public FoodDto getFoodById(long foodId);
	public FoodDto updateFoodQtyById(long foodId,int qty);
}
