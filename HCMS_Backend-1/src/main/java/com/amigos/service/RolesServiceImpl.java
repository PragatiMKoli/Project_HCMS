package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.RolesDAO;
import com.amigos.entities.Roles;

@Service
public class RolesServiceImpl implements RolesService {
	@Autowired
	private RolesDAO rolesDAO;

	@Override
	public List<Roles> getAllRoles() {
		
		return rolesDAO.getAllRoles();
	}

	@Override
	public void addRole(Roles role) {
		rolesDAO.addRole(role);
	}

	@Override
	public void updateRole(Roles role) {
		rolesDAO.updateRole(role);
	}

	@Override
	public void deleteRole(Roles role) {
		rolesDAO.deleteRole(role);
	}

	@Override
	public Roles getRoleById(int id) {
		return rolesDAO.getRoleById(id);
	}

}
