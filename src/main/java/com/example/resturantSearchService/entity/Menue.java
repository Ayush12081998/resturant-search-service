package com.example.resturantSearchService.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "food_menue")
public class Menue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long menueId;
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties("menue")
	private Resturant resturant;
	@OneToMany(mappedBy = "menue")
	private List<Food>foodsInMenue;
	public Long getMenueId() {
		return menueId;
	}
	public void setMenueId(Long menueId) {
		this.menueId = menueId;
	}
	public List<Food> getFoodsInMenue() {
		return foodsInMenue;
	}
	public void setFoodsInMenue(List<Food> foodsInMenue) {
		this.foodsInMenue = foodsInMenue;
	}
	
	
}
