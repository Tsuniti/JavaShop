package com.example.eshop.data.services.db;

import com.example.eshop.data.repositories.ProductRepository;
import com.example.eshop.data.services.ProductService;
import com.example.eshop.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductServiceDb implements ProductService {
	@Autowired
	ProductRepository productRepository;

	@Override
	public Page<Product> findSome(int page,
								  int quantity,
								  Integer minPrice,
								  Integer maxPrice,
								  String sortBy,
								  Boolean isAscending,
								  String category,
								  String name)
	{
		Sort.Direction direction = isAscending ? Sort.Direction.ASC : Sort.Direction.DESC;
		Pageable pageable = PageRequest.of(page, quantity, Sort.by(direction, sortBy));

		return productRepository.findByPriceBetweenAndCategory_NameIgnoreCaseAndNameContainsIgnoreCase(
				BigDecimal.valueOf(minPrice),
				BigDecimal.valueOf(maxPrice),
				category,
				name,
				pageable);
	}

	@Override
	public Product findById(Integer id) {
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void delete(Integer id) {
		productRepository.deleteById(id);
	}
}
