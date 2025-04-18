package com.example.eshop.beans;

import com.example.eshop.entities.Product;
import com.example.eshop.entities.Review;
import com.example.eshop.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@TestConfiguration
public class EntitiesGenerator {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Lazy
	@Autowired
	PasswordEncoder passwordEncoder;


	@Scope("prototype")
	@Bean
	public UserEntity userEntity() {
		return new UserEntity(
				null,
				"a1",
				passwordEncoder.encode("a1"),
				UserEntity.Status.ACTIVE,
				UserEntity.Role.ADMIN,
				OffsetDateTime.now(),
				OffsetDateTime.now(),
				null,
				null
		);
	}

	@Scope("prototype")
	@Bean
	public List<UserEntity> userEntityList() {
		return new ArrayList<>(List.of(
				UserEntity.builder()
						.username("a")
						.passwordHash(passwordEncoder.encode("a"))
						.status(UserEntity.Status.ACTIVE)
						.role(UserEntity.Role.ADMIN)
						.createdAt(OffsetDateTime.now())
						.build()
				,
				UserEntity.builder()
						.username("b")
						.passwordHash(passwordEncoder.encode("b"))
						.status(UserEntity.Status.ACTIVE)
						.role(UserEntity.Role.USER)
						.createdAt(OffsetDateTime.now())
						.build()
		));
	}

	@Scope("prototype")
	@Bean
	public Review review() {
		return new Review(
				null,
				5,
				"review1",
				OffsetDateTime.now(),
				OffsetDateTime.now(),
				null,
				null
		);
	}

	@Scope("prototype")
	@Bean
	public List<Review> reviewList() {
		return new ArrayList<>(List.of(
				Review.builder()
						.text("reviewList1")
						.rating(4)
						.createdAt(OffsetDateTime.now())
						.build()
				,
				Review.builder()
						.text("reviewList2")
						.rating(3)
						.createdAt(OffsetDateTime.now())
						.build()
		));
	}

	@Scope("prototype")
	@Bean
	public Product product() {
		return new Product(
				null,
				"product1",
				"description",
				BigDecimal.valueOf(100),
				100,
				4,
				OffsetDateTime.now(),
				OffsetDateTime.now(),
				null,
				null,
				null,
				null
		);
	}

	@Scope("prototype")
	@Bean
	public List<Product> productList() {
		return new ArrayList<>(List.of(
				Product.builder()
						.name("productList1")
						.description("desc")
						.rating(4)
						.price(BigDecimal.valueOf(100))
						.quantity(100)
						.createdAt(OffsetDateTime.now())
						.build()
				,
				Product.builder()
						.name("productList2")
						.description("desc")
						.price(BigDecimal.valueOf(100))
						.rating(3)
						.quantity(100)
						.createdAt(OffsetDateTime.now())
						.build()
		));
	}

}


