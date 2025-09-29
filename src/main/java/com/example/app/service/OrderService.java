package com.example.app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.interservice.RestHelper;
import com.example.app.repo.Order;
import com.example.app.repo.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RestHelper restHelper;

	//Basic CRUD
	public List<Order> getOrders() {
		return orderRepository.findAll();
	}

	public Optional<Order> getOrderById(Long orderId) {
		return orderRepository.findById(orderId);
	}
	
	public Optional<Order> newOrder(Order order) {
		Integer orderQuantity = order.getOrderQuantity();
		Integer productQuantity = restHelper.getProductQuantityById(order.getProductId());
		System.out.println("print product quantity" + productQuantity);
		if (orderQuantity > productQuantity) {
			//handle or throw exception
			System.out.println("insufficient stock");
			return Optional.empty();
		}
		
		//set order date
		order.setOrderDate(LocalDateTime.now());
		
		//Calc and set order value
		Double orderValue = orderQuantity * restHelper.getProductPriceById(order.getProductId());
		order.setOrderValue(orderValue);
		
		//Save order in DB
		Order savedOrder = orderRepository.save(order);
		System.out.println("print order.id" + savedOrder.getOrderNo());
		//deduct product quantity
		restHelper.updateProductQuantityById(
				savedOrder.getProductId(), 
				productQuantity - orderQuantity);
		System.out.println("finally returning savedorder" + savedOrder.getOrderValue());
		return Optional.of(savedOrder);
	}
	
	
	
}
