package com.photomanagement.dto;

public class PersonDTO {
	private String name;
	private String photoId;
	private String photoPath;
	private String photoService;
	private String status;
	
	public PersonDTO(String name,String photoId,String photoPath
			,String photoService,String status) {
		super();
		this.name = name;
		this.photoId=photoId;
		this.photoPath=photoPath;
		this.photoService=photoService;
		this.status=status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getPhotoService() {
		return photoService;
	}

	public void setPhotoService(String photoService) {
		this.photoService = photoService;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
