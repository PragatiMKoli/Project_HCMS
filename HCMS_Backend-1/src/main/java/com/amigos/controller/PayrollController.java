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

import com.amigos.entities.Payroll;
import com.amigos.service.PayrollService;


@RestController
public class PayrollController {
	@Autowired
	private PayrollService payrollService;

	@GetMapping("/payroll")
	private ResponseEntity<List<Payroll>> getAll() {
		return new ResponseEntity<List<Payroll>>(payrollService.getAllPayroll(), HttpStatus.OK);
	}

	// @RequestMapping(value = "/employees", method = RequestMethod.POST)
	@PostMapping("/payroll")
	private ResponseEntity<Void> save(@RequestBody Payroll payroll, UriComponentsBuilder ucBuilder) {
		if (payroll == null) {
			throw new RuntimeException("Payroll Object can 't  be NULL");
		}
		payrollService.addPayroll(payroll);
		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("employees/{id}").buildAndExpand(emp).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping("/payroll/{id}")
	private ResponseEntity<Payroll> get(@PathVariable int id) {
		Payroll payroll = payrollService.getPayrollById(id);
		if (payroll == null) {
			return new ResponseEntity<Payroll>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Payroll>(payroll, HttpStatus.OK);
		}
	}

	@PutMapping("/payroll/{id}")
	private ResponseEntity<Void> update(@RequestBody Payroll toBeUpdatePayroll, @PathVariable int id) {
		if (toBeUpdatePayroll == null) {
			throw new RuntimeException("Employee Object can 't  be NULL");
		}
		Payroll existingPayroll = payrollService.getPayrollById(id);
		if (toBeUpdatePayroll == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			payrollService.deletePayroll(toBeUpdatePayroll);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

	@DeleteMapping("/payroll/{id}")
	private ResponseEntity<Void> delete(@PathVariable int id) {
		Payroll payroll = payrollService.getPayrollById(id);
		if (payroll == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			payrollService.deletePayroll(payroll);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}


}
