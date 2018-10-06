package com.capgemini.ordersapp.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {
	@Id
	private long orderId;
	private String orderName;
	public Orders(long orderId, String orderName) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderName=" + orderName + "]";
	}

	
	

}
