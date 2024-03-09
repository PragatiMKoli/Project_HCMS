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

import com.amigos.entities.SkillMatrix;
import com.amigos.service.SkillMatrixService;

@RestController
public class SkillMatrixController {
	@Autowired
	private SkillMatrixService skillMatrixService;

	@GetMapping("/skillMatrix")
	private ResponseEntity<List<SkillMatrix>> getAll() {
		return new ResponseEntity<List<SkillMatrix>>(skillMatrixService.getAllSkillMatrix(), HttpStatus.OK);
	}

	// @RequestMapping(value = "/employees", method = RequestMethod.POST)
	@PostMapping("/skillMatrix")
	private ResponseEntity<Void> save(@RequestBody SkillMatrix skillMatrix, UriComponentsBuilder ucBuilder) {
		if (skillMatrix == null) {
			throw new RuntimeException("SkillMatrix Object can 't  be NULL");
		}
		skillMatrixService.addSkillMatrix(skillMatrix);
		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(emp).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping("/skillMatrix/{id}")
	private ResponseEntity<SkillMatrix> get(@PathVariable int id) {
		SkillMatrix skillMatrix = skillMatrixService.getSkillMatrixById(id);
		if (skillMatrix == null) {
			return new ResponseEntity<SkillMatrix>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<SkillMatrix>(skillMatrix, HttpStatus.OK);
		}
	}

	@PutMapping("/skillMatrix/{id}")
	private ResponseEntity<Void> update(@RequestBody SkillMatrix toBeUpdateSkillMatrix, @PathVariable int id) {
		if (toBeUpdateSkillMatrix == null) {
			throw new RuntimeException("SkillMatrix Object can 't  be NULL");
		}
		SkillMatrix existingSkillMatix = skillMatrixService.getSkillMatrixById(id);
		if (toBeUpdateSkillMatrix== null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			skillMatrixService.updateSkillMatrix(toBeUpdateSkillMatrix);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

	@DeleteMapping("/skillMatrix/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id) {
		SkillMatrix deleteSkillMatrix = skillMatrixService.getSkillMatrixById(id);
		if (deleteSkillMatrix == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			skillMatrixService.deleteSkillMatrix(deleteSkillMatrix);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

}
