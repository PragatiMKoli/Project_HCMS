package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.EmployeesDAO;
import com.amigos.dao.SkillUpgradationDAO;
import com.amigos.entities.Employees;
import com.amigos.entities.SkillUpgradation;

@Service
public class SkillUpgradationServiceImpl implements SkillUpgradationsService{

	@Autowired
	private SkillUpgradationDAO skillUpgradationDAO;

	@Override
	public List<SkillUpgradation> getAllSkillUpgradation() {
		return skillUpgradationDAO.getAllSkillUpgradation();
	}

	@Override
	public void addSkillUpgradation(SkillUpgradation skillUpgradation) {
		skillUpgradationDAO.addSkillUpgradation(skillUpgradation);
	}

	@Override
	public void updateSkillUpgradation(SkillUpgradation skillUpgradation) {
		skillUpgradationDAO.updateSkillUpgradation(skillUpgradation);
	}

	@Override
	public void deleteSkillUpgradation(SkillUpgradation skillUpgradation) {
		skillUpgradationDAO.deleteSkillUpgradation(skillUpgradation);
	}

	@Override
	public SkillUpgradation getSkillUpgradationById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
