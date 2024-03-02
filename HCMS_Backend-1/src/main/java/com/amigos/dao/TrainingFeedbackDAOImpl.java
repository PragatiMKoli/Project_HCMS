package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.Roles;
import com.amigos.entities.TrainingFeedback;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TrainingFeedbackDAOImpl implements TrainingFeedbackDAO {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<TrainingFeedback> getAllTrainingFeedback() {
		return entityManager.unwrap(Session.class).createQuery("FROM TrainingFeedback").getResultList();
	}

	@Override
	public void addTrainingFeedback(TrainingFeedback trainingFeedback) {
		entityManager.unwrap(Session.class).saveOrUpdate(trainingFeedback);
	}

	@Override
	public void updateTrainingFeedback(TrainingFeedback trainingFeedback) {
		entityManager.unwrap(Session.class).update(trainingFeedback);
	}

	@Override
	public void deleteTrainingFeedback(TrainingFeedback trainingFeedback) {
		entityManager.unwrap(Session.class).delete(trainingFeedback);
	}

	@Override
	public TrainingFeedback getTrainingFeedbackById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
