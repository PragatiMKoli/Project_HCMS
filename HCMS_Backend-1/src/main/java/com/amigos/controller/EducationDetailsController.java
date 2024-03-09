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

import com.amigos.entities.EducationDetails;
import com.amigos.service.EducationDetailsService;

@RestController
public class EducationDetailsController {

	@Autowired
	private EducationDetailsService educationDetailsService;
	
	@GetMapping("/educationDetails")
	private ResponseEntity<List<EducationDetails>> getAll()
	{
		return new ResponseEntity<List<EducationDetails>>(educationDetailsService.getAllEducationDetails(),HttpStatus.OK);
	}
	
	@PostMapping("/educationDetails")
	private ResponseEntity<Void> saveEducationDetails(@RequestBody EducationDetails educationDetails,UriComponentsBuilder componentsBuilder)
	{
		if(educationDetails==null)
		{
			throw new RuntimeException("Education Details Object Can't Be null");
		}
		educationDetailsService.addEducationDetail(educationDetails);
		HttpHeaders httpHeaders=new HttpHeaders();
		return new ResponseEntity<Void>(httpHeaders,HttpStatus.CREATED);
	}
	
	@GetMapping("educationDetails/{id}")
	private ResponseEntity<EducationDetails> getById(@PathVariable int id)
	{
		EducationDetails educationDetails=educationDetailsService.getEducationDetailById(id);
		if(educationDetails==null)
		{
			return new ResponseEntity<EducationDetails>(HttpStatus.NOT_FOUND);
		}else
		{
			return new ResponseEntity<EducationDetails>(educationDetails,HttpStatus.OK);
		}
	}
	
	@PutMapping("/educationDetails/{id}")
	private ResponseEntity<Void> updateEducationDetails(@RequestBody EducationDetails toBeEducationDetails,@PathVariable int id)
	{
		if(toBeEducationDetails==null)
		{
			throw new RuntimeException("Education Details Object Can't Be Null");
		}
		EducationDetails existingEducationDetails=educationDetailsService.getEducationDetailById(id);
	    if(toBeEducationDetails==null)
	    {
	    	return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	    }else
	    {
	    	educationDetailsService.updateEducationDetail(existingEducationDetails);
	    	return new ResponseEntity<Void>(HttpStatus.OK);
	}}
	
	    @DeleteMapping("/educationDetails/{id}")
	private ResponseEntity<Void> deleteEducationDetails(@PathVariable int id)
	{
		EducationDetails deleteEducationDetails=educationDetailsService.getEducationDetailById(id);
        if(deleteEducationDetails==null)
        {
        	return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }else
        {
        	educationDetailsService.deleteEducationDetail(deleteEducationDetails);
        	return new ResponseEntity<Void>(HttpStatus.OK);
        }
	}
}
