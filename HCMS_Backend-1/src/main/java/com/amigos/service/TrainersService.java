package com.amigos.service;

import java.util.List;

import com.amigos.entities.Trainers;

public interface TrainersService {

List<Trainers> getAllTrainers();
	
	void addTrainer(Trainers trainers);
	
	void updateTrainer(Trainers trainers);
	
	void deleteTrainer(Trainers trainers);
	
	Trainers getTrainerById(int id);
}
