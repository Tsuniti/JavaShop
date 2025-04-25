package com.example.eshop.data.services.db;

import com.example.eshop.data.repositories.UserEntityRepository;
import com.example.eshop.data.services.UserEntityService;
import com.example.eshop.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserEntityServiceDb implements UserEntityService {
	@Autowired
	private UserEntityRepository userEntityRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserEntity save(UserEntity userEntity) {
		userEntity.setPasswordHash(passwordEncoder.encode(userEntity.getPasswordHash()));
		return userEntityRepository.save(userEntity);
	}
	@Override
	public UserEntity update(UserEntity userEntity) {
		userEntity.setPasswordHash(userEntity.getPasswordHash());
		return userEntityRepository.save(userEntity);
	}

	@Override
	public Boolean usernameExists(String username) {
		return userEntityRepository.existsByUsernameIgnoreCase(username);
	}

	@Override
	public UserEntity findByCredentials(String username, String passwordHash) {
		return userEntityRepository.findByUsernameIgnoreCaseAndPasswordHash(username, passwordHash);
	}

	@Override
	public List<UserEntity> findAll() {
		return userEntityRepository.findAll();
	}

	@Override
	public Optional<UserEntity> findById(Integer id) {
		return userEntityRepository.findById(id);
	}
}
