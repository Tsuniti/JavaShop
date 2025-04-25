package com.example.eshop.ui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class WelcomeController {
	@GetMapping("/welcome") //адресс
	public String load() {
		return "welcome"; //название html
	}
}
