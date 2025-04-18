package com.example.eshop.data.services;

import com.example.eshop.entities.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
	Page<Product> findSome(int page,
						   int quantity,
						   Integer minPrice,
						   Integer maxPrice,
						   String sortBy,
						   Boolean isAscending,
						   String category,
						   String name);
	List<Product> findAll();
	Product findById(int id);
	Product save(Product product);
	//Product update(Product product);
	void delete(int id);

}
