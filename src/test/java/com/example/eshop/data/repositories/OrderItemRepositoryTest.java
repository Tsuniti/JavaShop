package com.example.eshop.data.repositories;

import com.example.eshop.beans.EntitiesGenerator;
import com.example.eshop.entities.OrderItem;
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

class OrderItemItemRepositoryTest {


	@Autowired
	OrderItemRepository orderItemRepository;

	@Autowired
	List<OrderItem> orderItemList;

	@BeforeEach
	void setUp() {
		OrderItem a = orderItemRepository.save(orderItemList.get(0));
		OrderItem b = orderItemRepository.save(orderItemList.get(1));

		assertNotNull(a);
		assertNotNull(b);
		assertEquals(orderItemList.get(0).getId(), a.getId());
		assertEquals(orderItemList.get(1).getId(), b.getId());
	}


	@Test
	void saveTest(){

	}

	@Test
	void findById(){
		Optional<OrderItem> optionalOrderItem = orderItemRepository.findById(orderItemList.get(0).getId());
		assertTrue(optionalOrderItem.isPresent());
		assertEquals(orderItemList.get(0).getId(), optionalOrderItem.get().getId());
		assertDoesNotThrow( () -> {
			assertEquals(orderItemList.get(0).getId(), optionalOrderItem.orElseThrow().getId());
		});
	}

	@Test
	void findAll(){
		List<OrderItem> findList = orderItemRepository.findAll();
		System.out.println(findList);
		assertNotEquals(0, findList.size());
		assertEquals(2, findList.size());
		assertIterableEquals(orderItemList, findList);
	}
	@Test
	void update(){
		orderItemList.get(0).setUpdatedAt(OffsetDateTime.now());
		OrderItem saved = orderItemRepository.save(orderItemList.get(0));
		assertNotNull(saved);
		assertEquals(orderItemList.get(0).getUpdatedAt(), saved.getUpdatedAt());
	}
}