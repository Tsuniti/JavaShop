package com.example.eshop.data.services;

import com.example.eshop.entities.Cart;

public interface CartService {

	Cart save(Cart cart);
	//int update(Cart cart);
	Cart findById(Integer id);
	void delete(Integer id);
}
