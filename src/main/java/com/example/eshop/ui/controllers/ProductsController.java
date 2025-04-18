package com.example.eshop.ui.controllers;


import com.example.eshop.data.repositories.CategoryRepository;
import com.example.eshop.data.repositories.ProductRepository;
import com.example.eshop.data.services.CategoryService;
import com.example.eshop.data.services.ProductService;
import com.example.eshop.entities.Cart;
import com.example.eshop.entities.Category;
import com.example.eshop.entities.Product;
import com.example.eshop.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductsController {
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/products") //адресс
	public String load() {
		return "products"; //название html
	}

	@ModelAttribute("productList")
	public List<Product> productList() {
		return productService.findAll();
	}

	@ModelAttribute("categories")
	public List<Category> categories() {
		return categoryService.findAll();
	}

	@PostMapping("products-form")
	public String productsForm(@ModelAttribute Product product) {
		System.err.println(product);
		productService.save(product);
		return "redirect:/products";
	}
	@PostMapping("/product-update")
	public String productsUpdate(@ModelAttribute Product product) {
		System.err.println(product);
		productService.save(product);
		return "redirect:/products";
	}
}

