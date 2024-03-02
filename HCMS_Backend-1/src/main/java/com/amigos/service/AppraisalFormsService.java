package com.amigos.service;

import java.util.List;

import com.amigos.entities.AppraisalForms;

public interface AppraisalFormsService {

List<AppraisalForms> getAllAppraisalForms();
	
	void addAppraisalForm(AppraisalForms appraisalForms);
	
	void updateAppraisalForm(AppraisalForms appraisalForms);
	
	void deleteAppraisalForm(AppraisalForms appraisalForms);
	
	AppraisalForms getAppraisalFormById(int id);
}
