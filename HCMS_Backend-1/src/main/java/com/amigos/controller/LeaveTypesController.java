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

import com.amigos.entities.LeaveTypes;
import com.amigos.service.LeaveTypesService;


@RestController
public class LeaveTypesController {
	
	@Autowired
	private LeaveTypesService leaveTypesService;

	@GetMapping("/leaveTypes")
	private ResponseEntity<List<LeaveTypes>> getAll() {
		return new ResponseEntity<List<LeaveTypes>>(leaveTypesService.getAllLeaveTypes(), HttpStatus.OK);
	}

	// @RequestMapping(value = "/employees", method = RequestMethod.POST)
	@PostMapping("/leaveTypes")
	private ResponseEntity<Void> save(@RequestBody LeaveTypes leaveTypes, UriComponentsBuilder ucBuilder) {
		if (leaveTypes == null) {
			throw new RuntimeException("Leav Types Object can 't  be NULL");
		}
		leaveTypesService.addLeaveType(leaveTypes);
		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(emp).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping("/leaveTypes/{id}")
	private ResponseEntity<LeaveTypes> get(@PathVariable int id) {
		LeaveTypes leaveTypes = leaveTypesService.getLeaveTypeById(id);
		if (leaveTypes == null) {
			return new ResponseEntity<LeaveTypes>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<LeaveTypes>(leaveTypes, HttpStatus.OK);
		}
	}

	@PutMapping("/leaveTypes/{id}")
	private ResponseEntity<Void> update(@RequestBody LeaveTypes toBeUpdateLeaveTypes, @PathVariable int id) {
		if (toBeUpdateLeaveTypes == null) {
			throw new RuntimeException("Leave Types Object can 't  be NULL");
		}
		LeaveTypes existingLeaveTypes = leaveTypesService.getLeaveTypeById(id);
		if (toBeUpdateLeaveTypes == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			leaveTypesService.updateLeaveType(existingLeaveTypes);

			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

	@DeleteMapping("/leaveTypes/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id) {
		LeaveTypes deleteLeaveTypes =leaveTypesService.getLeaveTypeById(id);
		if (deleteLeaveTypes == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			leaveTypesService.deleteLeaveType(deleteLeaveTypes);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}


}
