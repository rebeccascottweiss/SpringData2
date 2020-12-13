package com.rebecca.driverslicense.controllers;

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

import com.rebecca.driverslicense.models.License;
import com.rebecca.driverslicense.models.Person;
import com.rebecca.driverslicense.services.LicenseService;
import com.rebecca.driverslicense.services.PersonService;

@Controller
public class MainController {
	@Autowired
	private PersonService personServ; 
	
	@Autowired
	private LicenseService licenseServ; 
	
	//route with form to create new person	
	@GetMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "/persons/new.jsp"; 
	}
	
	//create new person
	@PostMapping("/persons/new")
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "/persons/new.jsp"; 
		} else {
			personServ.createPerson(person); 
			return "redirect:/licenses/new"; 
		}
	}
	
	//route with form to create new license
	@GetMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> persons = personServ.allPersons(); 
		model.addAttribute("persons", persons); 
		return "/licenses/new.jsp"; 
	}
	
	//create new license
	@PostMapping("/licenses/new")
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors()) {
			return "/licenses/new.jsp"; 
		} else {
			String number = String.format("%05d", license.getPerson().getId()); 
			license.setNumber(number);
			licenseServ.createLicense(license); 
			return "redirect:/persons/" + license.getPerson().getId(); 
		}
	}
	
	//read one
	@GetMapping("/persons/{id}")
	public String showPerson(@PathVariable("id") Long id, Model model) {
		Person person = personServ.findPerson(id); 
		model.addAttribute("person", person); 
		return "/persons/show.jsp"; 
	}
}
