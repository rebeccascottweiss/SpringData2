package com.rebecca.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rebecca.dojosandninjas.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {
	List<Dojo> findAll(); 
	
	List<Dojo> findByNameContaining(String search); 
	
	Long countByNameContaining(String search); 
}
