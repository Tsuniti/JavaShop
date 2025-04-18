package com.example.eshop.data.services;

import com.example.eshop.entities.CartItem;

public interface CartItemService {
	CartItem save(CartItem cartItem);
	//int update(CartItem cartItem);
	void delete(long id);
}
