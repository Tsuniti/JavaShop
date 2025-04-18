package com.example.eshop.data.repositories;

import com.example.eshop.beans.EntitiesGenerator;
import com.example.eshop.entities.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {EntitiesGenerator.class})

@Transactional
class ProductRepositoryTest {


	@Autowired
	ProductRepository productRepository;

	@Autowired
	List<Product> productList;

	@BeforeEach
	void setUp() {
		Product a = productRepository.save(productList.get(0));
		Product b = productRepository.save(productList.get(1));

		assertNotNull(a);
		assertNotNull(b);
		assertEquals(productList.get(0).getId(), a.getId());
		assertEquals(productList.get(1).getId(), b.getId());
	}


	@Test
	void saveTest(){

	}

	@Test
	void findById(){
		Optional<Product> optionalProduct = productRepository.findById(productList.get(0).getId());
		assertTrue(optionalProduct.isPresent());
		assertEquals(productList.get(0).getId(), optionalProduct.get().getId());
		assertDoesNotThrow( () -> {
			assertEquals(productList.get(0).getId(), optionalProduct.orElseThrow().getId());
		});
	}

	@Test
	void findAll(){
		List<Product> findList = productRepository.findAll();
		System.out.println(findList);
		assertNotEquals(0, findList.size());
		assertEquals(2, findList.size());
		assertIterableEquals(productList, findList);
	}
	@Test
	void update(){
		productList.get(0).setName("aaa");
		Product saved = productRepository.save(productList.get(0));
		assertNotNull(saved);
		assertEquals(productList.get(0).getName(), saved.getName());
	}
}