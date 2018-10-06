package com.capgemini.ordersapp.client;

import org.springframework.web.client.RestTemplate;

import com.capgemini.ordersapp.entity.Orders;

public class OrdersControllerRestTemplateClient 
{
	private static final RestTemplate REST_TEMPLATE = new RestTemplate();
	private static final String baseUrl = "http://localhost:9090/";
	
	public static void main(String[] args) {
		
		//Adding a new product into database.
		String url = baseUrl + "order";
		Orders order = new Orders(1234, "toy");
		order = addOrder(url, order);
		System.out.println("After saving order into dababase : " + order);
		
		 order = new Orders(1235, "flowers");
		order = addOrder(url, order);
		System.out.println("After saving order into dababase : " + order);
		
		order = new Orders(1236, "fruits");
		order = addOrder(url, order);
		System.out.println("After saving order into dababase : " + order);
		/*//Getting product from database
		String url = baseUrl + "/products/102";
		Product product = findProductById(url);
		System.out.println("Product from DB : " + product);*/
		
		// Deleting product from database
	url = baseUrl + "order/1234";		
		deleteOrder(url);
		
	/*	//Updating product into database
		url = baseUrl + "order";
		Orders order = new Orders(1234,"toysss");
		updateOrder(url, order);
		order = findOrderById(baseUrl + "order/1234");
		System.out.println(order);
	}

	public static void updateOrder(String url, Orders order) {
		 REST_TEMPLATE.put(url, order);
		 System.out.println("--success--");
	}
*/
	

/*	public static Orders findOrderById(String url) {
		return REST_TEMPLATE.getForObject(url,Orders.class);
	}*/



}
	public static Orders addOrder(String url, Orders order) {
		Orders orderAfterSavingIntoDb =  REST_TEMPLATE.postForObject(url, order, Orders.class);
		System.out.println("--success--");
		return orderAfterSavingIntoDb;
				
	}
	public static void deleteOrder(String url) {
		REST_TEMPLATE.delete(url);
		System.out.println("--success--");
	}
}
