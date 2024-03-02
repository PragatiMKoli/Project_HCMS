package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.ExternalTrainers;
import com.amigos.entities.Roles;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ExternalTrainersDAOImpl implements ExternalTrainersDAO {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<ExternalTrainers> getAllExternalTrainerss() {

		return entityManager.unwrap(Session.class).createQuery("FROM ExternalTrainers").getResultList();
	}

	@Override
	public void addExternalTrainer(ExternalTrainers externalTrainers) {
		entityManager.unwrap(Session.class).saveOrUpdate(externalTrainers);
	}

	@Override
	public void updateExternalTrainer(ExternalTrainers externalTrainerst) {
		entityManager.unwrap(Session.class).update(externalTrainerst);
	}

	@Override
	public void deleteExternalTrainer(ExternalTrainers externalTrainers) {
		entityManager.unwrap(Session.class).delete(externalTrainers);
	}

	@Override
	public ExternalTrainers getExternalTrainerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
