package com.amigos.dao;

import java.util.List;

import com.amigos.entities.LeaveRequests;

public interface LeaveRequestsDAO {
	
	List<LeaveRequests> getAllLeaveRequests();
	
	void addLeaveRequest(LeaveRequests leaveRequests);
	
	void updateLeaveRequest(LeaveRequests leaveRequests);
	
	void deleteLeaveRequest(LeaveRequests leaveRequests);
	
	LeaveRequests getLeaveRequestById(int id);

}
