package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.Employees;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmployeesDAOImpl implements EmployeesDAO {

	@Autowired
	private EntityManager entityManager;  
	
	@Override
	public List<Employees> getAllEmployees() {
		 return entityManager.unwrap(Session.class).createQuery("From Employees").getResultList();
	}

	@Override
	public void addEmployee(Employees employees) {
		entityManager.unwrap(Session.class).saveOrUpdate(employees);
	}

	@Override
	public void updateEmployee(Employees employees) {
		entityManager.unwrap(Session.class).update(employees);
	}

	@Override
	public void deleteEmployee(Employees employees) {
		entityManager.unwrap(Session.class).delete(employees);
	}

	@Override
	public Employees getEmployeeById(int id) {
		//entityManager.unwrap(Session.class).f
		return null;
	}

}
