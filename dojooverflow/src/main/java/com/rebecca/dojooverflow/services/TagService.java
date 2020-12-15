package com.rebecca.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebecca.dojooverflow.models.Tag;
import com.rebecca.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository tagRepo; 
	
	//create and update
		public Tag saveTag(Tag tag) {
			return tagRepo.save(tag); 
		}
		
		//read
			//get all
		public List<Tag> allTags(){
			return tagRepo.findAll(); 
		}
		
		//find by subject
		
		public Tag findTag(String search) {
			return tagRepo.findFirstBySubjectContaining(search); 
		}

		//get by id
		public Tag findById(Long id) {
			Optional<Tag> tag = tagRepo.findById(id); 
			if(tag.isPresent()) {
				return tag.get(); 
			} else {
				return null; 
			}
		}
		
		
		//delete
		public void delete(Long id) {
			tagRepo.deleteById(id);
		}
}
