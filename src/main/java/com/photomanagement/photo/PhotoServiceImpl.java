package com.photomanagement.photo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.photomanagement.dto.PaginatedResponse;
import com.photomanagement.dto.PersonDTO;
import com.photomanagement.model.Photo;
import com.photomanagement.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PhotoServiceImpl implements PhotoService {

	@Autowired
	private PhotoRepository photoRepository;
	
	@Override
	public PaginatedResponse getAllPerson(int pageSize,int currentPage) {
		
		List<PersonDTO> persons=new ArrayList<>();
		List<Photo> photos=photoRepository.findAll(pageSize,currentPage);
		for(Photo photo:photos) {
			persons.add(new PersonDTO(photo.getPerson_name()
					,photo.getPhoto_id(),photo.getPhoto_path()
					,photo.getPhoto_service(),photo.getStatus()));
		}
		
		PaginatedResponse paginatedResponse=new PaginatedResponse();
		paginatedResponse.setPhotoDTOs(persons);
		paginatedResponse.setTotalRecords(this.photoRepository.getTotalRecords());
		return paginatedResponse;
	}

	@Override
	public Integer getTotalRecords() {
		return photoRepository.getTotalRecords();
	}

}
