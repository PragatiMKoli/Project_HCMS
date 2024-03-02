package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.CandidateProfiles;
import com.amigos.entities.Roles;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CandidateProfilesDAOImpl implements CandidateProfilesDAO {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<CandidateProfiles> getAllCandidateProfiles() {
	
		return entityManager.unwrap(Session.class).createQuery("From CandidateProfiles").getResultList();
	}

	@Override
	public void addCandidateProfile(CandidateProfiles candidateProfies) {
		entityManager.unwrap(Session.class).saveOrUpdate(candidateProfies);
	}

	@Override
	public void updateCandidateProfile(CandidateProfiles candidateProfies) {
		entityManager.unwrap(Session.class).update(candidateProfies);
	}

	@Override
	public void deleteCandidateProfile(CandidateProfiles candidateProfies) {
		entityManager.unwrap(Session.class).delete(candidateProfies);
	}

	@Override
	public CandidateProfiles getCandidateProfileById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
