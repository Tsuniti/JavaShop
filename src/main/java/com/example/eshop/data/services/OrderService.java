package com.example.eshop.data.services;

import com.example.eshop.entities.Order;

public interface OrderService {
	Order save(Order order);
	//int update(Order order);
	Order findById(long id);
	void delete(long id);
}
