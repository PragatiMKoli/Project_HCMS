package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.EmployeesDAO;
import com.amigos.dao.SkillMatixDAO;
import com.amigos.entities.Employees;
import com.amigos.entities.SkillMatrix;

@Service
public class SkillMatrixServiceImpl implements SkillMatrixService{

	@Autowired
	private SkillMatixDAO skillMatixDAO;

	@Override
	public List<SkillMatrix> getAllSkillMatrix() {
		return skillMatixDAO.getAllSkillMatrix();
	}

	@Override
	public void addSkillMatrix(SkillMatrix skillMatrix) {
		skillMatixDAO.addSkillMatrix(skillMatrix);
	}

	@Override
	public void updateSkillMatrix(SkillMatrix skillMatrix) {
		skillMatixDAO.updateSkillMatrix(skillMatrix);
	}

	@Override
	public void deleteSkillMatrix(SkillMatrix skillMatrix) {
		skillMatixDAO.deleteSkillMatrix(skillMatrix);
	}

	@Override
	public SkillMatrix getSkillMatrixById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
}
