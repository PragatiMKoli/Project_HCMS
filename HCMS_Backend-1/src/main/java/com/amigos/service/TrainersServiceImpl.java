package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.EmployeesDAO;
import com.amigos.dao.TrainersDAO;
import com.amigos.entities.Employees;
import com.amigos.entities.Trainers;

@Service
public class TrainersServiceImpl implements TrainersService {

	@Autowired
	private TrainersDAO trainersDAO;

	@Override
	public List<Trainers> getAllTrainers() {
		return trainersDAO.getAllTrainers();
	}

	@Override
	public void addTrainer(Trainers trainers) {
		trainersDAO.addTrainer(trainers);
	}

	@Override
	public void updateTrainer(Trainers trainers) {
		trainersDAO.updateTrainer(trainers);
	}

	@Override
	public void deleteTrainer(Trainers trainers) {
		trainersDAO.deleteTrainer(trainers);
	}

	@Override
	public Trainers getTrainerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
