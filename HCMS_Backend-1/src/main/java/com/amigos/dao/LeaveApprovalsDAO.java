package com.amigos.dao;

import java.util.List;

import com.amigos.entities.LeaveApprovals;

public interface LeaveApprovalsDAO {
	
	List<LeaveApprovals> getAllLeaveApprovals();
	
	void addLeaveApproval(LeaveApprovals leaveApprovals);
	
	void updateLeaveApproval(LeaveApprovals leaveApprovals);
	
	void deleteLeaveApproval(LeaveApprovals leaveApprovals);
	
	LeaveApprovals getLeaveApprovalById(int id);

}
