package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.AppraisalFormsDAO;
import com.amigos.dao.EmployeesDAO;
import com.amigos.entities.AppraisalForms;
import com.amigos.entities.Employees;

@Service
public class AppraisalFormsServiceImpl implements AppraisalFormsService{

	@Autowired
	private AppraisalFormsDAO appraisalFormsDAO;

	@Override
	public List<AppraisalForms> getAllAppraisalForms() {
		
		return appraisalFormsDAO.getAllAppraisalForms();
	}

	@Override
	public void addAppraisalForm(AppraisalForms appraisalForms) {
		appraisalFormsDAO.addAppraisalForms(appraisalForms);
	}

	@Override
	public void updateAppraisalForm(AppraisalForms appraisalForms) {
		appraisalFormsDAO.updateAppraisalForms(appraisalForms);
	}

	@Override
	public void deleteAppraisalForm(AppraisalForms appraisalForms) {
		appraisalFormsDAO.deleteAppraisalForms(appraisalForms);	
		}

	@Override
	public AppraisalForms getAppraisalFormById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
}
