package com.amigos.dao;

import java.util.List;

import com.amigos.entities.Vacancies;

public interface VacanciesDAO {
	
	List<Vacancies> getAllVacancies();
	
	void addVacancies(Vacancies vacancies);
	
	void updateVacancies(Vacancies vacancies);
	
	void deleteVacancies(Vacancies vacancies);
	
	Vacancies getVacanciesById(int id);

}
