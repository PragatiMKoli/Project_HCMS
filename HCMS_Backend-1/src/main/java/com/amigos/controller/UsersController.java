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

import com.amigos.entities.Users;
import com.amigos.service.UsersService;

@RestController
public class UsersController {
	@Autowired
	private UsersService usersService;

	@GetMapping("/users")
	private ResponseEntity<List<Users>> getAll() {
		return new ResponseEntity<List<Users>>(usersService.getAllUsers(), HttpStatus.OK);
	}

	// @RequestMapping(value = "/employees", method = RequestMethod.POST)
	@PostMapping("/users")
	private ResponseEntity<Void> save(@RequestBody Users users, UriComponentsBuilder ucBuilder) {
		if (users == null) {
			throw new RuntimeException("Users Object can 't  be NULL");
		}
		usersService.addUser(users);
		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(emp).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping("/users/{id}")
	private ResponseEntity<Users> get(@PathVariable int id) {
		Users users = usersService.getUserById(id);
		if (users == null) {
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Users>(users, HttpStatus.OK);
		}
	}

	@PutMapping("/users/{id}")
	private ResponseEntity<Void> update(@RequestBody Users toBeUpdateUsers, @PathVariable int id) {
		if (toBeUpdateUsers == null) {
			throw new RuntimeException("Users Object can 't  be NULL");
		}
		Users existingUsers = usersService.getUserById(id);
		if (toBeUpdateUsers == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			usersService.updateUser(toBeUpdateUsers);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

	@DeleteMapping("/users/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id) {
		Users deleteUsers = usersService.getUserById(id);
		if (deleteUsers == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			usersService.deleteUser(deleteUsers);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

}
