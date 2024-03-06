package com.amigos.dao;

import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.Payroll;
import com.amigos.entities.Roles;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PayRollDAOImpl implements PayrollDAO {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Payroll> getAllPayroll() {
		
		return entityManager.unwrap(Session.class).createQuery("From PayRoll").getResultList();
	}

	@Override
	public void addPayroll(Payroll payroll) {
		entityManager.unwrap(Session.class).saveOrUpdate(payroll);
	}

	@Override
	public void updatePayroll(Payroll payroll) {
		entityManager.unwrap(Session.class).merge(payroll);
	}

	@Override
	public void deletePayroll(Payroll payroll) {
		entityManager.unwrap(Session.class).remove(payroll);
	}

	@Override
	public Payroll getPayrollById(int id) {
		
		return entityManager.unwrap(Session.class).get(Payroll.class, id);
	}

	

}
