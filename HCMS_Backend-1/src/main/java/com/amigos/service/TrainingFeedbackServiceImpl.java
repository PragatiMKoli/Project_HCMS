package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.EmployeesDAO;
import com.amigos.dao.TrainingFeedbackDAO;
import com.amigos.entities.Employees;
import com.amigos.entities.TrainingFeedback;

@Service
public class TrainingFeedbackServiceImpl implements TrainingFeedbackService{

	@Autowired
	private TrainingFeedbackDAO trainingFeedbackDAO;

	@Override
	public List<TrainingFeedback> getAllTrainingFeedback() {
		return trainingFeedbackDAO.getAllTrainingFeedback();
	}

	@Override
	public void addTrainingFeedback(TrainingFeedback trainingFeedback) {
		trainingFeedbackDAO.addTrainingFeedback(trainingFeedback);
	}

	@Override
	public void updateTrainingFeedback(TrainingFeedback trainingFeedback) {
		trainingFeedbackDAO.updateTrainingFeedback(trainingFeedback);
	}

	@Override
	public void deleteTrainingFeedback(TrainingFeedback trainingFeedback) {
		trainingFeedbackDAO.deleteTrainingFeedback(trainingFeedback);
	}

	@Override
	public TrainingFeedback getTrainingFeedbackById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
