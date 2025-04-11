package com.example.eshop.data.repositories;

import com.example.eshop.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Page<Product> findByPriceBetweenAndCategory_NameIgnoreCaseAndNameContainsIgnoreCase(BigDecimal priceStart, BigDecimal priceEnd, String name, String name1, Pageable pageable);
}