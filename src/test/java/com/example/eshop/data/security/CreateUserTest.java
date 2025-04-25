package com.example.eshop.data.security;

import com.example.eshop.beans.EntitiesGenerator;
import com.example.eshop.data.repositories.UserEntityRepository;
import com.example.eshop.data.services.UserEntityService;
import com.example.eshop.entities.UserEntity;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest(classes = {EntitiesGenerator.class})
public class CreateUserTest {
//	@Qualifier("userEntityService")
	@Autowired
	UserEntityRepository userEntityService;
	@Autowired
	List<UserEntity> entities;

	@Test
	void save() {
		userEntityService.save(entities.get(0));
	}
}
