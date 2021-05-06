package com.example.resturantSearchService.service.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.resturantSearchService.entity.Resturant;
import com.example.resturantSearchService.exception.ResturantSearchServiceAppException;
import com.example.resturantSearchService.exception.service.ResturantSearchServiceException;
import com.example.resturantSearchService.repository.ResturantRepository;
import com.example.resturantSearchService.service.ResturantSearchService;

@ExtendWith(SpringExtension.class)
class ResturantSearchServiceImplTest {

	@TestConfiguration
	static class TestConfig {
		@Bean
		public ResturantSearchService resturantService() {
			return new ResturantSearchServiceImpl();
		}
	}

	@Autowired
	ResturantSearchService searchService;

	@MockBean
	ResturantRepository resturantRepository;

	@Test
	public void findByRetsturantNAme() throws ResturantSearchServiceAppException {
		List<Resturant> resturants = getResturantsListStub();
		when(resturantRepository.findByResturantName(Mockito.anyString())).thenReturn(resturants);
		searchService.findByResturantName(Mockito.anyString());
	}

	@Test
	public void findByRetsturantNAmeNoResultFound() {
		List<Resturant> resturants = new ArrayList<>();
		when(resturantRepository.findByResturantName(Mockito.anyString())).thenReturn(resturants);
		assertThrows(ResturantSearchServiceException.class, () -> {
			searchService.findByResturantName(Mockito.anyString());
		});
	}
	
	@Test
	public void findByRetsturantLocation() throws ResturantSearchServiceAppException {
		List<Resturant> resturants = getResturantsListStub();
		when(resturantRepository.findByLocation(Mockito.anyString())).thenReturn(resturants);
		searchService.findByLocation(Mockito.anyString());
	}
	
	@Test
	public void findByRetsturantLocationNoResultFound() {
		List<Resturant> resturants = new ArrayList<>();
		when(resturantRepository.findByLocation(Mockito.anyString())).thenReturn(resturants);
		assertThrows(ResturantSearchServiceException.class, () -> {
			searchService.findByLocation(Mockito.anyString());
		});
	}
	
	@Test
	public void findByBudget() throws ResturantSearchServiceAppException {
		List<Resturant> resturants = getResturantsListStub();
		when(resturantRepository.findByBudgetPerPerson(Mockito.anyDouble())).thenReturn(resturants);
		searchService.findByBudgetPerPerson(Mockito.anyDouble());
	}
	
	@Test
	public void findByBudgetNoResultFound() {
		List<Resturant> resturants = new ArrayList<>();
		when(resturantRepository.findByBudgetPerPerson(Mockito.anyDouble())).thenReturn(resturants);
		assertThrows(ResturantSearchServiceException.class, () -> {
			searchService.findByBudgetPerPerson(Mockito.anyDouble());
		});
	}

	private List<Resturant> getResturantsListStub() {
		Resturant resturant = getOneResturantStub();
		List<Resturant> resturants = new ArrayList<>();
		resturants.add(resturant);
		return resturants;
	}

	private Resturant getOneResturantStub() {
		Resturant resturant = new Resturant();
		resturant.setBudgetPerPerson(100);
		resturant.setLocation("Patna");
		resturant.setResturantId(1L);
		resturant.setResturantName("ANY_NAME");
		return resturant;
	}

}
