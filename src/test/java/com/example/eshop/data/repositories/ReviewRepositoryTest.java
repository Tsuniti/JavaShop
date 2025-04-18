package com.example.eshop.data.repositories;

import com.example.eshop.beans.EntitiesGenerator;
import com.example.eshop.entities.Review;
import lombok.ToString;
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
class ReviewRepositoryTest {

	@Autowired
	ReviewRepository reviewRepository;

	@Autowired
	List<Review> reviewList;
	
	@BeforeEach
	void setUp() {
		Review a = reviewRepository.save(reviewList.get(0));
		Review b = reviewRepository.save(reviewList.get(1));

		assertNotNull(a);
		assertNotNull(b);
		assertEquals(reviewList.get(0).getId(), a.getId());
		assertEquals(reviewList.get(1).getId(), b.getId());
	}


	@Test
	void saveTest(){

	}

	@Test
	void findById(){
		Optional<Review> optionalReview = reviewRepository.findById(reviewList.get(0).getId());
		assertTrue(optionalReview.isPresent());
		assertEquals(reviewList.get(0).getId(), optionalReview.get().getId());
		assertDoesNotThrow( () -> {
			assertEquals(reviewList.get(0).getId(), optionalReview.orElseThrow().getId());
		});
	}

	@Test
	void findAll(){
		List<Review> findList = reviewRepository.findAll();
		System.out.println(findList);
		assertNotEquals(0, findList.size());
		assertEquals(2, findList.size());
		assertIterableEquals(reviewList, findList);
	}
	@Test
	void update(){
		reviewList.get(0).setText("aaa");
		Review saved = reviewRepository.save(reviewList.get(0));
		assertNotNull(saved);
		assertEquals(reviewList.get(0).getText(), saved.getText());
	}
	
}