package com.rebecca.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rebecca.dojooverflow.models.Answer;
import com.rebecca.dojooverflow.models.Question;
import com.rebecca.dojooverflow.models.Tag;
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
	public String newQuestion(@ModelAttribute("question") Question quest) {
		return "/questions/new.jsp"; 
	}
	
	@PostMapping("/questions/new")
	public String createQuestion(@Valid @ModelAttribute("question") Question quest, BindingResult result, RedirectAttributes flash ) {
		if(result.hasErrors()) {
			System.out.println(result); 
			return "/questions/new.jsp"; 
		}
		List<String> tagList = quest.getTagList(); 
		if(tagList.size()>3) {
			flash.addFlashAttribute("err", "You can use a max of 3 tags.");
			return "redirect:/questions/new"; 
		}
		
		List<Tag> questTags = new ArrayList<Tag>(); 
		
		for(String tag : tagList) {
			Tag userTag = tagServ.findTag(tag); 
			if(userTag == null) {
				Tag temp = tagServ.saveTag(new Tag(tag));
				questTags.add(temp); 
			} else {
				questTags.add(userTag); 
			}
		}
		quest.setTags(questTags);
		questServ.saveQuestion(quest); 
		return "redirect:/questions"; 		
	}
	
	@GetMapping("/questions/{id}")
	public String showQuestion(@PathVariable("id") Long id, Model model, @ModelAttribute("answer") Answer answer) {
		Question quest = questServ.findById(id);
		model.addAttribute("question", quest); 
		return "/questions/show.jsp"; 
	}
	
	@PostMapping("/createAnswer")
	public String createAnswer(@Valid @ModelAttribute("answer") Answer answer, BindingResult result) {
		if(result.hasErrors()) {
			return "/questions/show.jsp"; 
		}
		Answer newAnswer = answer; 
		anServ.saveAnswer(newAnswer); 
		return "redirect:/questions/" + answer.getQuestion().getId() ; 
	}
	
	
}
