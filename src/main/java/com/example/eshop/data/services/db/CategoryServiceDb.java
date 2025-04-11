package com.example.eshop.data.services.db;

import com.example.eshop.data.repositories.CategoryRepository;
import com.example.eshop.data.services.CategoryService;
import com.example.eshop.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceDb implements CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findById(Integer id) {
		return categoryRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		categoryRepository.deleteById(id);
	}
}
