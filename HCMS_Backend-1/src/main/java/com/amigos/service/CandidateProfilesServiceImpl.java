package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.CandidateProfilesDAO;
import com.amigos.dao.EmployeesDAO;
import com.amigos.entities.CandidateProfiles;
import com.amigos.entities.Employees;

@Service
public class CandidateProfilesServiceImpl implements CandidateProfilesService{

	@Autowired
	private CandidateProfilesDAO candidateProfilesDAO;

	@Override
	public List<CandidateProfiles> getAllCandidateProfiles() {
		return candidateProfilesDAO.getAllCandidateProfiles();
	}

	@Override
	public void addCandidateProfile(CandidateProfiles candidateProfiles) {
		candidateProfilesDAO.addCandidateProfile(candidateProfiles);
	}

	@Override
	public void updateCandidateProfile(CandidateProfiles candidateProfiles) {
		candidateProfilesDAO.updateCandidateProfile(candidateProfiles);
	}

	@Override
	public void deleteCandidateProfile(CandidateProfiles candidateProfiles) {
		candidateProfilesDAO.deleteCandidateProfile(candidateProfiles);
	}

	@Override
	public CandidateProfiles getCandidateProfileById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	


	
}
