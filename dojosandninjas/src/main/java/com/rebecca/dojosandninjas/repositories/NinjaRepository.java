package com.rebecca.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rebecca.dojosandninjas.models.Dojo;
import com.rebecca.dojosandninjas.models.Ninja;


@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll(); 
	
	List<Ninja> findByFirstNameOrLastName(String search1, String search2); 
	
	Long countByDojo(Dojo dojo); 
}
