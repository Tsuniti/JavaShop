package com.example.eshop.ui.controllers;


import com.example.eshop.data.services.CategoryService;
import com.example.eshop.data.services.ProductService;
import com.example.eshop.data.services.qualifiers.ProductServiceDbQualifier;
import com.example.eshop.entities.Category;
import com.example.eshop.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.OffsetDateTime;
import java.util.List;

@Controller
public class ProductsController {

	//@Qualifier("productServiceDb")
	@ProductServiceDbQualifier
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
//	@PostMapping("/product-update")
//	public String productsUpdate(@ModelAttribute Product product) {
//		System.err.println(product);
//		product.setUpdatedAt(OffsetDateTime.now());
//		productService.save(product);
//		return "redirect:/products";
//	}

	@PostMapping("/product-update-redirect-form")
	public String productUpdateRedirect(
			@RequestParam("productId") Integer productId,
			RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("productId", productId);
		return "redirect:/product-update";
	}
}

