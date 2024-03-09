package com.amigos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.amigos.entities.AppraisalForms;
import com.amigos.service.AppraisalFormsService;

@RestController
public class AppraisalFormsController {

	@Autowired
	private AppraisalFormsService appraisalFormsService;
	@GetMapping("/appraisalForms")
	private ResponseEntity<List<AppraisalForms>> get()
	{
		return new ResponseEntity<List<AppraisalForms>>(appraisalFormsService.getAllAppraisalForms(),HttpStatus.OK);
	}
	
	@PostMapping("/appraisalForms")
	private ResponseEntity<Void> saveAppraisalForms(@RequestBody AppraisalForms appraisalForms,UriComponentsBuilder uriComponentsBuilder)
	{
		if(appraisalForms == null)
		{
		throw new RuntimeException("Appraisal Forms Can't be null ");
		}
		
		appraisalFormsService.addAppraisalForm(appraisalForms);
		HttpHeaders httpHeaders=new HttpHeaders();
		return new ResponseEntity<Void>(httpHeaders,HttpStatus.CREATED);
	}
	
	@GetMapping("/appraisalForms/{id}")
	private ResponseEntity<AppraisalForms> getById(@PathVariable int id)
	{
		AppraisalForms appraisalForms=appraisalFormsService.getAppraisalFormById(id);
		if(appraisalForms==null)
		{
			return new ResponseEntity<AppraisalForms>(HttpStatus.NOT_FOUND);
		}else
		{
			return new ResponseEntity<AppraisalForms>(appraisalForms,HttpStatus.OK);
		}
	}
	@PutMapping("/appraisalForms/{id}")
	private ResponseEntity<Void> updateAppraisalForm(@RequestBody AppraisalForms toBeAppraisalForms,@PathVariable int id)
	{
		if(toBeAppraisalForms==null)
		{
			throw new RuntimeException("Appraisal Form can't Be null");
		}
		AppraisalForms existingAppraisalForms = appraisalFormsService.getAppraisalFormById(id);
		if(toBeAppraisalForms==null)
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else
		{
			appraisalFormsService.updateAppraisalForm(toBeAppraisalForms);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	private ResponseEntity<Void> deleteAppraisalForms(@PathVariable int id)
	{
		AppraisalForms appraisalForms=appraisalFormsService.getAppraisalFormById(id);
		if(appraisalForms==null)
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else
		{
			appraisalFormsService.deleteAppraisalForm(appraisalForms);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
}
