package com.example.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.repo.Order;
import com.example.app.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public List<Order> getOrders() {
		return orderService.getOrders();
	}
	
	@GetMapping("/{orderId}")
	public Optional<Order> getOrderById(@PathVariable("orderId") Long orderId) {
		return orderService.getOrderById(orderId);
	}
	
	@PostMapping("/newOrder")
	public Optional<Order> newOrder(@RequestBody Order order) {
		return orderService.newOrder(order);
	}
	
	@DeleteMapping("/deleteOrder/{orderId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteOrder(@PathVariable("orderId") Long orderId) {
		orderService.deleteOrder(orderId);
	}

}
