package com.photomanagement.dto;

import java.util.List;

public class PaginatedResponse {
	public PaginatedResponse() {
		
	}
	
	private List<PersonDTO> photoDTOs;
	public List<PersonDTO> getPhotoDTOs() {
		return photoDTOs;
	}
	public void setPhotoDTOs(List<PersonDTO> photoDTOs) {
		this.photoDTOs = photoDTOs;
	}
	public Integer getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}

	private Integer totalRecords;
}
