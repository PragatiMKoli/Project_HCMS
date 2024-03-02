package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.EmployeesDAO;
import com.amigos.dao.TrainingSchedulesDAO;
import com.amigos.entities.Employees;
import com.amigos.entities.TrainingSchedules;

@Service
public class TrainingSchedulesServiceImpl implements TrainingSchedulesService{

	@Autowired
	private TrainingSchedulesDAO trainingSchedulesDAO;

	@Override
	public List<TrainingSchedules> getAllTrainingSchedules() {
		return trainingSchedulesDAO.getAllTrainingSchedules();
	}

	@Override
	public void addTrainingSchedule(TrainingSchedules trainingSchedules) {
		trainingSchedulesDAO.addTrainingSchedule(trainingSchedules);
	}

	@Override
	public void updateTrainingSchedule(TrainingSchedules trainingSchedules) {
		trainingSchedulesDAO.updateTrainingSchedule(trainingSchedules);
	}

	@Override
	public void deleteTrainingSchedule(TrainingSchedules trainingSchedules) {
		trainingSchedulesDAO.deleteTrainingSchedule(trainingSchedules);
	}

	@Override
	public TrainingSchedules getTrainingScheduleById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
