package com.amigos.dao;

import java.util.List;

import com.amigos.entities.Employees;

public interface EmployeesDAO {

	List<Employees> getAllEmployees();
	
	void addEmployee(Employees employees);
	
	void updateEmployee(Employees employees);
	
	void deleteEmployee(Employees employees);
	
	Employees getEmployeeById(int id);
}
