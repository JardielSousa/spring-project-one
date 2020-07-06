package com.jas.projectone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jas.projectone.dto.UserCredentialDto;
import com.jas.projectone.service.UserCredentialService;

@Controller
@RequestMapping("user")
public class UserCredentialController {
	
	@Autowired
	private UserCredentialService service;
	
	@GetMapping("register")
	public String newForm(UserCredentialDto userCredentialDto) {
		return "pages/auth/register";
	}

	@PostMapping
	public String create(UserCredentialDto userCredentialDto) {
		this.service.create(userCredentialDto);		
		return "redirect:/";
	}
}
