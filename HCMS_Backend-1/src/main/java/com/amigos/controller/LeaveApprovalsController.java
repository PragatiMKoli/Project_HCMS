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

import com.amigos.entities.LeaveApprovals;
import com.amigos.service.LeaveApprovalsService;



@RestController
public class LeaveApprovalsController {
	@Autowired
	private LeaveApprovalsService leaveApprovalsService;

	@GetMapping("/leaveApprovals")
	private ResponseEntity<List<LeaveApprovals>> getAll() {
		return new ResponseEntity<List<LeaveApprovals>>(leaveApprovalsService.getAllLeaveApprovals(), HttpStatus.OK);
	}

	// @RequestMapping(value = "/employees", method = RequestMethod.POST)
	@PostMapping("/leaveApprovals")
	private ResponseEntity<Void> save(@RequestBody LeaveApprovals leaveApprovals, UriComponentsBuilder ucBuilder) {
		if (leaveApprovals == null) {
			throw new RuntimeException("Employee Object can 't  be NULL");
		}
		leaveApprovalsService.addLeaveApproval(leaveApprovals);
		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(emp).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping("/leaveApprovals/{id}")
	private ResponseEntity<LeaveApprovals> get(@PathVariable int id) {
		LeaveApprovals leaveApprovals = leaveApprovalsService.getLeaveApprovalById(id);
		if (leaveApprovals == null) {
			return new ResponseEntity<LeaveApprovals>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<LeaveApprovals>(leaveApprovals, HttpStatus.OK);
		}
	}

	@PutMapping("/leaveApprovals/{id}")
	private ResponseEntity<Void> update(@RequestBody LeaveApprovals toBeUpdateLeaveApprovals, @PathVariable int id) {
		if (toBeUpdateLeaveApprovals == null) {
			throw new RuntimeException("Leave Approval Object can 't  be NULL");
		}
		LeaveApprovals existingLeaveApproval = leaveApprovalsService.getLeaveApprovalById(id);
		if (toBeUpdateLeaveApprovals == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			leaveApprovalsService.updateLeaveApproval(toBeUpdateLeaveApprovals);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

	@DeleteMapping("/leaveApprovals/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id) {
		LeaveApprovals deleteLeaveApprovals = leaveApprovalsService.getLeaveApprovalById(id);
		if (deleteLeaveApprovals== null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			leaveApprovalsService.deleteLeaveApproval(deleteLeaveApprovals);

			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}


}
