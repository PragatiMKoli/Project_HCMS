package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.EmployeesDAO;
import com.amigos.dao.PayrollDAO;
import com.amigos.entities.Employees;
import com.amigos.entities.Payroll;

@Service
public class PayrollServiceImpl implements PayrollService{

	@Autowired
	private PayrollDAO payrollDAO;

	@Override
	public List<Payroll> getAllPayroll() {
		return payrollDAO.getAllPayroll();
	}

	@Override
	public void addPayroll(Payroll payroll) {
		payrollDAO.addPayroll(payroll);
	}

	@Override
	public void updatePayroll(Payroll payroll) {
		payrollDAO.updatePayroll(payroll);
	}

	@Override
	public void deletePayroll(Payroll payroll) {
		payrollDAO.deletePayroll(payroll);
	}

	@Override
	public Payroll getPayrollById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
