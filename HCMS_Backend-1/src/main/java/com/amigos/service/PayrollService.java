package com.amigos.service;

import java.util.List;

import com.amigos.entities.Payroll;

public interface PayrollService {

List<Payroll> getAllPayroll();
	
	void addPayroll(Payroll payroll);
	
	void updatePayroll(Payroll payroll);
	
	void deletePayroll(Payroll payroll);
	
	Payroll getPayrollById(int id);
}
