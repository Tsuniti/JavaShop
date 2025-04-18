package com.example.eshop.data.services;

import com.example.eshop.entities.Category;

import java.util.List;

public interface CategoryService {
	Category save(Category category);
//	int update(String name);
	List<Category> findAll();
	Category findById(int id);
	void delete(int id);
}
