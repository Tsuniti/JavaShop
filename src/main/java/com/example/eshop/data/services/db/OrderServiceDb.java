package com.example.eshop.data.services.db;

import com.example.eshop.data.repositories.OrderRepository;
import com.example.eshop.data.services.OrderService;
import com.example.eshop.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceDb implements OrderService {
	@Autowired
	OrderRepository orderRepository;

	@Override
	public Order save(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order findById(long id) {
		return orderRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(long id) {
		orderRepository.deleteById(id);
	}
}
