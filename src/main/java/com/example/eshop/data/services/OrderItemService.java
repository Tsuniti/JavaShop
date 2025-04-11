package com.example.eshop.data.services;

import com.example.eshop.entities.OrderItem;

public interface OrderItemService {
	OrderItem save(OrderItem orderItem);
	//int update(OrderItem orderItem);
	void delete(Long id);
}
