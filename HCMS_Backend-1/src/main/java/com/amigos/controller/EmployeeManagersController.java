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

import com.amigos.entities.EmployeeManagers;
import com.amigos.service.EmployeeManagersService;

@RestController
public class EmployeeManagersController {

	@Autowired
	private EmployeeManagersService employeeManagersService;

	@GetMapping("/employeeManagers")
	private ResponseEntity<List<EmployeeManagers>> getAll() {
		return new ResponseEntity<List<EmployeeManagers>>(employeeManagersService.getAllEmployeeManagers(),
				HttpStatus.OK);
	}

	// @RequestMapping(value = "/employees", method = RequestMethod.POST)
	@PostMapping("/employeeManagers")
	private ResponseEntity<Void> save(@RequestBody EmployeeManagers employeeManagers, UriComponentsBuilder ucBuilder) {
		if (employeeManagers == null) {
			throw new RuntimeException("EmployeeManagers Object can 't  be NULL");
		}
		employeeManagersService.addEmployeeManager(employeeManagers);
		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(emp).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping("/employeeManagers/{id}")
	private ResponseEntity<EmployeeManagers> get(@PathVariable int id) {
		EmployeeManagers emp = employeeManagersService.getEmployeeManagerById(id);
		if (emp == null) {
			return new ResponseEntity<EmployeeManagers>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<EmployeeManagers>(emp, HttpStatus.OK);
		}
	}

	@PutMapping("/employeeManagers/{id}")
	private ResponseEntity<Void> update(@RequestBody EmployeeManagers toBeUpdateEmpployeeManagers,
			@PathVariable int id) {
		if (toBeUpdateEmpployeeManagers == null) {
			throw new RuntimeException("EmployeeManagers Object can 't  be NULL");
		}
		EmployeeManagers existingEmployeeMngers = employeeManagersService.getEmployeeManagerById(id);
		if (toBeUpdateEmpployeeManagers == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			employeeManagersService.updateEmployeeManager(toBeUpdateEmpployeeManagers);

			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

	@DeleteMapping("/employeeManagers/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id) {
		EmployeeManagers deleteEmployeeManagers = employeeManagersService.getEmployeeManagerById(id);
		if (deleteEmployeeManagers == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			employeeManagersService.deleteEmployeeManager(deleteEmployeeManagers);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

}
