package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.EmployeesDAO;
import com.amigos.dao.LeaveApprovalsDAO;
import com.amigos.entities.Employees;
import com.amigos.entities.LeaveApprovals;

@Service
public class LeaveApprovalsServiceImpl implements LeaveApprovalsService{

	@Autowired
	private LeaveApprovalsDAO leaveApprovalsDAO;

	@Override
	public List<LeaveApprovals> getAllLeaveApprovals() {
		return leaveApprovalsDAO.getAllLeaveApprovals();
	}

	@Override
	public void addLeaveApproval(LeaveApprovals leaveApprovals) {
		leaveApprovalsDAO.addLeaveApproval(leaveApprovals);
	}

	@Override
	public void updateLeaveApproval(LeaveApprovals leaveApprovals) {
		leaveApprovalsDAO.updateLeaveApproval(leaveApprovals);
	}

	@Override
	public void deleteLeaveApproval(LeaveApprovals leaveApprovals) {
		leaveApprovalsDAO.deleteLeaveApproval(leaveApprovals);
	}

	@Override
	public LeaveApprovals getLeaveApprovalById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
