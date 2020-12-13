package com.rebecca.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebecca.dojosandninjas.models.Ninja;
import com.rebecca.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	@Autowired
	private NinjaRepository ninjaRepo; 
	
	//Create
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja); 
	}
	//Read
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll(); 
	}
	
	public Ninja findNinja(Long id) {
		Optional<Ninja> ninja = ninjaRepo.findById(id); 
		if(ninja.isPresent()) {
			return ninja.get(); 
		} else {
			return null; 
		}
	}
	//Update
	
	public Ninja updateNinja(Ninja ninja) {
		return ninjaRepo.save(ninja); 
	}
	//Delete
	
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
	}
}
