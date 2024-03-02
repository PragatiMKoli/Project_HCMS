package com.amigos.dao;

import java.util.List;

import com.amigos.entities.EducationDetails;

public interface EducationDetailsDAO {
	
	List<EducationDetails> getAllEducationDetails();
	
	void addEducationDetail(EducationDetails educationDetails);
	
	void updateEducationDetail(EducationDetails educationDetails);
	
	void deleteEducationDetail(EducationDetails educationDetails);
	
	EducationDetails getEducationDetailById(int id);

}
