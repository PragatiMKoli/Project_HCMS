package com.amigos.service;

import java.util.List;

import com.amigos.entities.Certifications;

public interface CertificationsService {

List<Certifications> getAllCertifications();
	
	void addCertification(Certifications certifications);
	
	void updateCertification(Certifications certifications);
	
	void deleteCertification(Certifications certifications);
	
	Certifications getCertificationById(int id);
}
