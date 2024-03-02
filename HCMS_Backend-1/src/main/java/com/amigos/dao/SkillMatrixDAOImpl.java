package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.Roles;
import com.amigos.entities.SkillMatrix;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SkillMatrixDAOImpl implements SkillMatixDAO {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<SkillMatrix> getAllSkillMatrix() {
		return entityManager.unwrap(Session.class).createQuery("From SkillMatrix").getResultList();
	}

	@Override
	public void addSkillMatrix(SkillMatrix skillMatrix) {
		entityManager.unwrap(Session.class).saveOrUpdate(skillMatrix);
	}

	@Override
	public void updateSkillMatrix(SkillMatrix skillMatrix) {
		entityManager.unwrap(Session.class).update(skillMatrix);
	}

	@Override
	public void deleteSkillMatrix(SkillMatrix skillMatrix) {
		entityManager.unwrap(Session.class).delete(skillMatrix);
	}

	@Override
	public SkillMatrix getSkillMatrixById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
