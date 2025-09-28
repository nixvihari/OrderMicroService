package com.example.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.controller.OrderController;
import com.example.app.interservice.RestHelper;
import com.example.app.repo.Order;
import com.example.app.repo.OrderRepository;

@Service
public class OrderService {

	private final OrderController orderController;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RestHelper restHelper;

	OrderService(OrderController orderController) {
		this.orderController = orderController;
	}

	public List<Order> getOrders() {
		return orderRepository.findAll();
	}

	public Optional<Order> getOrderById(Long orderId) {
		return orderRepository.findById(orderId);
	}
	
	public Order newOrder(Order order) {
		Integer orderQuantity = order.getOrderQuantity();
		Integer productQuantity = restHelper.getProductQuantityById(order.getProductId());
		
		if (orderQuantity > productQuantity) {
			//handle or throw exception
			return null;
		}
		
		order.setOrderDate(LocalDate.now());
		Double orderValue = orderQuantity * restHelper.getProductPriceById(order.getProductId());
		order.setOrderValue(orderValue);
		
		return orderRepository.save(order);
	}
}
