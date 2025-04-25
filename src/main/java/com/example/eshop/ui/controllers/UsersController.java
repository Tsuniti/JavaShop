package com.example.eshop.ui.controllers;

import com.example.eshop.data.services.CartService;
import com.example.eshop.data.services.UserEntityService;
import com.example.eshop.entities.Cart;
import com.example.eshop.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.OffsetDateTime;
import java.util.List;

@Controller
public class UsersController {
	@Autowired
	private UserEntityService userEntityService;

	@Autowired
	private CartService cartService;

	@GetMapping("/users" ) //адресс
	public String load() {
		return "users"; //название html
	}

	//@PostMapping("/users-form")
	public String usersForm1(@RequestParam("username" ) String login) {
		System.err.println(login);
		return "redirect:/users";
	}

	@ModelAttribute("userList")
	public List<UserEntity> userEntityList(){
		return userEntityService.findAll();
	}


	@Transactional
	@PostMapping("/users-form" )
	//public String usersForm2(@ModelAttribute ModelMap map){
	public String usersForm2(@ModelAttribute UserEntity userEntity) {
		System.err.println(userEntity);
		Cart newCart = new Cart();
		newCart.setUserEntity(userEntity);
		userEntity.setCart(newCart);
		userEntityService.save(userEntity);
		return "redirect:/users";
	}
//	@PostMapping("/userEntity-update" )
//	public String usersUpdateForm(@ModelAttribute UserEntity userEntity) {
//		System.err.println(userEntity);
//
//		if (userEntity.getPasswordHash() == null || userEntity.getPasswordHash().isBlank()) {
//			// Сохраняем старый пароль, если новый не указан
//			String oldPasswordHash = userEntityService.findById(userEntity.getId())
//					.orElseThrow()
//					.getPasswordHash();
//			userEntity.setPasswordHash(oldPasswordHash);
//		}
//
//
//		userEntity.setUpdatedAt(OffsetDateTime.now());
//		userEntityService.update(userEntity);
//		return "redirect:/users";
//	}

/*	@PostMapping("/user-update-redirect-form")
	public ModelAndView userUpdateRedirect(@RequestParam("userId") Integer userId) {
		return new ModelAndView("redirect:/user-update",
				new ModelMap("userId", userId));
	}*/

	@PostMapping("/user-update-redirect-form")
	public String userUpdateRedirect(
			@RequestParam("userId") Integer userId,
			RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("userId", userId);
		return "redirect:/user-update";
	}
}
