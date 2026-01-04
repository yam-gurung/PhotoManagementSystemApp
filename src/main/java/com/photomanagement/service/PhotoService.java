package com.photomanagement.service;
import com.photomanagement.dto.PaginatedResponse;

public interface PhotoService {
	PaginatedResponse getAllPerson(int pageSize,int currentPage);
	Integer getTotalRecords();
}
