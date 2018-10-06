package com.capgemini.ordersapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ordersapp.entity.Orders;
import com.capgemini.ordersapp.exception.OrderNotFoundException;
import com.capgemini.ordersapp.service.OrderService;

@RestController
public class OrderController
{
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/order")
	public ResponseEntity<Orders> addOrder(@RequestBody Orders order)
	{
		ResponseEntity<Orders> responseEntity  =new ResponseEntity<Orders>(orderService.addOrder(order),HttpStatus.OK);
		LOGGER.info("Got my ORDER" +" "+responseEntity.getBody());
		return responseEntity;
	}
	
	@GetMapping("/order/{orderId}")
	public ResponseEntity<Orders> getOrderByOrderId(@PathVariable long orderId) throws OrderNotFoundException
	{
		
			ResponseEntity<Orders> responseEntity  =new ResponseEntity<Orders>(orderService.getOrderById(orderId),HttpStatus.OK);
			return responseEntity;
	}
	@DeleteMapping("/order/{orderId}")
	public void deleteOrderById(@PathVariable long orderId)
	{
		orderService.deleteOrderById(orderId);
	}
	
	@GetMapping("/order")
	public List<Orders> getAllOrders()
	{
		return orderService.getAllOrders();
	}
	
	
	

}
