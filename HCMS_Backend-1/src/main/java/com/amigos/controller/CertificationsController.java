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

import com.amigos.entities.Certifications;
import com.amigos.service.CertificationsService;

@RestController
public class CertificationsController {
	@Autowired
	private CertificationsService certificationsService;
	
	@GetMapping("/certifications")
	private ResponseEntity<List<Certifications>> getAll()
	{
		return new ResponseEntity<List<Certifications>>(certificationsService.getAllCertifications(),HttpStatus.OK);
	}
	
	@PostMapping("/certifications")
	private ResponseEntity<Void> saveCertifications(@RequestBody Certifications certifications,UriComponentsBuilder componentsBuilder)
	{
		if(certifications==null)
		{
			throw new RuntimeException("Certification Object Can't be Null");
		}
		certificationsService.addCertification(certifications);
		HttpHeaders httpHeaders=new HttpHeaders();
		return new ResponseEntity<Void>(httpHeaders,HttpStatus.CREATED);
	}
	
	@GetMapping("/certifications/{id}")
	private ResponseEntity<Certifications> getById(@PathVariable int id)
	{
		Certifications certifications=certificationsService.getCertificationById(id);
		if(certifications==null)
		{
			return new ResponseEntity<Certifications>(HttpStatus.NOT_FOUND);
		}else
		{
			return new ResponseEntity<Certifications>(certifications,HttpStatus.OK);
		}
	}
	@PutMapping("/certifications/{id}")
	private ResponseEntity<Void> updateCertifications(@RequestBody Certifications toBeCertifications,@PathVariable int id)
	{
		if(toBeCertifications==null)
		{
			throw new RuntimeException("Certificaion Object Can'T Be null");
		}
		Certifications  certifications=certificationsService.getCertificationById(id);
		
		if(toBeCertifications==null)
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else
		{
			certificationsService.updateCertification(toBeCertifications);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/certifications/{id}")
	private ResponseEntity<Void> deleteCertifications(@PathVariable int id)
	{
		Certifications certifications=certificationsService.getCertificationById(id);
		if(certifications==null)
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else
		{
			certificationsService.deleteCertification(certifications);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
}
