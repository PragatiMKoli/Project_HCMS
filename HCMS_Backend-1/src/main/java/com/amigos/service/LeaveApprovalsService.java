package com.amigos.service;

import java.util.List;

import com.amigos.entities.LeaveApprovals;

public interface LeaveApprovalsService {

List<LeaveApprovals> getAllLeaveApprovals();
	
	void addLeaveApproval(LeaveApprovals leaveApprovals);
	
	void updateLeaveApproval(LeaveApprovals leaveApprovals);
	
	void deleteLeaveApproval(LeaveApprovals leaveApprovals);
	
	LeaveApprovals getLeaveApprovalById(int id);
}
