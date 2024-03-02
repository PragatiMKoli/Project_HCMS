package com.amigos.dao;

import java.util.List;

import com.amigos.entities.CandidateProfiles;

public interface CandidateProfilesDAO {
	
	List<CandidateProfiles> getAllCandidateProfiles();
	
	void addCandidateProfile(CandidateProfiles candidateProfies);
	
	void updateCandidateProfile(CandidateProfiles candidateProfies);
	
	void deleteCandidateProfile(CandidateProfiles candidateProfies);
	
	CandidateProfiles getCandidateProfileById(int id);

}
