package com.capgemini.ordersapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.ordersapp.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long>{
	

}
