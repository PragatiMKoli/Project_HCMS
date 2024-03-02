package com.amigos.service;

import java.util.List;

import com.amigos.entities.CandidateProfiles;

public interface CandidateProfilesService {

List<CandidateProfiles> getAllCandidateProfiles();
	
	void addCandidateProfile(CandidateProfiles candidateProfiles);
	
	void updateCandidateProfile(CandidateProfiles candidateProfiles);
	
	void deleteCandidateProfile(CandidateProfiles candidateProfiles);
	
	CandidateProfiles getCandidateProfileById(int id);
}
