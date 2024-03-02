package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.EmployeesDAO;
import com.amigos.dao.ExternalTrainersDAO;
import com.amigos.entities.Employees;
import com.amigos.entities.ExternalTrainers;

@Service
public class ExternalTrainersServiceImpl implements ExternalTrainersService{

	@Autowired
	private ExternalTrainersDAO externalTrainersDAO;

	@Override
	public List<ExternalTrainers> getAllExternalTrainers() {
		return externalTrainersDAO.getAllExternalTrainerss();
	}

	@Override
	public void addExternalTrainer(ExternalTrainers externalTrainers) {
		externalTrainersDAO.addExternalTrainer(externalTrainers);
	}

	@Override
	public void updateExternalTrainer(ExternalTrainers externalTrainers) {
		externalTrainersDAO.updateExternalTrainer(externalTrainers);
	}

	@Override
	public void deleteExternalTrainer(ExternalTrainers externalTrainers) {
		externalTrainersDAO.deleteExternalTrainer(externalTrainers);
	}

	@Override
	public ExternalTrainers getExternalTrainerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
