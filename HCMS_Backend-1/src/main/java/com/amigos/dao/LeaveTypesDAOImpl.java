package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.LeaveTypes;
import com.amigos.entities.Roles;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LeaveTypesDAOImpl implements LeaveTypesDAO {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<LeaveTypes> getAllLeaveTypes() {
		
		return entityManager.unwrap(Session.class).createQuery("FROM LeaveTypes").getResultList();
	}

	@Override
	public void addLeaveType(LeaveTypes leaveTypes) {
		entityManager.unwrap(Session.class).saveOrUpdate(leaveTypes);
	}

	@Override
	public void updateLeaveType(LeaveTypes leaveTypes) {
		entityManager.unwrap(Session.class).update(leaveTypes);
	}

	@Override
	public void deleteLeaveType(LeaveTypes leaveTypes) {
		entityManager.unwrap(Session.class).delete(leaveTypes);
	}

	@Override
	public LeaveTypes getLeaveTypeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
