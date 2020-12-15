package com.rebecca.dojosandninjas.controllers;

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

import com.rebecca.dojosandninjas.models.Dojo;
import com.rebecca.dojosandninjas.models.Ninja;
import com.rebecca.dojosandninjas.services.DojoService;
import com.rebecca.dojosandninjas.services.NinjaService;

@Controller

public class MainController {
	@Autowired
	private DojoService dojoServ; 
	
	@Autowired 
	private NinjaService ninjaServ; 
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojos/new.jsp"; 
	}
	
	@PostMapping("/dojos/new")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojos/new.jsp"; 
		} else {
			dojoServ.createDojo(dojo); 
			return "redirect:/ninjas/new"; 	
		}
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> myDojos = dojoServ.allDojos(); 
		model.addAttribute("dojos", myDojos); 
		return "/ninjas/new.jsp"; 
	}
	
	@PostMapping("/ninjas/new")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "/ninjas/new.jsp"; 
		} else {
			ninjaServ.createNinja(ninja); 
			return "redirect:/ninjas/new"; 
		}
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoServ.findDojo(id);
		System.out.println(dojo); 
		if(dojo != null) {
			
			List<Ninja> ninjas = dojo.getNinjas(); 
			model.addAttribute("ninjas", ninjas); 		
			}
		model.addAttribute("dojo", dojo); 
				
		return "/dojos/dojoInfo.jsp"; 
	}

}
