package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.Projects;
import com.amigos.entities.Roles;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProjectsDAOImpl implements ProjectsDAO {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Projects> getAllProjects() {
		
	return entityManager.unwrap(Session.class).createQuery("From Projects").getResultList();
}

	@Override
	public void addProjects(Projects projects) {
		entityManager.unwrap(Session.class).saveOrUpdate(projects);
	}

	@Override
	public void updateProjects(Projects projects) {
		entityManager.unwrap(Session.class).update(projects);
	}

	@Override
	public void deleteProjects(Projects projects) {
		entityManager.unwrap(Session.class).delete(projects);
	}

	@Override
	public Projects getProjectsById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
