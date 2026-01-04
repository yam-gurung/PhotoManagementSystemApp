package com.photomanagement.welcome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.photomanagement.service.WelcomeService;

@RestController
public class WelcomeController {
	private final WelcomeService welcomeService;

	@Autowired
	public WelcomeController(WelcomeService welcomeService) {
		this.welcomeService = welcomeService;
	}
	
	
	@GetMapping("/welcome")
	public String welcome(@RequestParam(defaultValue="stranger")
						String name) {
		return this.welcomeService.getWelcomeMessage(name);
	}
	
}
