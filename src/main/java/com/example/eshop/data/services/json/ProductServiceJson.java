package com.example.eshop.data.services.json;

import com.example.eshop.data.services.ProductService;
import com.example.eshop.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceJson implements ProductService {
	private final String fileName = "products.json";

	@Override
	public Page<Product> findSome(int page, int quantity, Integer minPrice, Integer maxPrice, String sortBy, Boolean isAscending, String category, String name) {
		return null;
	}

	@Override
	public List<Product> findAll() {
		return List.of();
	}

	@Override
	public Product findById(int id) {
		return null;
	}

	@Override
	public Product save(Product product) {
		return null;
	}

	@Override
	public void delete(int id) {

	}
}
