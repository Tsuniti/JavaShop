package com.example.eshop.data.services.db;

import com.example.eshop.data.repositories.CartRepository;
import com.example.eshop.data.services.CartService;
import com.example.eshop.entities.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceDb implements CartService {
	@Autowired
	CartRepository cartRepository;

	@Override
	public Cart save(Cart cart) {
		return cartRepository.save(cart);
	}

	@Override
	public Cart findById(int id) {
		return cartRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(int id) {
		cartRepository.deleteById(id);
	}
}
