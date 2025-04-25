package com.example.eshop.ui.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String load(@AuthenticationPrincipal UserDetails userDetails) {
		if (userDetails != null){
//Якщо користувач авторизований
			return "redirect:/products";
		}
//Якщо користувач не авторизований
		return "redirect:/welcome";
	}

}
