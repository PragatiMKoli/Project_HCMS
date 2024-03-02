package com.amigos.dao;

import java.util.List;

import com.amigos.entities.SkillMatrix;

public interface SkillMatixDAO {
	
	List<SkillMatrix> getAllSkillMatrix();
	
	void addSkillMatrix(SkillMatrix skillMatrix);
	
	void updateSkillMatrix(SkillMatrix skillMatrix);
	
	void deleteSkillMatrix(SkillMatrix skillMatrix);
	
	SkillMatrix getSkillMatrixById(int id);

}
