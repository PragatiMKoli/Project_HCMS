package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.EmployeeManagersDAO;
import com.amigos.dao.EmployeesDAO;
import com.amigos.entities.EmployeeManagers;
import com.amigos.entities.Employees;

@Service
public class EmployeeManagersServiceImpl implements EmployeeManagersService{

	@Autowired
	private EmployeeManagersDAO employeeManagersDAO;

	@Override
	public List<EmployeeManagers> getAllEmployeeManagers() {
		return employeeManagersDAO.getAllEmployeeManagers();
	}

	@Override
	public void addEmployeeManager(EmployeeManagers employeeManagers) {
		employeeManagersDAO.addEmployeeManager(employeeManagers);
	}

	@Override
	public void updateEmployeeManager(EmployeeManagers employeeManagers) {
		employeeManagersDAO.updateEmployeeManager(employeeManagers);
	}

	@Override
	public void deleteEmployeeManager(EmployeeManagers employeeManagers) {
		employeeManagersDAO.deleteEmployeeManager(employeeManagers);
	}

	@Override
	public EmployeeManagers getEmployeeManagerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
}
