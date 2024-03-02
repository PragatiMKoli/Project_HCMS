package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.Roles;
import com.amigos.entities.TrainingModules;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TrainingModulesDAOImpl implements TrainingModulesDAO{
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<TrainingModules> getAllTrainingModules() {
		
		return entityManager.unwrap(Session.class).createQuery("FROM TrainingModules").getResultList();
	}

	@Override
	public void addTrainingModule(TrainingModules trainingModules) {
		entityManager.unwrap(Session.class).saveOrUpdate(trainingModules);
	}

	@Override
	public void updateTrainingModule(TrainingModules trainingModules) {
		entityManager.unwrap(Session.class).update(trainingModules);
	}

	@Override
	public void deleteTrainingModule(TrainingModules trainingModules) {
		entityManager.unwrap(Session.class).delete(trainingModules);
	}

	@Override
	public TrainingModules getTrainingModuleById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
