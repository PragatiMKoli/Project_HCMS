package com.amigos.dao;

import java.util.List;

import com.amigos.entities.EmployeeManagers;

public interface EmployeeManagersDAO {
	
	List<EmployeeManagers> getAllEmployeeManagers();
	
	void addEmployeeManager(EmployeeManagers employeeManagers);
	
	void updateEmployeeManager(EmployeeManagers employeeManagers);
	
	void deleteEmployeeManager(EmployeeManagers employeeManagers);
	
	EmployeeManagers getEmployeeManagerById(int id);

}
