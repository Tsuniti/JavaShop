package com.example.eshop.data.repositories;

import com.example.eshop.beans.EntitiesGenerator;
import com.example.eshop.entities.Cart;
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

class CartRepositoryTest {


	@Autowired
	CartRepository cartRepository;

	@Autowired
	List<Cart> cartList;

	@BeforeEach
	void setUp() {
		Cart a = cartRepository.save(cartList.get(0));
		Cart b = cartRepository.save(cartList.get(1));

		assertNotNull(a);
		assertNotNull(b);
		assertEquals(cartList.get(0).getId(), a.getId());
		assertEquals(cartList.get(1).getId(), b.getId());
	}


	@Test
	void saveTest(){

	}

	@Test
	void findById(){
		Optional<Cart> optionalCart = cartRepository.findById(cartList.get(0).getId());
		assertTrue(optionalCart.isPresent());
		assertEquals(cartList.get(0).getId(), optionalCart.get().getId());
		assertDoesNotThrow( () -> {
			assertEquals(cartList.get(0).getId(), optionalCart.orElseThrow().getId());
		});
	}

	@Test
	void findAll(){
		List<Cart> findList = cartRepository.findAll();
		System.out.println(findList);
		assertNotEquals(0, findList.size());
		assertEquals(2, findList.size());
		assertIterableEquals(cartList, findList);
	}
	@Test
	void update(){
		cartList.get(0).setUpdatedAt(OffsetDateTime.now());
		Cart saved = cartRepository.save(cartList.get(0));
		assertNotNull(saved);
		assertEquals(cartList.get(0).getUpdatedAt(), saved.getUpdatedAt());
	}
	
}