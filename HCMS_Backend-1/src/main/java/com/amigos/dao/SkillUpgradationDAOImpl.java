package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.Roles;
import com.amigos.entities.SkillUpgradation;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SkillUpgradationDAOImpl implements SkillUpgradationDAO{
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<SkillUpgradation> getAllSkillUpgradation() {
		return entityManager.unwrap(Session.class).createQuery("From SkillUpgradation").getResultList();
	}

	@Override
	public void addSkillUpgradation(SkillUpgradation skillUpgradation) {
		entityManager.unwrap(Session.class).saveOrUpdate(skillUpgradation);
	}

	@Override
	public void updateSkillUpgradation(SkillUpgradation skillUpgradation) {
		entityManager.unwrap(Session.class).update(skillUpgradation);
		}

	@Override
	public void deleteSkillUpgradation(SkillUpgradation skillUpgradation) {
		entityManager.unwrap(Session.class).delete(skillUpgradation);
	}

	@Override
	public SkillUpgradation getSkillUpgradationById(int id) {
		
		return null;
	}

	
}
