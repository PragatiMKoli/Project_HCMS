package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.EmployeeManagers;
import com.amigos.entities.Roles;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmployeeManagersDAOImpl implements EmployeeManagersDAO {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<EmployeeManagers> getAllEmployeeManagers() {
		
		return entityManager.unwrap(Session.class).createQuery("From EmployeeManagers").getResultList();
	}

	@Override
	public void addEmployeeManager(EmployeeManagers employeeManagers) {
		entityManager.unwrap(Session.class).saveOrUpdate(employeeManagers);
	}

	@Override
	public void updateEmployeeManager(EmployeeManagers employeeManagers) {
		entityManager.unwrap(Session.class).update(employeeManagers);
	}

	@Override
	public void deleteEmployeeManager(EmployeeManagers employeeManagers) {
		entityManager.unwrap(Session.class).delete(employeeManagers);
	}

	@Override
	public EmployeeManagers getEmployeeManagerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
