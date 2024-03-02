package com.amigos.dao;

import java.util.List;

import com.amigos.entities.AppraisalForms;

public interface AppraisalFormsDAO {
	
	List<AppraisalForms> getAllAppraisalForms();
	
	void addAppraisalForms(AppraisalForms appraisalForms);
	
	void updateAppraisalForms(AppraisalForms appraisalForms);
	
	void deleteAppraisalForms(AppraisalForms appraisalForms);
	
	AppraisalForms getAppraisalFormsById(int id);

}
