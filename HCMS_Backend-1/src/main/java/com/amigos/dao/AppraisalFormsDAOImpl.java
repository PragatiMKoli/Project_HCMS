package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.AppraisalForms;
import com.amigos.entities.Roles;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AppraisalFormsDAOImpl implements AppraisalFormsDAO {
	@Autowired
	private EntityManager entityManager;

	
	@Override
	public List<AppraisalForms> getAllAppraisalForms() {
		return entityManager.unwrap(Session.class).createQuery("From AppraisalForms").getResultList();
	}

	@Override
	public void addAppraisalForms(AppraisalForms appraisalForms) {
		entityManager.unwrap(Session.class).saveOrUpdate(appraisalForms);
	}

	@Override
	public void updateAppraisalForms(AppraisalForms appraisalForms) {
		entityManager.unwrap(Session.class).update(appraisalForms);
	}

	@Override
	public void deleteAppraisalForms(AppraisalForms appraisalForms) {
		entityManager.unwrap(Session.class).delete(appraisalForms);
	}

	@Override
	public AppraisalForms getAppraisalFormsById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
