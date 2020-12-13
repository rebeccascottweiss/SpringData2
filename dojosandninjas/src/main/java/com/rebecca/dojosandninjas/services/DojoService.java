package com.rebecca.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebecca.dojosandninjas.models.Dojo;
import com.rebecca.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dojoRepo; 
	
	//create
	//create a new dojo
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo); 
	}
	//read
	public List<Dojo> allDojos(){
		return dojoRepo.findAll(); 
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> dojo = dojoRepo.findById(id);
		if(dojo.isPresent()) {
			return dojo.get(); 
		} else {
			return null; 
		}
	}
	//update
	public Dojo updateDojo(Dojo dojo) {
		return dojoRepo.save(dojo); 
	}
	//delete
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}
}
