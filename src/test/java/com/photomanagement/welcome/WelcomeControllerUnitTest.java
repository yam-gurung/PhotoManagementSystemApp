package com.photomanagement.welcome;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.photomanagement.service.WelcomeService;

@WebMvcTest(WelcomeController.class)
public class WelcomeControllerUnitTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockitoBean
	private WelcomeService welcomeService;
	
	@Test
	public void testWelcomeEndpoint() throws Exception {
		// mock the behavior of server layer
		when(welcomeService.getWelcomeMessage("John")).thenReturn("Welcome, John");
		
		//perform the get request and assert the results
		mockMvc.perform(get("/welcome").param("name", "John"))
			.andExpect(status().isOk())
			.andExpect(content().string("Welcome, John"));
	}
	
	@Test
	public void testWelcomeWithoutName() throws Exception {
		//mock the default behavior
		when(welcomeService.getWelcomeMessage("stranger")).thenReturn("Welcome, stranger");
		
		//perform a GET request without parameters
		mockMvc.perform(get("/welcome"))
			.andExpect(status().isOk())
			.andExpect(content().string("Welcome, stranger"));
	}
	
	
}
