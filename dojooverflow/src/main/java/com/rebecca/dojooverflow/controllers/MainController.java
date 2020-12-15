package com.rebecca.dojooverflow.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rebecca.dojooverflow.models.Answer;
import com.rebecca.dojooverflow.models.Question;
import com.rebecca.dojooverflow.services.AnswerService;
import com.rebecca.dojooverflow.services.QuestionService;
import com.rebecca.dojooverflow.services.TagService;

@Controller
public class MainController {
	@Autowired
	private QuestionService questServ; 
	
	@Autowired
	private AnswerService anServ;
	
	@Autowired
	private TagService tagServ; 
	
	
	@GetMapping("/")
	public String index() {
		return "index.jsp"; 
	}
	
	@GetMapping("/questions")
	public String dashboard(Model model) {
		model.addAttribute("questions", questServ.allQuestions()); 
		return "/questions/dashboard.jsp"; 
	}
	
	@GetMapping("/questions/new")
	public String newQuestion() {
		return "/questions/new.jsp"; 
	}
	
	@PostMapping("/questions/new")
	public String createQuestion(@Valid @ModelAttribute("question") Question quest, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println(result.toString());
			return "/questions/new.jsp"; 
		}
		questServ.saveQuestion(quest); 
		return "redirect:/questions"; 		
	}
	
	@GetMapping("/questions/{id}")
	public String showQuestion(@PathVariable("id") Long id, Model model, @ModelAttribute("answer") Answer answer) {
		Question quest = questServ.findById(id);
		model.addAttribute("question", quest); 
		return "/questions/show.jsp"; 
	}
	
	@PostMapping("/questions/{id}")
	public String createAnswer(@PathVariable("id") Long id, @Valid @ModelAttribute("answer") Answer answer, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println(result.toString()); 
			return "/questions/show.jsp"; 
		} else {
			anServ.saveAnswer(answer); 
		}
		return "redirect:/questions/" + id; 
	}
	
	
}
