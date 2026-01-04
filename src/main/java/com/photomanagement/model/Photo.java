package com.photomanagement.model;

public class Photo {
	public Photo() {
	}
	public Photo(Long profile_id,String person_name,String photo_id,String photo_path,String photo_service,String status) {
		this.profile_id=profile_id;
		this.person_name=person_name;
		this.photo_id=photo_id;
		this.photo_path=photo_path;
		this.photo_service=photo_service;
		this.status=status;
	}
	
	private Long profile_id;
	private String person_name;
	private String photo_id;
	private String photo_path;
	private String photo_service;
	private String status;
	
	public Long getProfile_id() {
		return profile_id;
	}
	public void setProfile_id(Long profile_id) {
		this.profile_id = profile_id;
	}
	
	public String getPerson_name() {
		return person_name;
	}
	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}
	public String getPhoto_id() {
		return photo_id;
	}
	public void setPhoto_id(String photo_id) {
		this.photo_id = photo_id;
	}
	public String getPhoto_path() {
		return photo_path;
	}
	public void setPhoto_path(String photo_path) {
		this.photo_path = photo_path;
	}
	public String getPhoto_service() {
		return photo_service;
	}
	public void setPhoto_service(String photo_service) {
		this.photo_service = photo_service;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
