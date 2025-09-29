package com.example.app.interservice;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
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
		
		String url = PRODUCT_SERVICE_BASE_URL + "/updateProductQuantityById/{productId}-{updatedQuantity}";

		Map<String, Object> uriVars = Map.of("productId", productId, "updatedQuantity", updatedQuantity);

		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> requestEntity = new HttpEntity<>(null, header);
		
		restTemplate.exchange(
				url, 
				HttpMethod.PUT,
				requestEntity, 
				Void.class, 
				uriVars);
	}

}
