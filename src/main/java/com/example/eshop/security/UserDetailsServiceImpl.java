package com.example.eshop.security;

import com.example.eshop.data.repositories.UserEntityRepository;
import com.example.eshop.data.services.UserEntityService;
import com.example.eshop.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserEntityRepository userEntityRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> optionalUserEntity =  userEntityRepository.findByUsernameIgnoreCase(username);
		if (optionalUserEntity.isPresent())
			return new UserDetailsImpl(optionalUserEntity.get());
		System.err.println("User not found!");
		throw new UsernameNotFoundException("User not found!");
	}
}
