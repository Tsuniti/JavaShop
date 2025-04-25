package com.example.eshop.ui.restcontrollers;

import com.example.eshop.data.services.UserEntityService;
import com.example.eshop.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
public class UserUpdateRestController {
	@Autowired
	private UserEntityService userEntityService;

	@PostMapping("/rest/user-update-form")
	public ResponseEntity<?> userUpdate(@RequestBody UserEntity userEntity){
		try	{
			System.err.println(userEntity);

			userEntityService.findById(userEntity.getId()).ifPresent( userDb ->{
				userEntity.setPasswordHash(userDb.getPasswordHash());
				userEntity.setUpdatedAt(OffsetDateTime.now());
				userEntityService.update(userEntity);
			});
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
