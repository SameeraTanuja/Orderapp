package com.capgemini.ordersapp;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.ordersapp.controller.OrderController;
import com.capgemini.ordersapp.entity.Orders;
import com.capgemini.ordersapp.service.OrderService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class OrderControllerTest 
{
	@Mock
	OrderService orderService;
	
	@InjectMocks
	OrderController orderController;
	private MockMvc mockMvc;
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
	}
	
	@Test
	public void testAddOrders() throws Exception
	{
		when(orderService.addOrder(Mockito.isA(Orders.class))).thenReturn(new Orders(1234,"toy"));
		mockMvc.perform(post("/order")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content("{\r\n" + 
						"  \"orderId\": \"12345\",\r\n" + 
						"  \"orderName\": \"toy\"\r\n" + 
						"}")
				.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.orderId").value(1234))
				.andDo(print());
		
	}
}
