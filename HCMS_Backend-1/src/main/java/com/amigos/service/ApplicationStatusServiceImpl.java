package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.ApplicationStatusDAO;
import com.amigos.dao.EmployeesDAO;
import com.amigos.entities.ApplicationStatus;
import com.amigos.entities.Employees;

@Service
public class ApplicationStatusServiceImpl implements ApplicationStatusService{

	@Autowired
	private ApplicationStatusDAO applicationStatusDAO;

	@Override
	public List<ApplicationStatus> getAllApplicationStatus() {
		
		return applicationStatusDAO.getAllApplicationStatus();
	}

	@Override
	public void addApplicationStatus(ApplicationStatus applicationStatus) {
		applicationStatusDAO.addApplicationStatus(applicationStatus);
	}

	@Override
	public void updateApplicationStatus(ApplicationStatus applicationStatus) {
		applicationStatusDAO.updateApplicationStatus(applicationStatus);
	}

	@Override
	public void deleteApplicationStatus(ApplicationStatus applicationStatus) {
		applicationStatusDAO.deleteApplicationStatus(applicationStatus);
	}

	@Override
	public ApplicationStatus getApplicationStatusById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}
