package com.example.eshop.data.repositories;

import com.example.eshop.beans.EntitiesGenerator;
import com.example.eshop.entities.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {EntitiesGenerator.class})

@Transactional

class CategoryRepositoryTest {


	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	List<Category> categoryList;

	@BeforeEach
	void setUp() {
		Category a = categoryRepository.save(categoryList.get(0));
		Category b = categoryRepository.save(categoryList.get(1));

		assertNotNull(a);
		assertNotNull(b);
		assertEquals(categoryList.get(0).getId(), a.getId());
		assertEquals(categoryList.get(1).getId(), b.getId());
	}


	@Test
	void saveTest(){

	}

	@Test
	void findById(){
		Optional<Category> optionalCategory = categoryRepository.findById(categoryList.get(0).getId());
		assertTrue(optionalCategory.isPresent());
		assertEquals(categoryList.get(0).getId(), optionalCategory.get().getId());
		assertDoesNotThrow( () -> {
			assertEquals(categoryList.get(0).getId(), optionalCategory.orElseThrow().getId());
		});
	}

	@Test
	void findAll(){
		List<Category> findList = categoryRepository.findAll();
		System.out.println(findList);
		assertNotEquals(0, findList.size());
		assertEquals(2, findList.size());
		assertIterableEquals(categoryList, findList);
	}
	@Test
	void update(){
		categoryList.get(0).setUpdatedAt(OffsetDateTime.now());
		Category saved = categoryRepository.save(categoryList.get(0));
		assertNotNull(saved);
		assertEquals(categoryList.get(0).getUpdatedAt(), saved.getUpdatedAt());
	}
}