package com.example.resturantSearchService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.resturantSearchService.dto.FoodDto;
import com.example.resturantSearchService.dto.ResponseBody;
import com.example.resturantSearchService.exception.ResturantSearchServiceAppException;
import com.example.resturantSearchService.service.ResturantSearchService;

@RequestMapping("/api/v1/resturants")
@RestController
public class ResturantSearchServiceController {

	@Autowired
	ResturantSearchService searchService;
	

	@GetMapping("/name/{name}")
	public ResponseEntity<?> getResturantsByName(@PathVariable String name) throws ResturantSearchServiceAppException {
		return new ResponseEntity<ResponseBody<FoodDto>>(new ResponseBody<FoodDto>(null,searchService.findByResturantName(name) ), HttpStatus.OK);
	}
	
	@GetMapping("/location/{location}")/*location=cityName*/
	public ResponseEntity<?> getResturantsByLocationCode(@PathVariable String location) throws ResturantSearchServiceAppException {
		return new ResponseEntity<ResponseBody<FoodDto>>(new ResponseBody<FoodDto>(null,searchService.findByLocation(location)), HttpStatus.OK);
				
	}
	
	@GetMapping("/budget/{budgetPerPerson}")
	public ResponseEntity<?> getResturantsByBudget(@PathVariable double budgetPerPerson) throws ResturantSearchServiceAppException {
		return new ResponseEntity<ResponseBody<FoodDto>>(new ResponseBody<FoodDto>(null,searchService.findByBudgetPerPerson(budgetPerPerson)), HttpStatus.OK); 
				
	}
}
