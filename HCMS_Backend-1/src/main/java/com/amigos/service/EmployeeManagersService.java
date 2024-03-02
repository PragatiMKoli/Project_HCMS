package com.amigos.service;

import java.util.List;

import com.amigos.entities.EmployeeManagers;

public interface EmployeeManagersService {

List<EmployeeManagers> getAllEmployeeManagers();
	
	void addEmployeeManager(EmployeeManagers employeeManagers);
	
	void updateEmployeeManager(EmployeeManagers employeeManagers);
	
	void deleteEmployeeManager(EmployeeManagers employeeManagers);
	
	EmployeeManagers getEmployeeManagerById(int id);
}
