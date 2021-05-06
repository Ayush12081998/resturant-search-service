package com.example.resturantSearchService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.resturantSearchService.entity.Resturant;

@Repository
public interface ResturantRepository extends JpaRepository<Resturant, Long>{

	public List<Resturant>  findByResturantName(String resturantName);
	public List<Resturant> findByLocation(String location);
	public List<Resturant> findByBudgetPerPerson(double budget);
}
