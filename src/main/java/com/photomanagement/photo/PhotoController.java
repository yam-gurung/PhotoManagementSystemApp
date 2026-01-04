package com.photomanagement.photo;
import com.photomanagement.dto.PaginatedResponse;
import com.photomanagement.service.PhotoService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PhotoController {

	private final PhotoService photoService;
	
	@Autowired
	public PhotoController(PhotoService photoService) {
		this.photoService = photoService;
	}
	
	@GetMapping("/api/persons")
	public PaginatedResponse getAllPersons(@RequestParam(defaultValue="1") int page,
			@RequestParam(defaultValue="10") int size) {
		System.out.println("called pageSize: "+size+" currentPage: "+page);

		PaginatedResponse paginatedResponse= this.photoService.getAllPerson(size, page);
		
		return paginatedResponse;
	}
	
	@GetMapping("/api/persons/totalrecords")
	public Integer totalRecords() {
		return this.photoService.getTotalRecords();
	}
	
}
