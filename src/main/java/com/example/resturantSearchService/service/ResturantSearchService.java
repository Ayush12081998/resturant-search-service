package com.example.resturantSearchService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.resturantSearchService.entity.Resturant;
import com.example.resturantSearchService.exception.service.ResturantSearchServiceException;

@Service
public interface ResturantSearchService {

	public List<Resturant>  findByResturantName(String resturantName) throws ResturantSearchServiceException;
	public List<Resturant> findByLocation(String location)throws ResturantSearchServiceException;
	public List<Resturant> findByBudgetPerPerson(double budget)throws ResturantSearchServiceException;
}
