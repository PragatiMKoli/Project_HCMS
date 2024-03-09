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

import com.amigos.entities.ApplicationStatus;
import com.amigos.service.ApplicationStatusService;

@RestController
public class ApplicationStatusController {

	@Autowired
	private ApplicationStatusService applicationStatusService;

	@GetMapping("/applicationStatus")
	private ResponseEntity<List<ApplicationStatus>> getAllApplicationStatus() {
		return new ResponseEntity<List<ApplicationStatus>>(applicationStatusService.getAllApplicationStatus(),
				HttpStatus.OK);
	}

	@PostMapping("/applicationStatus")
	private ResponseEntity<Void> saveApplicationStatus(@RequestBody ApplicationStatus applicationStatus,
			UriComponentsBuilder uriComponentsBuilder) {
		if (applicationStatus == null) {
			throw new RuntimeException("ApplicationStatus Can't be null ");
		}
		applicationStatusService.addApplicationStatus(applicationStatus);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}

	@GetMapping("/applicationStatus/{id}")
	private ResponseEntity<ApplicationStatus> getById(@PathVariable int id) {
		ApplicationStatus applicationStatus = applicationStatusService.getApplicationStatusById(id);
		if (applicationStatus == null) {
			return new ResponseEntity<ApplicationStatus>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<ApplicationStatus>(HttpStatus.OK);
		}
	}

	@PutMapping("/applicationStatus/{id}")
	private ResponseEntity<ApplicationStatus> updateApplicationStatus(
			@RequestBody ApplicationStatus toBeApplicationStatus, @PathVariable int id) {
		if (toBeApplicationStatus == null) {
			throw new RuntimeException("Application Status Can't Be Null");
		}
		ApplicationStatus existingApplicationStatus = applicationStatusService.getApplicationStatusById(id);
		if (toBeApplicationStatus == null) {
			return new ResponseEntity<ApplicationStatus>(HttpStatus.NOT_FOUND);
		} else {
			applicationStatusService.updateApplicationStatus(toBeApplicationStatus);
			return new ResponseEntity<ApplicationStatus>(HttpStatus.OK);
		}
	}

	@DeleteMapping("")
	private ResponseEntity<ApplicationStatus> deleteApplicationStatus(@PathVariable int id) {
		ApplicationStatus deleteApplicationStatus = applicationStatusService.getApplicationStatusById(id);
		if (deleteApplicationStatus == null) {
			return new ResponseEntity<ApplicationStatus>(HttpStatus.NOT_FOUND);
		} else {
			applicationStatusService.deleteApplicationStatus(deleteApplicationStatus);
			return new ResponseEntity<ApplicationStatus>(HttpStatus.OK);
		}
	}

}
