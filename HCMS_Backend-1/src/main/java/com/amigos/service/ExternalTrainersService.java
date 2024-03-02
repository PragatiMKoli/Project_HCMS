package com.amigos.service;

import java.util.List;

import com.amigos.entities.ExternalTrainers;

public interface ExternalTrainersService {

List<ExternalTrainers> getAllExternalTrainers();
	
	void addExternalTrainer(ExternalTrainers externalTrainers);
	
	void updateExternalTrainer(ExternalTrainers externalTrainers);
	
	void deleteExternalTrainer(ExternalTrainers externalTrainers);
	
	ExternalTrainers getExternalTrainerById(int id);
}
