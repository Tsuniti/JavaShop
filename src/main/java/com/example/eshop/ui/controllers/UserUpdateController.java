package com.example.eshop.ui.controllers;

import com.example.eshop.data.services.UserEntityService;
import com.example.eshop.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserUpdateController {

	@Autowired
	private UserEntityService userEntityService;

/*	@GetMapping("/user-update")
	public String load(Model model, @RequestParam Integer userId){
		System.err.println(userId);
		try {
			userEntityService.findById(userId).ifPresent(userEntity -> {
				model.addAttribute("user", userEntity);
			});

			return "user-update";
		}
		catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return "user-update";
	}*/

	@GetMapping("/user-update")
	public String load(Model model){
		Integer userId = (Integer) model.getAttribute("userId");
		if(userId == null)
			return("redirect:users");

		try {
			userEntityService.findById(userId).ifPresent(userEntity -> {
				model.addAttribute("user", userEntity);
			});
			return "user-update";
		} catch (Exception e) {
			return "error";
		}

		}

}
