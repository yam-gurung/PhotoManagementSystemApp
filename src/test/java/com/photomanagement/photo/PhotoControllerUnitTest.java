package com.photomanagement.photo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.photomanagement.dto.PaginatedResponse;
import com.photomanagement.dto.PersonDTO;
import com.photomanagement.model.Photo;
import com.photomanagement.service.PhotoService;

@WebMvcTest(PhotoController.class)
public class PhotoControllerUnitTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockitoBean
	private PhotoService photoService;
	
	@Test
	public void testtotalRecordsEndPoint() throws Exception {
		// mock the service layer
		when(photoService.getTotalRecords()).thenReturn(100);
		
		// perform the get request and assert the result
		
		mockMvc.perform(get("/api/persons/totalrecords"))
			.andExpect(status().isOk())
			.andExpect(content().string(is(String.valueOf(100))));
		
	}
	
	@Test
	public void getAllPersons_ReturnsListOfPersons() throws Exception {
		// create test data
		
		List<PersonDTO> persons=new ArrayList<>();

		
		Photo photo1=new Photo(
				1L,"yam","yam.jpg","3234djflskdjf023","printing","completed");
		Photo photo2=
				new Photo(
				2L,"shyam","shyam.jpg","3234djflskdjf023","printing","completed");
		List<Photo> photos=Arrays.asList(photo1,photo2);
		
		
		for(Photo photo:photos) {
			persons.add(new PersonDTO(photo.getPerson_name()
					,photo.getPhoto_id(),photo.getPhoto_path(),
					photo.getPhoto_service(),photo.getStatus()));
		}
		
		PaginatedResponse paginatedResponse=new PaginatedResponse();
		paginatedResponse.setPhotoDTOs(persons);
		paginatedResponse.setTotalRecords(2);
		// configure the mock service
		when(photoService.getAllPerson(10, 1)).thenReturn(paginatedResponse);
		
		// perform the GET request and assert the results
		mockMvc.perform(get("/api/persons")
				.param("size","10")
				.param("page","1")
				//.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.photoDTOs",hasSize(2)))
				.andExpect(jsonPath("$.totalRecords",is(2)))
				.andExpect(jsonPath("$.photoDTOs[0].name",is("yam")))
				.andExpect(jsonPath("$.photoDTOs[0].photoId",is("yam.jpg")))
				.andExpect(jsonPath("$.photoDTOs[1].name",is("shyam")));
				
	}
	
}
