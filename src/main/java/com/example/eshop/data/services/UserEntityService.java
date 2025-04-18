package com.example.eshop.data.services;

import com.example.eshop.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserEntityService {
	UserEntity save(UserEntity userEntity);
	Boolean usernameExists(String username);
	UserEntity findByCredentials(String username, String passwordHash);
	List<UserEntity> findAll();
	UserEntity findById(Integer id);
}
