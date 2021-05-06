package com.example.resturantSearchService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.resturantSearchService.entity.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long>{

}
