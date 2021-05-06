package com.example.resturantSearchService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.resturantSearchService.entity.Resturant;
import com.example.resturantSearchService.exception.ResturantSearchServiceAppException;
import com.example.resturantSearchService.service.ResturantSearchService;

@RequestMapping("/api/v1/resturants")
@RestController
public class ResturantSearchServiceController {

	@Autowired
	ResturantSearchService searchService;
	

	@GetMapping("/name/{name}")
	public List<Resturant> getResturantsByName(@PathVariable String name) throws ResturantSearchServiceAppException {
		return searchService.findByResturantName(name);
	}
	
	@GetMapping("/location/{location}")/*location=cityName*/
	public List<Resturant> getResturantsByLocationCode(@PathVariable String location) throws ResturantSearchServiceAppException {
		return searchService.findByLocation(location);
	}
	
	@GetMapping("/budget/{budgetPerPerson}")
	public List<Resturant> getResturantsByBudget(@PathVariable double budgetPerPerson) throws ResturantSearchServiceAppException {
		return searchService.findByBudgetPerPerson(budgetPerPerson);
	}
}
