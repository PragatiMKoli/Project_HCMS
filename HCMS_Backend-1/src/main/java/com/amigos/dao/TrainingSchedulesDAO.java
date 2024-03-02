package com.amigos.dao;

import java.util.List;

import com.amigos.entities.TrainingSchedules;

public interface TrainingSchedulesDAO {
	
	List<TrainingSchedules> getAllTrainingSchedules();
	
	void addTrainingSchedule(TrainingSchedules trainingSchedules);
	
	void updateTrainingSchedule(TrainingSchedules trainingSchedules);
	
	void deleteTrainingSchedule(TrainingSchedules trainingSchedules);
	
	TrainingSchedules getTrainingScheduleById(int id);

}
