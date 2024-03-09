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

import com.amigos.entities.TrainingFeedback;
import com.amigos.service.TrainingFeedbackService;

@RestController
public class TrainingFeedbackController {
	@Autowired
	private TrainingFeedbackService trainingFeedbackService;

	@GetMapping("/trainingFeedback")
	private ResponseEntity<List<TrainingFeedback>> getAll() {
		return new ResponseEntity<List<TrainingFeedback>>(trainingFeedbackService.getAllTrainingFeedback(),
				HttpStatus.OK);
	}

	// @RequestMapping(value = "/employees", method = RequestMethod.POST)
	@PostMapping("/trainingFeedback")
	private ResponseEntity<Void> save(@RequestBody TrainingFeedback trainingFeedback, UriComponentsBuilder ucBuilder) {
		if (trainingFeedback == null) {
			throw new RuntimeException("TrainingFeedback Object can 't  be NULL");
		}
		trainingFeedbackService.addTrainingFeedback(trainingFeedback);
		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(emp).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping("/trainingFeedback/{id}")
	private ResponseEntity<TrainingFeedback> get(@PathVariable int id) {
		TrainingFeedback trainingFeedback = trainingFeedbackService.getTrainingFeedbackById(id);
		if (trainingFeedback == null) {
			return new ResponseEntity<TrainingFeedback>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<TrainingFeedback>(trainingFeedback, HttpStatus.OK);
		}
	}

	@PutMapping("/trainingFeedback/{id}")
	private ResponseEntity<Void> update(@RequestBody TrainingFeedback toBeUpdateTrainingFeedback,
			@PathVariable int id) {
		if (toBeUpdateTrainingFeedback == null) {
			throw new RuntimeException("TrainingFeedback Object can 't  be NULL");
		}
		TrainingFeedback existingTrainingFeedback = trainingFeedbackService.getTrainingFeedbackById(id);
		if (toBeUpdateTrainingFeedback == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			trainingFeedbackService.updateTrainingFeedback(toBeUpdateTrainingFeedback);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

	@DeleteMapping("/trainingFeedback/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id) {
		TrainingFeedback deleteTrainingFeedback = trainingFeedbackService.getTrainingFeedbackById(id);
		if (deleteTrainingFeedback == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			trainingFeedbackService.deleteTrainingFeedback(deleteTrainingFeedback);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

}
