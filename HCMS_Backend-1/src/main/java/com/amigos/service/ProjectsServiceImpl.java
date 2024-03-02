package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.EmployeesDAO;
import com.amigos.dao.ProjectsDAO;
import com.amigos.entities.Employees;
import com.amigos.entities.Projects;

@Service
public class ProjectsServiceImpl implements ProjectsService{

	@Autowired
	private ProjectsDAO projectsDAO;

	@Override
	public List<Projects> getAllProjects() {
		return projectsDAO.getAllProjects();
	}

	@Override
	public void addProject(Projects projects) {
		projectsDAO.addProjects(projects);
	}

	@Override
	public void updateProject(Projects projects) {
		projectsDAO.updateProjects(projects);
	}

	@Override
	public void deleteProject(Projects projects) {
		projectsDAO.deleteProjects(projects);
	}

	@Override
	public Projects getProjectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	


	
}
