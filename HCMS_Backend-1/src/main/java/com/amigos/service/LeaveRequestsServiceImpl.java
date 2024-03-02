package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.EmployeesDAO;
import com.amigos.dao.LeaveRequestsDAO;
import com.amigos.entities.Employees;
import com.amigos.entities.LeaveRequests;

@Service
public class LeaveRequestsServiceImpl implements LeaveRequestsService {

	@Autowired
	private LeaveRequestsDAO leaveRequestsDAO;

	@Override
	public List<LeaveRequests> getAllLeaveRequests() {
		return leaveRequestsDAO.getAllLeaveRequests();
	}

	@Override
	public void addLeaveRequest(LeaveRequests leaveRequests) {
		leaveRequestsDAO.addLeaveRequest(leaveRequests);
	}

	@Override
	public void updateLeaveRequest(LeaveRequests leaveRequests) {
		leaveRequestsDAO.updateLeaveRequest(leaveRequests);
	}

	@Override
	public void deleteLeaveRequest(LeaveRequests leaveRequests) {
		leaveRequestsDAO.deleteLeaveRequest(leaveRequests);
	}

	@Override
	public LeaveRequests getLeaveRequestById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
