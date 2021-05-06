package com.example.resturantSearchService.service.serviceImpl;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.resturantSearchService.entity.Food;
import com.example.resturantSearchService.repository.FoodRepository;
import com.example.resturantSearchService.service.FoodService;

@ExtendWith(SpringExtension.class)
class FoodServiceImplTest {

	@TestConfiguration
	static class TestConfig {
		@Bean
		public FoodService foodService() {
			return new FoodServiceImpl();
		}
	}
	
	@Autowired
	FoodService foodService;
	
	@MockBean
	FoodRepository foodRepository;
	
	@Test
	public void getFoodById() {
		Food food=getOneFoodStub();
		when(foodRepository.findById(food.getFoodId())).thenReturn(Optional.of(food));
		foodService.getFoodById(food.getFoodId());
	}
	
	@Test
	public void updateFoodById() {
		Food food=getOneFoodStub();
		when(foodRepository.findById(food.getFoodId())).thenReturn(Optional.of(food));
		when(foodRepository.save(food)).thenReturn(food);
		foodService.updateFoodQtyById(food.getFoodId(),food.getQty());
	}

	private Food getOneFoodStub() {
		Food food=new Food();
		food.setFoodId(1L);
		food.setFoodName("ANY_STRING");
		food.setFoodSegment("ANY_STRING");
		food.setFoodType("ANY_STRING");
		food.setPrice("50");
		food.setQty(100);
		return food;
	}

}
