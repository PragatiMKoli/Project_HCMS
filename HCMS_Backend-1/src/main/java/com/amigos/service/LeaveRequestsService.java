package com.amigos.service;

import java.util.List;

import com.amigos.entities.LeaveRequests;

public interface LeaveRequestsService {

List<LeaveRequests> getAllLeaveRequests();
	
	void addLeaveRequest(LeaveRequests leaveRequests);
	
	void updateLeaveRequest(LeaveRequests leaveRequests);
	
	void deleteLeaveRequest(LeaveRequests leaveRequests);
	
	LeaveRequests getLeaveRequestById(int id);
}
