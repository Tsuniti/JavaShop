package com.example.eshop.data.services.db;

import com.example.eshop.data.repositories.OrderItemRepository;
import com.example.eshop.data.services.OrderItemService;
import com.example.eshop.entities.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceDb implements OrderItemService {
	@Autowired
	OrderItemRepository orderItemRepository;

	@Override
	public OrderItem save(OrderItem orderItem) {
		return orderItemRepository.save(orderItem);
	}

	@Override
	public void delete(long id) {
		orderItemRepository.deleteById(id);
	}
}
