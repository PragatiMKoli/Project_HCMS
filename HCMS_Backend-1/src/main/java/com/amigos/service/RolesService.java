package com.amigos.service;

import java.util.List;

import com.amigos.entities.Roles;

public interface RolesService {

List<Roles> getAllRoles();
	
	void addRole(Roles role);
	
	void updateRole(Roles role);
	
	void deleteRole(Roles role);
	
	Roles getRoleById(int id);
}
