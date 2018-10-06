package com.capgemini.ordersapp.service;

import java.util.List;

import com.capgemini.ordersapp.entity.Orders;
import com.capgemini.ordersapp.exception.OrderNotFoundException;

public interface OrderService
{
	public void deleteOrderById(long orderId);
	public List<Orders> getAllOrders();
	public Orders getOrderById(long orderId) throws OrderNotFoundException;
	public Orders addOrder(Orders order);
	
}
