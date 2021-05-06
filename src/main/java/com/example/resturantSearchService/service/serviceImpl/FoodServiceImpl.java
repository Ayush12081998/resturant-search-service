package com.example.resturantSearchService.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.resturantSearchService.dto.FoodDto;
import com.example.resturantSearchService.entity.Food;
import com.example.resturantSearchService.repository.FoodRepository;
import com.example.resturantSearchService.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService{

	@Autowired
	FoodRepository foodRepository;
	
	@Override
	public FoodDto getFoodById(long foodId) {
		FoodDto foodDto=null;
		Food food=foodRepository.findById(foodId).orElse(null);
		if(food!=null) {
			foodDto=new FoodDto();
			foodDto.setFoodId(foodId);
			foodDto.setQty(food.getQty());
			foodDto.setPrice(Double.parseDouble(food.getPrice()));
		}
		return foodDto;
	}

	@Override
	public FoodDto updateFoodQtyById(long foodId, int qty) {
		FoodDto foodDto=null;
		Food food=foodRepository.findById(foodId).orElse(null);
		if(food!=null) {
			food.setQty(food.getQty()+qty);
			food=foodRepository.save(food);
			foodDto=new FoodDto();
			foodDto.setFoodId(foodId);
			foodDto.setQty(qty);
		}
		return foodDto;
	}

}
