package com.rebecca.driverslicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebecca.driverslicense.models.Person;
import com.rebecca.driverslicense.repos.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepo; 
	
	//Create
	
	public Person createPerson(Person person) {
		return personRepo.save(person); 
	}
	//Read all
	
	public List<Person> allPersons() {
		return personRepo.findAll(); 
	}
	//Read one
	
	public Person findPerson(Long id) {
		Optional<Person> person = personRepo.findById(id); 
		if(person.isPresent()) {
			return person.get(); 
		} else {
			return null; 
		}
	}
	//Update
	public Person updatePerson(Person person) {
		return personRepo.save(person); 
	}
	//Delete
	public void deletePerson(Long id) {
		personRepo.deleteById(id);
	}
}
