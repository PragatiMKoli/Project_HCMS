package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.Certifications;
import com.amigos.entities.Roles;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CertificationsDAOImpl implements CertificationsDAO {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Certifications> getAllCertifications() {
		return entityManager.unwrap(Session.class).createQuery("From Certifications").getResultList();
	}

	@Override
	public void addCertification(Certifications certifications) {
		entityManager.unwrap(Session.class).saveOrUpdate(certifications);
	}

	@Override
	public void updateCertification(Certifications certifications) {
		entityManager.unwrap(Session.class).update(certifications);
	}

	@Override
	public void deleteCertification(Certifications certifications) {
	    entityManager.unwrap(Session.class).delete(certifications);
	}

	@Override
	public Certifications getCertificationById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
