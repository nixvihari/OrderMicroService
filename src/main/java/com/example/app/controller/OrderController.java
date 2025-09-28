package com.example.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.repo.Order;
import com.example.app.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@GetMapping
	public List<Order> getOrders() {
		return orderService.getOrders();
	}
	
	@PostMapping("/sendHello")
	public void sendHello(@RequestParam("message") String message) {
		kafkaTemplate.send("hello", message);
	}
}
