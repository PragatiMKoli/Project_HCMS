package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.Roles;
import com.amigos.entities.TrainingSchedules;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TrainingSchedulesDAOImpl implements TrainingSchedulesDAO {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<TrainingSchedules> getAllTrainingSchedules() {
		return entityManager.unwrap(Session.class).createQuery("FROM TrainingSchedules").getResultList();
	}

	@Override
	public void addTrainingSchedule(TrainingSchedules trainingSchedules) {
		entityManager.unwrap(Session.class).saveOrUpdate(trainingSchedules);
	}

	@Override
	public void updateTrainingSchedule(TrainingSchedules trainingSchedules) {
		entityManager.unwrap(Session.class).update(trainingSchedules);
	}

	@Override
	public void deleteTrainingSchedule(TrainingSchedules trainingSchedules) {
		entityManager.unwrap(Session.class).delete(trainingSchedules);		
	}

	@Override
	public TrainingSchedules getTrainingScheduleById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
