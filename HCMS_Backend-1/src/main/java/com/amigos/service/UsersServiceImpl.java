package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.EmployeesDAO;
import com.amigos.dao.UsersDAO;
import com.amigos.entities.Employees;
import com.amigos.entities.Users;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersDAO usersDAO;

	@Override
	public List<Users> getAllUsers() {
		return usersDAO.getAllUsers();
	}

	@Override
	public void addUser(Users users) {
		usersDAO.addUser(users);
	}

	@Override
	public void updateUser(Users users) {
		usersDAO.updateUser(users);
	}

	@Override
	public void deleteUser(Users users) {
		usersDAO.deleteUser(users);
	}

	@Override
	public Users getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
