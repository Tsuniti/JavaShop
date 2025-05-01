package com.example.eshop.ui.controllers;

import com.example.eshop.data.services.CartService;
import com.example.eshop.data.services.UserEntityService;
import com.example.eshop.entities.Cart;
import com.example.eshop.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserRegisterController {

	@Autowired
	private UserEntityService userEntityService;

	@Autowired
	private CartService cartService;

	@GetMapping("/register") //адресс
	public String load() {
		return "register"; //название html
	}

	@PostMapping("/register-form")
	public String registerForm(@ModelAttribute UserEntity userEntity)
	{
		System.err.println(userEntity);
		Cart newCart = new Cart();
		newCart.setUserEntity(userEntity);
		userEntity.setCart(newCart);
		userEntityService.save(userEntity);

		return "redirect:/products";

	}
}
