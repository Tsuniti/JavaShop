package com.example.eshop.data.repositories;

import com.example.eshop.beans.EntitiesGenerator;
import com.example.eshop.entities.Order;
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

class OrderRepositoryTest {


	@Autowired
	OrderRepository orderRepository;

	@Autowired
	List<Order> orderList;

	@BeforeEach
	void setUp() {
		Order a = orderRepository.save(orderList.get(0));
		Order b = orderRepository.save(orderList.get(1));

		assertNotNull(a);
		assertNotNull(b);
		assertEquals(orderList.get(0).getId(), a.getId());
		assertEquals(orderList.get(1).getId(), b.getId());
	}


	@Test
	void saveTest(){

	}

	@Test
	void findById(){
		Optional<Order> optionalOrder = orderRepository.findById(orderList.get(0).getId());
		assertTrue(optionalOrder.isPresent());
		assertEquals(orderList.get(0).getId(), optionalOrder.get().getId());
		assertDoesNotThrow( () -> {
			assertEquals(orderList.get(0).getId(), optionalOrder.orElseThrow().getId());
		});
	}

	@Test
	void findAll(){
		List<Order> findList = orderRepository.findAll();
		System.out.println(findList);
		assertNotEquals(0, findList.size());
		assertEquals(2, findList.size());
		assertIterableEquals(orderList, findList);
	}
	@Test
	void update(){
		orderList.get(0).setUpdatedAt(OffsetDateTime.now());
		Order saved = orderRepository.save(orderList.get(0));
		assertNotNull(saved);
		assertEquals(orderList.get(0).getUpdatedAt(), saved.getUpdatedAt());
	}
}