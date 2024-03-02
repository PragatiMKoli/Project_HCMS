package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.ApplicationStatus;
import com.amigos.entities.Roles;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ApplicationStatusDAOImpl implements ApplicationStatusDAO {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<ApplicationStatus> getAllApplicationStatus() {
		
		return entityManager.unwrap(Session.class).createQuery("from ApplicationStatus").getResultList();
	}

	@Override
	public void addApplicationStatus(ApplicationStatus applicationStatus) {
		entityManager.unwrap(Session.class).saveOrUpdate(applicationStatus);
	}

	@Override
	public void updateApplicationStatus(ApplicationStatus applicationStatus) {
		entityManager.unwrap(Session.class).update(applicationStatus);
	}

	@Override
	public void deleteApplicationStatus(ApplicationStatus applicationStatus) {
		entityManager.unwrap(Session.class).delete(applicationStatus);
	}

	@Override
	public ApplicationStatus getApplicationStatusById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
