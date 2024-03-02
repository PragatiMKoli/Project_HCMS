package com.amigos.dao;

import java.util.List;

import com.amigos.entities.Roles;

public interface RolesDAO {
	

	List<Roles> getAllRoles();
	
	void addRole(Roles role);
	
	void updateRole(Roles role);
	
	void deleteRole(Roles role);
	
	Roles getRoleById(int id);


}
