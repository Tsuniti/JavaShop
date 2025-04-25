package com.example.eshop.data.repositories;

import com.example.eshop.beans.EntitiesGenerator;
import com.example.eshop.entities.Image;
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

class ImageRepositoryTest {

	@Autowired
	ImageRepository imageRepository;

	@Autowired
	List<Image> imageList;

	@BeforeEach
	void setUp() {
		Image a = imageRepository.save(imageList.get(0));
		Image b = imageRepository.save(imageList.get(1));

		assertNotNull(a);
		assertNotNull(b);
		assertEquals(imageList.get(0).getId(), a.getId());
		assertEquals(imageList.get(1).getId(), b.getId());
	}


	@Test
	void saveTest(){

	}

	@Test
	void findById(){
		Optional<Image> optionalImage = imageRepository.findById(imageList.get(0).getId());
		assertTrue(optionalImage.isPresent());
		assertEquals(imageList.get(0).getId(), optionalImage.get().getId());
		assertDoesNotThrow( () -> {
			assertEquals(imageList.get(0).getId(), optionalImage.orElseThrow().getId());
		});
	}

	@Test
	void findAll(){
		List<Image> findList = imageRepository.findAll();
		System.out.println(findList);
		assertNotEquals(0, findList.size());
		assertEquals(2, findList.size());
		assertIterableEquals(imageList, findList);
	}
	@Test
	void update(){
		imageList.get(0).setUpdatedAt(OffsetDateTime.now());
		Image saved = imageRepository.save(imageList.get(0));
		assertNotNull(saved);
		assertEquals(imageList.get(0).getUpdatedAt(), saved.getUpdatedAt());
	}
}