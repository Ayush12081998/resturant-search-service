package com.example.resturantSearchService.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.resturantSearchService.exception.ResturantSearchServiceAppException;

@RestControllerAdvice
public class ResturantSearchServiceHandler {

	@ExceptionHandler(ResturantSearchServiceAppException.class)
	public ResponseEntity<?> errorHandler(Exception e){
		com.example.resturantSearchService.dto.ErrorDto errdto=new com.example.resturantSearchService.dto.ErrorDto(e.getMessage(), e);
		com.example.resturantSearchService.dto.ResponseBody<Void> response=new com.example.resturantSearchService.dto.ResponseBody<>(errdto,null);
		return new ResponseEntity<com.example.resturantSearchService.dto.ResponseBody<Void>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
