package com.capgemini.ordersapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.ordersapp.exception.OrderNotFoundException;



@ControllerAdvice
public class ExceptionsController {
	@ExceptionHandler(value=OrderNotFoundException.class)
	public void handleAccountIdNotFoundException(OrderNotFoundException exception) 
	{
		
		exception.printStackTrace();
	
	}
}
