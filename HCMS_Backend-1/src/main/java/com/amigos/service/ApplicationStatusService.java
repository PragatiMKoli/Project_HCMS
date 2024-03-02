package com.amigos.service;

import java.util.List;

import com.amigos.entities.ApplicationStatus;

public interface ApplicationStatusService {

List<ApplicationStatus> getAllApplicationStatus();
	
	void addApplicationStatus(ApplicationStatus applicationStatus);
	
	void updateApplicationStatus(ApplicationStatus applicationStatus);
	
	void deleteApplicationStatus(ApplicationStatus applicationStatus);
	
	ApplicationStatus getApplicationStatusById(int id);
}
