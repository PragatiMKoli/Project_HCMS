package com.amigos.dao;

import java.util.List;

import com.amigos.entities.LeaveTypes;

public interface LeaveTypesDAO {
	
	List<LeaveTypes> getAllLeaveTypes();
	
	void addLeaveType(LeaveTypes leaveTypes);
	
	void updateLeaveType(LeaveTypes leaveTypes);
	
	void deleteLeaveType(LeaveTypes leaveTypes);
	
	LeaveTypes getLeaveTypeById(int id);

}
