package com.example.eshop.data.services.db;

import com.example.eshop.data.repositories.CartItemRepository;
import com.example.eshop.data.services.CartItemService;
import com.example.eshop.entities.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceDb implements CartItemService {

	@Autowired
	CartItemRepository cartItemRepository;

	@Override
	public CartItem save(CartItem cartItem) {
		return cartItemRepository.save(cartItem);
	}

	@Override
	public void delete(long id) {
		cartItemRepository.deleteById(id);
	}
}
