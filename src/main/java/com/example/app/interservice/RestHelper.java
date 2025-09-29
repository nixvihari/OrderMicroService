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
	
	//Get Product Price
	public Double getProductPriceById(Long productId) {
		Double price = restTemplate.getForObject(
				PRODUCT_SERVICE_BASE_URL + "/getProductPriceById/{productId}",
				Double.class,
				productId);
		return price;
	}
	
	//Get Product Quantity
	public Integer getProductQuantityById(Long productId) {
		Integer quantity = restTemplate.getForObject(
				PRODUCT_SERVICE_BASE_URL + "/getProductQuantityById/{productId}",
				Integer.class ,
				productId);
		return quantity;
	}
	
	//Update Product Quantity
	public void updateProductQuantityById(Long productId, Integer updatedQuantity) {
		restTemplate.patchForObject(
				PRODUCT_SERVICE_BASE_URL + "/updateProductQuantityById/{prodId}-{quantity}",
				null, null, productId, updatedQuantity);
	}

}
