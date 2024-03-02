package com.amigos.service;

import java.util.List;

import com.amigos.entities.Employees;

public interface EmployeesService {

List<Employees> getAllEmployees();
	
	void addEmployee(Employees employees);
	
	void updateEmployee(Employees employees);
	
	void deleteEmployee(Employees employees);
	
	Employees getEmployeeById(int id);
}
