package com.example.eshop.data.services;

import com.example.eshop.data.services.qualifiers.ProductServiceDbQualifier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {

	//@Qualifier("productServiceDb")
	@ProductServiceDbQualifier
	@Autowired
	private ProductService productService;

	@Test
	void save(){
		System.out.println(productService);
	}
}
