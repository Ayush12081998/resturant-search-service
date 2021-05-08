package com.example.resturantSearchService.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "resturant")
public class Resturant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long resturantId;
	@OneToOne
	private Menue menue;
	private String resturantName;
	private String location;
	private double budgetPerPerson;
	public Long getResturantId() {
		return resturantId;
	}
	public void setResturantId(Long resturantId) {
		this.resturantId = resturantId;
	}
	public Menue getMenue() {
		return menue;
	}
	public void setMenue(Menue menue) {
		this.menue = menue;
	}
	public String getResturantName() {
		return resturantName;
	}
	public void setResturantName(String resturantName) {
		this.resturantName = resturantName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getBudgetPerPerson() {
		return budgetPerPerson;
	}
	public void setBudgetPerPerson(double budgetPerPerson) {
		this.budgetPerPerson = budgetPerPerson;
	}
	@Override
	public String toString() {
		return "Resturant [resturantId=" + resturantId + ", resturantName=" + resturantName + ", location=" + location
				+ ", budgetPerPerson=" + budgetPerPerson + "]";
	}
	
}

