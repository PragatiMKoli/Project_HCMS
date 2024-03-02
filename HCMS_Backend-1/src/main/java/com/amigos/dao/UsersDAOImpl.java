package com.amigos.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amigos.entities.Roles;
import com.amigos.entities.Users;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UsersDAOImpl implements UsersDAO {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Users> getAllUsers() {
		return entityManager.unwrap(Session.class).createQuery("FROM Users").getResultList();
	}

	@Override
	public void addUser(Users users) {
		entityManager.unwrap(Session.class).saveOrUpdate(users);
	}

	@Override
	public void updateUser(Users users) {
		entityManager.unwrap(Session.class).update(users);
	}

	@Override
	public void deleteUser(Users users) {
		entityManager.unwrap(Session.class).delete(users);
	}

	@Override
	public Users getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
