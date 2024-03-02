package com.amigos.service;

import java.util.List;

import com.amigos.entities.TrainingModules;

public interface TrainingModulesService {

List<TrainingModules> getAllTrainingModules();
	
	void addTrainingModule(TrainingModules trainingModules);
	
	void updateTrainingModule(TrainingModules trainingModules);
	
	void deleteTrainingModule(TrainingModules trainingModules);
	
	TrainingModules getTrainingModuleById(int id);
}
