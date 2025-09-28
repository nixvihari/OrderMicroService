package com.example.app.interservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestHelper {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String PRODUCT_SERVICE_BASE_URL =  "http://localhost:9091/api/products";
	
	
	//Product calls
	public Double getProductPriceById(Long productId) {
		Double price = restTemplate.getForObject(
				PRODUCT_SERVICE_BASE_URL + "/getProductPriceById/{productId}",
				Double.class,
				productId);
		return price;
	}
	
	public Integer getProductQuantityById(Long productId) {
		Integer quantity = restTemplate.getForObject(
				PRODUCT_SERVICE_BASE_URL + "/getProductQuantityById/{productId}",
				Integer.class ,
				productId);
		return quantity;
	}

}
