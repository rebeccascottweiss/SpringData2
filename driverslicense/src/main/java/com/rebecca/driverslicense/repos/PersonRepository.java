package com.rebecca.driverslicense.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rebecca.driverslicense.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	List<Person> findAll();
	
	List<Person> findByFirstNameOrLastName(String search, String search2); 
	
	Long deleteByFirstNameOrLastName(String search, String search2); 
	
	List<Person> findByLicenseEquals(String search); 

}
