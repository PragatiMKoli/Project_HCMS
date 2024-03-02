package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.EmployeesDAO;
import com.amigos.dao.TrainingModulesDAO;
import com.amigos.entities.Employees;
import com.amigos.entities.TrainingModules;

@Service
public class TrainingModulesServiceImpl implements TrainingModulesService{

	@Autowired
	private TrainingModulesDAO trainingModulesDAO;

	@Override
	public List<TrainingModules> getAllTrainingModules() {
		return trainingModulesDAO.getAllTrainingModules();
	}

	@Override
	public void addTrainingModule(TrainingModules trainingModules) {
		trainingModulesDAO.addTrainingModule(trainingModules);
	}

	@Override
	public void updateTrainingModule(TrainingModules trainingModules) {
		trainingModulesDAO.updateTrainingModule(trainingModules);
	}

	@Override
	public void deleteTrainingModule(TrainingModules trainingModules) {
		trainingModulesDAO.deleteTrainingModule(trainingModules);
	}

	@Override
	public TrainingModules getTrainingModuleById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
