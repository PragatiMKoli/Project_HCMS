package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.LeaveApprovals;
import com.amigos.entities.Roles;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LeaveApprovalsDAOImpl implements LeaveApprovalsDAO {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<LeaveApprovals> getAllLeaveApprovals() {
		return entityManager.unwrap(Session.class).createQuery("FROM LeaveApprovals").getResultList();
	}

	@Override
	public void addLeaveApproval(LeaveApprovals leaveApprovals) {
		entityManager.unwrap(Session.class).saveOrUpdate(leaveApprovals);
	}

	@Override
	public void updateLeaveApproval(LeaveApprovals leaveApprovals) {
		entityManager.unwrap(Session.class).update(leaveApprovals);
	}

	@Override
	public void deleteLeaveApproval(LeaveApprovals leaveApprovals) {
		entityManager.unwrap(Session.class).delete(leaveApprovals);
	}

	@Override
	public LeaveApprovals getLeaveApprovalById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
