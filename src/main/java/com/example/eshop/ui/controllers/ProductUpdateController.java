package com.example.eshop.ui.controllers;

import com.example.eshop.data.services.CategoryService;
import com.example.eshop.data.services.ProductService;
import com.example.eshop.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class ProductUpdateController {

	@Autowired
	private ProductService productService;

@Autowired
	private CategoryService categoryService;

/*	@GetMapping("/product-update")
	public String load(Model model, @RequestParam Integer productId){
		System.err.println(productId);
		try {
			productService.findById(productId).ifPresent(product -> {
				model.addAttribute("product", product);
			});

			return "product-update";
		}
		catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return "product-update";
	}*/

	@ModelAttribute("categories")
	public List<Category> categories() {
		return categoryService.findAll();
	}

	@GetMapping("/product-update")
	public String load(Model model){
		Integer productId = (Integer) model.getAttribute("productId");
		if(productId == null)
			return("redirect:products");

		try {
			productService.findById(productId).ifPresent(product -> {
				model.addAttribute("product", product);
			});
			return "product-update";
		} catch (Exception e) {
			return "error";
		}

		}

}
