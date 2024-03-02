package com.amigos.service;

import java.util.List;

import com.amigos.entities.Users;

public interface UsersService {

List<Users> getAllUsers();
	
	void addUser(Users users);
	
	void updateUser(Users users);
	
	void deleteUser(Users users);
	
	Users getUserById(int id);
}
