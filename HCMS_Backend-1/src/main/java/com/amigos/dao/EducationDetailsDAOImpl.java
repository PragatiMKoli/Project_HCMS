package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.EducationDetails;
import com.amigos.entities.Roles;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EducationDetailsDAOImpl implements EducationDetailsDAO{
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<EducationDetails> getAllEducationDetails() {
		
		return entityManager.unwrap(Session.class).createQuery("from EducationDetails").getResultList();
	}

	@Override
	public void addEducationDetail(EducationDetails educationDetails) {
		entityManager.unwrap(Session.class).saveOrUpdate(educationDetails);
	}

	@Override
	public void updateEducationDetail(EducationDetails educationDetails) {
		entityManager.unwrap(Session.class).update(educationDetails);
	}

	@Override
	public void deleteEducationDetail(EducationDetails educationDetails) {
		entityManager.unwrap(Session.class).delete(educationDetails);
	}

	@Override
	public EducationDetails getEducationDetailById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
