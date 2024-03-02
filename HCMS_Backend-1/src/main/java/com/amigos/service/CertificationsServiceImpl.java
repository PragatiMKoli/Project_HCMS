package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.CertificationsDAO;
import com.amigos.dao.EmployeesDAO;
import com.amigos.entities.Certifications;
import com.amigos.entities.Employees;

@Service
public class CertificationsServiceImpl implements CertificationsService {

	@Autowired
	private CertificationsDAO certificationsDAO;

	@Override
	public List<Certifications> getAllCertifications() {

		return certificationsDAO.getAllCertifications();
	}

	@Override
	public void addCertification(Certifications certifications) {
		certificationsDAO.addCertification(certifications);
	}

	@Override
	public void updateCertification(Certifications certifications) {
		certificationsDAO.updateCertification(certifications);
	}

	@Override
	public void deleteCertification(Certifications certifications) {
		certificationsDAO.deleteCertification(certifications);
	}

	@Override
	public Certifications getCertificationById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
