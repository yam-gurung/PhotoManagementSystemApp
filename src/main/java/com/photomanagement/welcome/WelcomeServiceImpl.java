package com.photomanagement.welcome;

import org.springframework.stereotype.Service;

import com.photomanagement.service.WelcomeService;

@Service
public class WelcomeServiceImpl implements WelcomeService {

	@Override
	public String getWelcomeMessage(String name) {
		return "Welcome, "+name;
	}

}
