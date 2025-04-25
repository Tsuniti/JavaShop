package com.example.eshop.data.repositories;

import com.example.eshop.beans.EntitiesGenerator;
import com.example.eshop.entities.UserEntity;
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
class UserEntityRepositoryTest {

	@Autowired
	UserEntityRepository userEntityRepository;

	@Autowired
	List<UserEntity> userEntityList;


	@BeforeEach
	void setUp() {
		UserEntity a = userEntityRepository.save(userEntityList.get(0));
		UserEntity b = userEntityRepository.save(userEntityList.get(1));

		assertNotNull(a);
		assertNotNull(b);
		assertEquals(userEntityList.get(0).getId(), a.getId());
		assertEquals(userEntityList.get(1).getId(), b.getId());
	}

	@Test
	void existsByUsernameIgnoreCase() {
	}

	@Test
	void findByUsernameIgnoreCaseAndPasswordHash() {
	}

	@Test
	void saveTest(){

	}
	@Test
	void findById(){
		Optional<UserEntity> optionalUserEntity = userEntityRepository.findById(userEntityList.get(0).getId());
		assertTrue(optionalUserEntity.isPresent());
		//assertEquals(userEntityList.get(0).getId(), optionalUserEntity.get().getId());
		assertDoesNotThrow( () -> {
			assertEquals(userEntityList.get(0).getId(), optionalUserEntity.orElseThrow().getId());
		});
	}

	@Test
	void findAll(){
		List<UserEntity> findList = userEntityRepository.findAll();
		System.out.println(findList);
		assertNotEquals(0, findList.size());
		assertEquals(2, findList.size());
		assertIterableEquals(userEntityList, findList);
	}
	@Test
	void update(){
		userEntityList.get(0).setUsername("aaa");
		UserEntity saved = userEntityRepository.save(userEntityList.get(0));
		assertNotNull(saved);
		assertEquals(userEntityList.get(0).getUsername(), saved.getUsername());
	}
}