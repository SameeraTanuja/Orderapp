package com.capgemini.ordersapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ordersapp.entity.Orders;
import com.capgemini.ordersapp.exception.OrderNotFoundException;
import com.capgemini.ordersapp.repository.OrderRepository;
import com.capgemini.ordersapp.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;
	

	@Override
	public void deleteOrderById(long orderId) 
	{
		orderRepository.deleteById(orderId);
	}

	@Override
	public List<Orders> getAllOrders() 
	{
		return orderRepository.findAll();
		
	}

	@Override
	public Orders getOrderById(long orderId)throws OrderNotFoundException
	{
	try
	{
		Optional<Orders> optionalOrder = orderRepository.findById(orderId);
		if(optionalOrder.isPresent())
			return optionalOrder.get();
		else
			return null;

	}
	catch(IllegalArgumentException e) {
		OrderNotFoundException orderNotFoundException = new OrderNotFoundException("order not found");
		orderNotFoundException.initCause(e);
		throw orderNotFoundException;
		
	}
	
	}

	@Override
	public Orders addOrder(Orders order)
	{
		return orderRepository.save(order);
	}

}
