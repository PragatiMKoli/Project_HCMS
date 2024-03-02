package com.amigos.service;

import java.util.List;

import com.amigos.entities.SkillUpgradation;

public interface SkillUpgradationsService {

List<SkillUpgradation> getAllSkillUpgradation();
	
	void addSkillUpgradation(SkillUpgradation skillUpgradation);
	
	void updateSkillUpgradation(SkillUpgradation skillUpgradation);
	
	void deleteSkillUpgradation(SkillUpgradation skillUpgradation);
	
	SkillUpgradation getSkillUpgradationById(int id);
}
