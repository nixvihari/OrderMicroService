package com.example.app.repo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_no")
	private Long orderNo;
	
	@Column(name = "product_id", nullable = false)
	private Long productId;
	
	@Column(name = "user_id", nullable = false)
	private Long userId;
	
	@JsonIgnore
	@Column(name = "order_date")
	private LocalDate orderDate;
	
	@Column(name = "order_quantity")
	private Integer orderQuantity;
	
	@JsonIgnore
	@Column(name = "order_value")
	private Double orderValue;

	public Order() {}

	public Order(Long orderNo, Long productId, Long userId, LocalDate orderDate, Integer orderQuantity,
			Double orderValue) {
		this.orderNo = orderNo;
		this.productId = productId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.orderQuantity = orderQuantity;
		this.orderValue = orderValue;
	}

	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public Double getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(Double orderValue) {
		this.orderValue = orderValue;
	}
	
}
