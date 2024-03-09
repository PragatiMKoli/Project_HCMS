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

import com.amigos.entities.Departments;
import com.amigos.service.DepartmentsService;
@RestController
public class DepartmentController {
	@Autowired
	private DepartmentsService departmentsService;
	
	@GetMapping("/departments")
	public ResponseEntity<List<Departments>> getAllDepartments()
	{
		return new ResponseEntity<List<Departments>>(departmentsService.getAllDepartments(), HttpStatus.OK);
	}
	
	@PostMapping("/departments")
	private ResponseEntity<Void> save(@RequestBody Departments departments, UriComponentsBuilder ucBuilder) {
		if (departments == null) {
			throw new RuntimeException("Department Object can 't  be NULL");
		}
		departmentsService.addDepartment(departments);
		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(emp).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping("/departments/{id}")
	private ResponseEntity<Departments> get(@PathVariable int id) {
		Departments departments = departmentsService.getDepartmentById(id);
		if (departments == null) {
			return new ResponseEntity<Departments>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Departments>(departments, HttpStatus.OK);
		}
	}

	@PutMapping("/departments/{id}")
	private ResponseEntity<Void> update(@RequestBody Departments toBeUpdateDep, @PathVariable int id) {
		if (toBeUpdateDep == null) {
			throw new RuntimeException("Department Object can 't  be NULL");
		}
		Departments existingDep = departmentsService.getDepartmentById(id);
		if (toBeUpdateDep == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			departmentsService.updateDepartment(existingDep);

			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

	@DeleteMapping("/departments/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id) {
		Departments deleteDepartment =departmentsService.getDepartmentById(id);
		if (deleteDepartment == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			departmentsService.deleteDepartment(deleteDepartment);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
}


