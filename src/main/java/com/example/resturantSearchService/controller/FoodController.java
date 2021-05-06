package com.example.resturantSearchService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.resturantSearchService.dto.FoodDto;
import com.example.resturantSearchService.service.FoodService;

@RestController
@RequestMapping("/api/v1/foods")
public class FoodController {

	@Autowired
	FoodService foodService;
	
	@GetMapping("/{foodId}")
	public FoodDto getFoodById(@PathVariable long foodId) {
		return foodService.getFoodById(foodId);
	}
	
	@PostMapping
	public ResponseEntity<?> updateFoodQty(@RequestBody FoodDto foodDto){
		return new ResponseEntity<FoodDto>
		(foodService.updateFoodQtyById(foodDto.getFoodId(), foodDto.getQty()), HttpStatus.OK);
	}
}
