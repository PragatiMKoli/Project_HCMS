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

import com.amigos.entities.CandidateProfiles;
import com.amigos.service.CandidateProfilesService;

@RestController
public class CandidateProfilesController {

	@Autowired
	private CandidateProfilesService candidateProfilesService;

	@GetMapping("/candidateProfiles")
	private ResponseEntity<List<CandidateProfiles>> getAllCandidateProfiles() {
		return new ResponseEntity<List<CandidateProfiles>>(candidateProfilesService.getAllCandidateProfiles(),
				HttpStatus.OK);
	}

	@PostMapping("/candidateProfiles")
	private ResponseEntity<Void> saveCandidateProfiles(@RequestBody CandidateProfiles candidateProfiles,
			UriComponentsBuilder componentsBuilder) {
		if (candidateProfiles == null) {
			throw new RuntimeException("Candidate Profile Object can't be null");
		}
		candidateProfilesService.addCandidateProfile(candidateProfiles);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping("candidateProfiles/{id}")
	private ResponseEntity<CandidateProfiles> getById(@PathVariable int id) {
		CandidateProfiles profiles = candidateProfilesService.getCandidateProfileById(id);
		if (profiles == null) {
			return new ResponseEntity<CandidateProfiles>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<CandidateProfiles>(profiles, HttpStatus.OK);
		}
	}

	@PutMapping("/candidateProfiles/{id}")
	private ResponseEntity<Void> updateCandidateProfiles(@RequestBody CandidateProfiles toBeCandidateProfiles,
			@PathVariable int id) {
		if (toBeCandidateProfiles == null) {
			throw new RuntimeException("Candidate Profiles Object Can't Be null");
		}
		CandidateProfiles existingCandidateProfiles = candidateProfilesService.getCandidateProfileById(id);
		if (toBeCandidateProfiles == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			candidateProfilesService.updateCandidateProfile(toBeCandidateProfiles);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

	@DeleteMapping("/candidateProfiles/{id}")
	private ResponseEntity<Void> deleteCandidateProfiles(@PathVariable int id) {
		CandidateProfiles candidateProfiles = candidateProfilesService.getCandidateProfileById(id);
		if (candidateProfiles == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			candidateProfilesService.deleteCandidateProfile(candidateProfiles);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
}
