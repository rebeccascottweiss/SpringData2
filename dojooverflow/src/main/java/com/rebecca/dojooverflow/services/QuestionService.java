package com.rebecca.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebecca.dojooverflow.models.Question;
import com.rebecca.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	@Autowired 
	private QuestionRepository questRepo; 
	
	//create and update
	

	public Question saveQuestion(Question question) {
		return questRepo.save(question); 
	}
	//read
		//get all
	public List<Question> allQuestions(){
		return questRepo.findAll(); 
	}

	//getbyid
	public Question findById(Long id) {
		Optional<Question> quest = questRepo.findById(id); 
		if(quest.isPresent()) {
			return quest.get(); 
		} else {
			return null; 
		}
	}
	
	
	//delete
	public void delete(Long id) {
		questRepo.deleteById(id);
	}
}
