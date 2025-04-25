package com.example.eshop.data.repositories;

import com.example.eshop.beans.EntitiesGenerator;
import com.example.eshop.entities.CartItem;
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

class CartItemRepositoryTest {


	@Autowired
	CartItemRepository cartItemRepository;

	@Autowired
	List<CartItem> cartItemList;

	@BeforeEach
	void setUp() {
		CartItem a = cartItemRepository.save(cartItemList.get(0));
		CartItem b = cartItemRepository.save(cartItemList.get(1));

		assertNotNull(a);
		assertNotNull(b);
		assertEquals(cartItemList.get(0).getId(), a.getId());
		assertEquals(cartItemList.get(1).getId(), b.getId());
	}


	@Test
	void saveTest(){

	}

	@Test
	void findById(){
		Optional<CartItem> optionalCartItem = cartItemRepository.findById(cartItemList.get(0).getId());
		assertTrue(optionalCartItem.isPresent());
		assertEquals(cartItemList.get(0).getId(), optionalCartItem.get().getId());
		assertDoesNotThrow( () -> {
			assertEquals(cartItemList.get(0).getId(), optionalCartItem.orElseThrow().getId());
		});
	}

	@Test
	void findAll(){
		List<CartItem> findList = cartItemRepository.findAll();
		System.out.println(findList);
		assertNotEquals(0, findList.size());
		assertEquals(2, findList.size());
		assertIterableEquals(cartItemList, findList);
	}
	@Test
	void update(){
		cartItemList.get(0).setUpdatedAt(OffsetDateTime.now());
		CartItem saved = cartItemRepository.save(cartItemList.get(0));
		assertNotNull(saved);
		assertEquals(cartItemList.get(0).getUpdatedAt(), saved.getUpdatedAt());
	}
	
}