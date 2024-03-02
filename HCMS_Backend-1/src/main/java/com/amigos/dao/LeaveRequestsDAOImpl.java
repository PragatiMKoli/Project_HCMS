package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.LeaveRequests;
import com.amigos.entities.Roles;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LeaveRequestsDAOImpl implements LeaveRequestsDAO {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<LeaveRequests> getAllLeaveRequests() {
		return entityManager.unwrap(Session.class).createQuery("FROM LeaveRequests").getResultList();
	}

	@Override
	public void addLeaveRequest(LeaveRequests leaveRequests) {
		entityManager.unwrap(Session.class).saveOrUpdate(leaveRequests);
	}

	@Override
	public void updateLeaveRequest(LeaveRequests leaveRequests) {
		entityManager.unwrap(Session.class).update(leaveRequests);
	}

	@Override
	public void deleteLeaveRequest(LeaveRequests leaveRequests) {
		entityManager.unwrap(Session.class).delete(leaveRequests);
	}

	@Override
	public LeaveRequests getLeaveRequestById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
