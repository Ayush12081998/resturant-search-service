package com.example.resturantSearchService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.resturantSearchService.entity.Menue;

@Repository
public interface MenueRepository extends JpaRepository<Menue, Long>{

}
