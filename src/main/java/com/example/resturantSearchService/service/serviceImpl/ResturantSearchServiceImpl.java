package com.example.resturantSearchService.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.resturantSearchService.entity.Resturant;
import com.example.resturantSearchService.exception.service.ResturantSearchServiceException;
import com.example.resturantSearchService.repository.ResturantRepository;
import com.example.resturantSearchService.service.ResturantSearchService;

@Service
public class ResturantSearchServiceImpl implements ResturantSearchService{

	
	@Autowired
	ResturantRepository resturantRepository;

	@Override
	public List<Resturant> findByResturantName(String resturantName) throws ResturantSearchServiceException {
		List<Resturant>resturantsSearchResult=resturantRepository.findByResturantName(resturantName);
		if(resturantsSearchResult.size()==0) {
			throw new ResturantSearchServiceException("No Resturant found according to search "+resturantName);
		}
		return resturantsSearchResult;
	}

	@Override
	public List<Resturant> findByLocation(String location) throws ResturantSearchServiceException {
		List<Resturant>resturantsSearchResult=resturantRepository.findByLocation(location);
		if(resturantsSearchResult.size()==0) {
			throw new ResturantSearchServiceException("No Resturant found according to search "+location);
		}
		return resturantsSearchResult;
	}

	@Override
	public List<Resturant> findByBudgetPerPerson(double budget) throws ResturantSearchServiceException {
		List<Resturant>resturantsSearchResult=resturantRepository.findByBudgetPerPerson(budget);
		if(resturantsSearchResult.size()==0) {
			throw new ResturantSearchServiceException("No Resturant found according to search "+budget);
		}
		return resturantsSearchResult;

	}
	
}
