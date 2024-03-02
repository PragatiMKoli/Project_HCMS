package com.amigos.service;

import java.util.List;

import com.amigos.entities.Projects;

public interface ProjectsService {

List<Projects> getAllProjects();
	
	void addProject(Projects projects);
	
	void updateProject(Projects projects);
	
	void deleteProject(Projects projects);
	
	Projects getProjectById(int id);
}
