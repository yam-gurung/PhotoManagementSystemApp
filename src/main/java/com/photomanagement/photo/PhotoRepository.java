package com.photomanagement.photo;

import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.photomanagement.model.Photo;
import org.springframework.jdbc.core.RowMapper;

@Repository
public class PhotoRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Photo> findAll(int pageSize,int currentPage){
		String sqlQuery="select * from person_profile order by profile_id asc limit ? offset ?";
		return jdbcTemplate.query(sqlQuery,photoRowMapper(),pageSize,(currentPage-1)*pageSize);
	}
	
	public int getTotalRecords() {
		String sql="select count(*) from person_profile";
		Integer totalRecords=jdbcTemplate.queryForObject(sql, Integer.class);
		return totalRecords;
	}
	
	
	private RowMapper<Photo> photoRowMapper(){
		return (rs,rowNum)->{
			Photo photo = new Photo();
			photo.setProfile_id(rs.getLong("profile_id"));
			photo.setPerson_name(rs.getString("person_name"));
			photo.setPhoto_id(rs.getString("photo_id"));
			photo.setPhoto_path(rs.getString("photo_path"));
			photo.setPhoto_service(rs.getString("photo_service"));
			photo.setStatus(rs.getString("status"));
			return photo;
		};
	}

}
