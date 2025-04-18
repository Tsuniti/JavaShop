//package com.example.eshop.data.repositories;
//
//import com.example.eshop.beans.EntitiesGenerator;
//import com.example.eshop.entities.UserEntity;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@SpringBootTest(classes = {EntitiesGenerator.class})
//class UserEntityRepositoryOrdinalTest {
//
//	/*UserEntityRepository userEntityRepository;
//	@Autowired
//	public UserEntityRepositoryTest(UserEntityRepository userEntityRepository) {
//		this.userEntityRepository = userEntityRepository;
//	}*/
//
//	@Autowired
//	UserEntityRepository userEntityRepository;
//
//	/*@Autowired
//	UserEntity userEntity;*/
//
//	//@Qualifier("userEntity")
//	@Autowired
//	List<UserEntity> userEntityList;
//
///*	@BeforeEach
//	void setUp() {
//	}*/
//
//	@Order(1)
//	@Test
//	public void save(){
//		System.out.println(userEntityRepository);
//		//System.out.println(userEntity);
//
//		System.out.println(userEntityList);
//	}
//	@Order(2)
//	@Test
//	void findById(){
//		System.out.println("findById");
//	}
//}