package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.Roles;
import com.amigos.entities.Vacancies;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class VacanciesDAOImpl implements VacanciesDAO {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Vacancies> getAllVacancies() {
		return entityManager.unwrap(Session.class).createQuery("FROM Vacancies").getResultList();
	}

	@Override
	public void addVacancies(Vacancies vacancies) {
		entityManager.unwrap(Session.class).saveOrUpdate(vacancies);
	}

	@Override
	public void updateVacancies(Vacancies vacancies) {
		entityManager.unwrap(Session.class).update(vacancies);
	}

	@Override
	public void deleteVacancies(Vacancies vacancies) {
		entityManager.unwrap(Session.class).delete(vacancies);
	}

	@Override
	public Vacancies getVacanciesById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
