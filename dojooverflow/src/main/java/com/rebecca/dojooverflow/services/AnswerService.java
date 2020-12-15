package com.rebecca.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebecca.dojooverflow.models.Answer;
import com.rebecca.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	@Autowired
	private AnswerRepository answerRepo; 
	
	//create and update
		public Answer saveAnswer(Answer answer) {
			return answerRepo.save(answer); 
		}
		//read
			//get all
		public List<Answer> allAnswers(){
			return answerRepo.findAll(); 
		}

		//getbyid
		public Answer findById(Long id) {
			Optional<Answer> answer = answerRepo.findById(id); 
			if(answer.isPresent()) {
				return answer.get(); 
			} else {
				return null; 
			}
		}
		
		
		//delete
		public void delete(Long id) {
			answerRepo.deleteById(id);
		}
}
