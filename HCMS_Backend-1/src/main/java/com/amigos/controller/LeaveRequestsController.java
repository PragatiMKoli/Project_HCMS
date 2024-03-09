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

import com.amigos.entities.LeaveRequests;
import com.amigos.service.LeaveRequestsService;


@RestController
public class LeaveRequestsController {
	@Autowired
	private LeaveRequestsService leaveRequestsService;

	@GetMapping("/leaveRequests")
	private ResponseEntity<List<LeaveRequests>> getAll() {
		return new ResponseEntity<List<LeaveRequests>>(leaveRequestsService.getAllLeaveRequests(), HttpStatus.OK);
	}

	// @RequestMapping(value = "/employees", method = RequestMethod.POST)
	@PostMapping("/leaveRequests")
	private ResponseEntity<Void> save(@RequestBody LeaveRequests leaveRequests, UriComponentsBuilder ucBuilder) {
		if (leaveRequests == null) {
			throw new RuntimeException("Leave Requests Object can 't  be NULL");
		}
		leaveRequestsService.addLeaveRequest(leaveRequests);
		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(emp).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping("/leaveRequests/{id}")
	private ResponseEntity<LeaveRequests> get(@PathVariable int id) {
		LeaveRequests leaveRequests = leaveRequestsService.getLeaveRequestById(id);
		if (leaveRequests == null) {
			return new ResponseEntity<LeaveRequests>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<LeaveRequests>(leaveRequests, HttpStatus.OK);
		}
	}

	@PutMapping("/leaveRequests/{id}")
	private ResponseEntity<Void> update(@RequestBody LeaveRequests toBeUpdateLeaveRequests, @PathVariable int id) {
		if (toBeUpdateLeaveRequests == null) {
			throw new RuntimeException("Leave Requests Object can 't  be NULL");
		}
		LeaveRequests existingLeaveRequests = leaveRequestsService.getLeaveRequestById(id);
		if (toBeUpdateLeaveRequests == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			leaveRequestsService.updateLeaveRequest(existingLeaveRequests);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

	@DeleteMapping("/leaveRequests/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id) {
		LeaveRequests deleteLeaveRequests = leaveRequestsService.getLeaveRequestById(id);
		if (deleteLeaveRequests == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			leaveRequestsService.deleteLeaveRequest(deleteLeaveRequests);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}


}
