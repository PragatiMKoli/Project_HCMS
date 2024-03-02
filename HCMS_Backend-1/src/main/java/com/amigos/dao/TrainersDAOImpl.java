package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.Roles;
import com.amigos.entities.Trainers;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TrainersDAOImpl implements TrainersDAO {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Trainers> getAllTrainers() {
		return entityManager.unwrap(Session.class).createQuery("FROM Trainers").getResultList();
	}

	@Override
	public void addTrainer(Trainers trainers) {
		entityManager.unwrap(Session.class).saveOrUpdate(trainers);
	}

	@Override
	public void updateTrainer(Trainers trainers) {
		entityManager.unwrap(Session.class).update(trainers);
	}

	@Override
	public void deleteTrainer(Trainers trainers) {
		entityManager.unwrap(Session.class).delete(trainers);
	}

	@Override
	public Trainers getTrainerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
