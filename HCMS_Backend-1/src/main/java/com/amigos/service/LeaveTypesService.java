package com.amigos.service;

import java.util.List;

import com.amigos.entities.LeaveTypes;

public interface LeaveTypesService {

List<LeaveTypes> getAllLeaveTypes();
	
	void addLeaveType(LeaveTypes leaveTypes);
	
	void updateLeaveType(LeaveTypes leaveTypes);
	
	void deleteLeaveType(LeaveTypes leaveTypes);
	
	LeaveTypes getLeaveTypeById(int id);
}
