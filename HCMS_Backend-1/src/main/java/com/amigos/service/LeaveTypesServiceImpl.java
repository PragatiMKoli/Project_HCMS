package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.EmployeesDAO;
import com.amigos.dao.LeaveTypesDAO;
import com.amigos.entities.Employees;
import com.amigos.entities.LeaveTypes;

@Service
public class LeaveTypesServiceImpl implements LeaveTypesService{

	@Autowired
	private LeaveTypesDAO leaveTypesDAO;

	@Override
	public List<LeaveTypes> getAllLeaveTypes() {
		return leaveTypesDAO.getAllLeaveTypes();
	}

	@Override
	public void addLeaveType(LeaveTypes leaveTypes) {
		leaveTypesDAO.addLeaveType(leaveTypes);
	}

	@Override
	public void updateLeaveType(LeaveTypes leaveTypes) {
		leaveTypesDAO.updateLeaveType(leaveTypes);
	}

	@Override
	public void deleteLeaveType(LeaveTypes leaveTypes) {
		leaveTypesDAO.deleteLeaveType(leaveTypes);
	}

	@Override
	public LeaveTypes getLeaveTypeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
