package com.example.app.model;

public class ProductQuantity {
	
	private Integer quantity;
	
	public ProductQuantity() {}
	public ProductQuantity(Integer quantity) {}
	
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ProductQuantity {quantity: " + quantity + "}";
	}
	
	
	
	
}
