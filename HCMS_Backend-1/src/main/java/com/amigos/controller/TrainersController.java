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

import com.amigos.entities.Trainers;
import com.amigos.service.TrainersService;

@RestController
public class TrainersController {
	@Autowired
	private TrainersService trainersService;

	@GetMapping("/trainers")
	private ResponseEntity<List<Trainers>> getAll() {
		return new ResponseEntity<List<Trainers>>(trainersService.getAllTrainers(), HttpStatus.OK);
	}

	// @RequestMapping(value = "/employees", method = RequestMethod.POST)
	@PostMapping("/trainers")
	private ResponseEntity<Void> save(@RequestBody Trainers trainers, UriComponentsBuilder ucBuilder) {
		if (trainers == null) {
			throw new RuntimeException("Trainers Object can 't  be NULL");
		}
		trainersService.addTrainer(trainers);
		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(emp).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping("/trainers/{id}")
	private ResponseEntity<Trainers> get(@PathVariable int id) {
		Trainers trainers = trainersService.getTrainerById(id);
		if (trainers == null) {
			return new ResponseEntity<Trainers>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Trainers>(trainers, HttpStatus.OK);
		}
	}

	@PutMapping("/trainers/{id}")
	private ResponseEntity<Void> update(@RequestBody Trainers toBeUpdateTrainers, @PathVariable int id) {
		if (toBeUpdateTrainers == null) {
			throw new RuntimeException("Trainers Object can 't  be NULL");
		}
		Trainers existingTrainers = trainersService.getTrainerById(id);
		if (toBeUpdateTrainers == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			trainersService.updateTrainer(toBeUpdateTrainers);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

	@DeleteMapping("/trainers/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id) {
		Trainers deleteTrainers = trainersService.getTrainerById(id);
		if (deleteTrainers == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			trainersService.deleteTrainer(deleteTrainers);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

}
