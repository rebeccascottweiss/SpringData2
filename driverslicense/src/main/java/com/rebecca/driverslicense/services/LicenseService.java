package com.rebecca.driverslicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebecca.driverslicense.models.License;
import com.rebecca.driverslicense.repos.LicenseRepo;

@Service
public class LicenseService {
	@Autowired
	private LicenseRepo licenseRepo; 
	
	//Create
	
	public License createLicense(License license) {
		return licenseRepo.save(license); 
	}
	//Read all
	
	public List<License> allLicenses() {
		return licenseRepo.findAll(); 
	}
	//Read one
	
	public License findLicense(Long id) {
		Optional<License> license = licenseRepo.findById(id); 
		if(license.isPresent()) {
			return license.get(); 
		} else {
			return null; 
		}
	}
	//Update
	public License updateLicense(License license) {
		return licenseRepo.save(license); 
	}
	//Delete
	public void deleteLicense(Long id) {
		licenseRepo.deleteById(id);
	}
}
