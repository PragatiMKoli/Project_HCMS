package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.EmployeesDAO;
import com.amigos.entities.Employees;

@Service
public class EmployeesServiceImpl implements EmployeesService{

	@Autowired
	private EmployeesDAO employeesDAO;
	
	@Override
	public List<Employees> getAllEmployees() {
		
		return employeesDAO.getAllEmployees();
	}

	@Override
	public void addEmployee(Employees employees) {
		employeesDAO.addEmployee(employees);
	}

	@Override
	public void updateEmployee(Employees employees) {
		
		employeesDAO.updateEmployee(employees);
	}

	@Override
	public void deleteEmployee(Employees employees) {
		employeesDAO.deleteEmployee(employees);
	}

	@Override
	public Employees getEmployeeById(int id) {
		
		return employeesDAO.getEmployeeById(id);
	}

	
}
