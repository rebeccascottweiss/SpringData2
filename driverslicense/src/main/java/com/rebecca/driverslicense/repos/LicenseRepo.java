package com.rebecca.driverslicense.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rebecca.driverslicense.models.License;

public interface LicenseRepo extends CrudRepository<License, Long>{
	List<License> findAll(); 
	
	List<License> findByExpirationDateEquals(String search); 
	
	
}
