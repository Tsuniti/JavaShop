package com.example.eshop.ui.controllers;



import com.example.eshop.data.services.CategoryService;

import com.example.eshop.entities.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.OffsetDateTime;
import java.util.List;

@Controller
public class CategoriesController {

	@Autowired
	private CategoryService categoryService;


	@GetMapping("/categories") //адресс
	public String load() {
		return "categories"; //название html
	}

	@ModelAttribute("categories")
	public List<Category> categories() {
		return categoryService.findAll();
	}

	@PostMapping("categories-form")
	public String categoriesForm(@ModelAttribute Category category) {
		System.err.println(category);
		categoryService.save(category);
		return "redirect:/categories";
	}

	@PostMapping("/category-update")
	public String categoriesUpdate(@ModelAttribute Category category) {
		System.err.println(category);
		category.setUpdatedAt(OffsetDateTime.now());
		categoryService.save(category);
		return "redirect:/categories";
	}
}

