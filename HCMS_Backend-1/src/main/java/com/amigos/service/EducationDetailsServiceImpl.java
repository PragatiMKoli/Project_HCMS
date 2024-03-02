package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.EducationDetailsDAO;
import com.amigos.dao.EmployeesDAO;
import com.amigos.entities.EducationDetails;
import com.amigos.entities.Employees;

@Service
public class EducationDetailsServiceImpl implements EducationDetailsService{

	@Autowired
	private EducationDetailsDAO educationDetailsDAO;

	@Override
	public List<EducationDetails> getAllEducationDetails() {
	
		return educationDetailsDAO.getAllEducationDetails();
	}

	@Override
	public void addEducationDetail(EducationDetails educationDetails) {
		educationDetailsDAO.addEducationDetail(educationDetails);
	}

	@Override
	public void updateEducationDetail(EducationDetails educationDetails) {
		educationDetailsDAO.updateEducationDetail(educationDetails);
	}

	@Override
	public void deleteEducationDetail(EducationDetails educationDetails) {
		educationDetailsDAO.deleteEducationDetail(educationDetails);
	}

	@Override
	public EducationDetails getEducationDetailById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
