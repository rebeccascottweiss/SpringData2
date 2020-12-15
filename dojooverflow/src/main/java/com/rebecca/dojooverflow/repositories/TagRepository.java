package com.rebecca.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rebecca.dojooverflow.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
	List<Tag> findAll(); 
	
	List<Tag> findBySubjectContaining(String search); 
	
	Tag findFirstBySubjectContaining(String search); 
}
