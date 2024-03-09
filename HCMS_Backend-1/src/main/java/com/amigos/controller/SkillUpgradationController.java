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

import com.amigos.entities.SkillUpgradation;
import com.amigos.service.SkillUpgradationsService;

@RestController
public class SkillUpgradationController {
	@Autowired
	private SkillUpgradationsService skillUpgradationsService;

	@GetMapping("/skillUpgradations")
	private ResponseEntity<List<SkillUpgradation>> getAll() {
		return new ResponseEntity<List<SkillUpgradation>>(skillUpgradationsService.getAllSkillUpgradation(),
				HttpStatus.OK);
	}

	// @RequestMapping(value = "/employees", method = RequestMethod.POST)
	@PostMapping("/skillUpgradations")
	private ResponseEntity<Void> save(@RequestBody SkillUpgradation skillUpgradation, UriComponentsBuilder ucBuilder) {
		if (skillUpgradation == null) {
			throw new RuntimeException("SkillUpgradation Object can 't  be NULL");
		}
		skillUpgradationsService.addSkillUpgradation(skillUpgradation);
		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(emp).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping("/skillUpgradations/{id}")
	private ResponseEntity<SkillUpgradation> get(@PathVariable int id) {
		SkillUpgradation skillUpgradation = skillUpgradationsService.getSkillUpgradationById(id);
		if (skillUpgradation == null) {
			return new ResponseEntity<SkillUpgradation>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<SkillUpgradation>(skillUpgradation, HttpStatus.OK);
		}
	}

	@PutMapping("/skillUpgradations/{id}")
	private ResponseEntity<Void> update(@RequestBody SkillUpgradation toBeUpdateSkillUpgradation,
			@PathVariable int id) {
		if (toBeUpdateSkillUpgradation == null) {
			throw new RuntimeException("SkillUpgradation Object can 't  be NULL");
		}
		SkillUpgradation existingSkillUpgradation = skillUpgradationsService.getSkillUpgradationById(id);
		if (toBeUpdateSkillUpgradation == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			skillUpgradationsService.updateSkillUpgradation(toBeUpdateSkillUpgradation);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

	@DeleteMapping("/skillUpgradations/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id) {
		SkillUpgradation skillUpgradation = skillUpgradationsService.getSkillUpgradationById(id);
		if (skillUpgradation== null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			skillUpgradationsService.deleteSkillUpgradation(skillUpgradation);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

}
