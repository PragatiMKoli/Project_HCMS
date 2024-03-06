package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.DepartmentsDAO;
import com.amigos.entities.Departments;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {
	@Autowired
	private DepartmentsDAO departmentsDAO;

	@Override
	public List<Departments> getAllDepartments() {

		return departmentsDAO.getAllDepartments();
	}

	@Override
	public void addDepartment(Departments department) {
		departmentsDAO.addDepartment(department);
	}

	@Override
	public void updateDepartment(Departments department) {
		departmentsDAO.updateDepartment(department);
	}

	@Override
	public void deleteDepartment(Departments department) {
		departmentsDAO.deleteDepartment(department);
	}

	@Override
	public Departments getDepartmentById(int id) {
		return departmentsDAO.getDepartmentById(id);
	}

}
