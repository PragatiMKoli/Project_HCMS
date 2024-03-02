package com.amigos.service;

import java.util.List;

import com.amigos.entities.TrainingSchedules;

public interface TrainingSchedulesService {

List<TrainingSchedules> getAllTrainingSchedules();
	
	void addTrainingSchedule(TrainingSchedules trainingSchedules);
	
	void updateTrainingSchedule(TrainingSchedules trainingSchedules);
	
	void deleteTrainingSchedule(TrainingSchedules trainingSchedules);
	
	TrainingSchedules getTrainingScheduleById(int id);
}
