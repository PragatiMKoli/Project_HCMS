package com.amigos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.amigos.entities.Projects;
import com.amigos.service.ProjectsService;

@RestController
public class ProjectsController {

	@Autowired
	private ProjectsService projectsService;

	@GetMapping("/projects")
	private ResponseEntity<List<Projects>> getAll() {
		return new ResponseEntity<List<Projects>>(projectsService.getAllProjects(), HttpStatus.OK);
	}

	// @RequestMapping(value = "/employees", method = RequestMethod.POST)
	@PostMapping("/projects")
	private ResponseEntity<Void> save(@RequestBody Projects projects, UriComponentsBuilder ucBuilder) {
		if (projects == null) {
			throw new RuntimeException("Projects Object can 't  be NULL");
		}
		projectsService.addProject(projects);
		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(emp).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping("/projects/{id}")
	private ResponseEntity<Projects> get(@PathVariable int id) {
		Projects projects = projectsService.getProjectById(id);
		if (projects == null) {
			return new ResponseEntity<Projects>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Projects>(projects, HttpStatus.OK);
		}
	}

	@PutMapping("/projects/{id}")
	private ResponseEntity<Void> update(@RequestBody Projects toBeUpdateProjects, @PathVariable int id) {
		if (toBeUpdateProjects == null) {
			throw new RuntimeException("Projects Object can 't  be NULL");
		}
		Projects existingProjcts = projectsService.getProjectById(id);
		if (toBeUpdateProjects == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			projectsService.updateProject(toBeUpdateProjects);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

	@DeleteMapping("/projects/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id) {
		Projects deleteProjects = projectsService.getProjectById(id);
		if (deleteProjects == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			projectsService.deleteProject(deleteProjects);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

}
