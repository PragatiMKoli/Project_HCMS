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

import com.amigos.entities.Roles;
import com.amigos.service.RolesService;

@RestController
public class RolesController {
	@Autowired
	private RolesService rolesService;

	@GetMapping("/roles")
	private ResponseEntity<List<Roles>> getAll() {
		return new ResponseEntity<List<Roles>>(rolesService.getAllRoles(), HttpStatus.OK);
	}

	// @RequestMapping(value = "/employees", method = RequestMethod.POST)
	@PostMapping("/roles")
	private ResponseEntity<Void> save(@RequestBody Roles roles, UriComponentsBuilder ucBuilder) {
		if (roles == null) {
			throw new RuntimeException("Roles Object can 't  be NULL");
		}
		rolesService.addRole(roles);
		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(emp).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping("/roles/{id}")
	private ResponseEntity<Roles> get(@PathVariable int id) {
		Roles roles = rolesService.getRoleById(id);
		if (roles == null) {
			return new ResponseEntity<Roles>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Roles>(roles, HttpStatus.OK);
		}
	}

	@PutMapping("/roles/{id}")
	private ResponseEntity<Void> update(@RequestBody Roles toBeUpdateRoles, @PathVariable int id) {
//		if (toBeUpdateRoles == null) {
//			throw new RuntimeException("Roles Object can 't  be NULL");
//		}
		Roles existingRoles = rolesService.getRoleById(id);
		if (toBeUpdateRoles == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			rolesService.updateRole(toBeUpdateRoles);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

	@DeleteMapping("/roles/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id) {
		Roles deleteRoles = rolesService.getRoleById(id);
		if (deleteRoles == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			rolesService.deleteRole(deleteRoles);

			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

}
