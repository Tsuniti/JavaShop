package com.example.eshop.data.repositories;

import com.example.eshop.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {

	boolean existsByUsernameIgnoreCase(String username);

	UserEntity findByUsernameIgnoreCaseAndPasswordHash(String username, String passwordHash);
}