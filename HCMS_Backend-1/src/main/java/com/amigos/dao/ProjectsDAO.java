package com.amigos.dao;

import java.util.List;

import com.amigos.entities.Projects;

public interface ProjectsDAO {
	
	List<Projects> getAllProjects();
	
	void addProjects(Projects projects);
	
	void updateProjects(Projects projects);
	
	void deleteProjects(Projects projects);
	
	Projects getProjectsById(int id);

}
