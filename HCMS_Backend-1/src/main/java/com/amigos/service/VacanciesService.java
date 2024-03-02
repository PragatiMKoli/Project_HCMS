package com.amigos.service;

import java.util.List;

import com.amigos.entities.Vacancies;

public interface VacanciesService {

List<Vacancies> getAllVacancies();
	
	void addVacancie(Vacancies vacancies);
	
	void updateVacancie(Vacancies vacancies);
	
	void deleteVacancie(Vacancies vacancies);
	
	Vacancies getVacancieById(int id);
}
