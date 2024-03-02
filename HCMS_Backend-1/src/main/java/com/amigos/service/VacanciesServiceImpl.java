package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.EmployeesDAO;
import com.amigos.dao.VacanciesDAO;
import com.amigos.entities.Employees;
import com.amigos.entities.Vacancies;

@Service
public class VacanciesServiceImpl implements VacanciesService {

	@Autowired
	private VacanciesDAO vacanciesDAO;

	@Override
	public List<Vacancies> getAllVacancies() {
		return vacanciesDAO.getAllVacancies();
	}

	@Override
	public void addVacancie(Vacancies vacancies) {
		vacanciesDAO.addVacancies(vacancies);
	}

	@Override
	public void updateVacancie(Vacancies vacancies) {
		vacanciesDAO.updateVacancies(vacancies);
	}

	@Override
	public void deleteVacancie(Vacancies vacancies) {
		vacanciesDAO.deleteVacancies(vacancies);
	}

	@Override
	public Vacancies getVacancieById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
