package com.amigos.dao;

import java.util.List;

import com.amigos.entities.ExternalTrainers;


public interface ExternalTrainersDAO {
	
	List<ExternalTrainers> getAllExternalTrainerss();
	
	void addExternalTrainer(ExternalTrainers externalTrainers);
	
	void updateExternalTrainer(ExternalTrainers externalTrainerst);
	
	void deleteExternalTrainer(ExternalTrainers externalTrainers);
	
	ExternalTrainers getExternalTrainerById(int id);

}
