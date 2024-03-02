package com.amigos.dao;

import java.util.List;

import com.amigos.entities.Departments;

public interface DepartmentsDAO {
	
	List<Departments> getAllDepartments();
	
	void addDepartment(Departments department);
	
	void updateDepartment(Departments department);
	
	void deleteDepartment(Departments department);
	
	Departments getDepartmentById(int id);

}
