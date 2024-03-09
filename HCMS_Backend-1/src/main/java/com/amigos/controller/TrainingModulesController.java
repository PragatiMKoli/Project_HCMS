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

import com.amigos.entities.TrainingModules;
import com.amigos.service.TrainingModulesService;

@RestController
public class TrainingModulesController {
	@Autowired
	private TrainingModulesService trainingModulesService;

	@GetMapping("/trainingModules")
	private ResponseEntity<List<TrainingModules>> getAll() {
		return new ResponseEntity<List<TrainingModules>>(trainingModulesService.getAllTrainingModules(), HttpStatus.OK);
	}

	// @RequestMapping(value = "/employees", method = RequestMethod.POST)
	@PostMapping("/trainingModules")
	private ResponseEntity<Void> save(@RequestBody TrainingModules trainingModules, UriComponentsBuilder ucBuilder) {
		if (trainingModules == null) {
			throw new RuntimeException("Training Modules Object can 't  be NULL");
		}
		trainingModulesService.addTrainingModule(trainingModules);
		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(emp).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping("/trainingModules/{id}")
	private ResponseEntity<TrainingModules> get(@PathVariable int id) {
		TrainingModules trainingModules = trainingModulesService.getTrainingModuleById(id);
		if (trainingModules == null) {
			return new ResponseEntity<TrainingModules>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<TrainingModules>(trainingModules, HttpStatus.OK);
		}
	}

	@PutMapping("/trainingModules/{id}")
	private ResponseEntity<Void> update(@RequestBody TrainingModules toBeUpdateTrainingModules, @PathVariable int id) {
		if (toBeUpdateTrainingModules == null) {
			throw new RuntimeException("TrainingModules Object can 't  be NULL");
		}
		TrainingModules existingTrainingModules = trainingModulesService.getTrainingModuleById(id);
		if (toBeUpdateTrainingModules == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			trainingModulesService.updateTrainingModule(toBeUpdateTrainingModules);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

	@DeleteMapping("/trainingModules/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id) {
		TrainingModules deleteTrainingModules = trainingModulesService.getTrainingModuleById(id);
		if (deleteTrainingModules == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			trainingModulesService.deleteTrainingModule(deleteTrainingModules);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

}
