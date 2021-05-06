package com.example.resturantSearchService.exception.service.custom;

import com.example.resturantSearchService.exception.service.ResturantSearchServiceException;

public class NoResturantFoundException extends ResturantSearchServiceException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoResturantFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoResturantFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NoResturantFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NoResturantFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NoResturantFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
