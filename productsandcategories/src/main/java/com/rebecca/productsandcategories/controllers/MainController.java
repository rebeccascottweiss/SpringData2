package com.rebecca.productsandcategories.controllers;

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

import com.rebecca.productsandcategories.models.Category;
import com.rebecca.productsandcategories.models.Product;
import com.rebecca.productsandcategories.services.CategoryService;
import com.rebecca.productsandcategories.services.ProductService;

@Controller
public class MainController {
	@Autowired
	private ProductService prodServ;
	
	@Autowired
	private CategoryService catServ; 
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "/products/new.jsp"; 
	}
	
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "/categories/new.jsp"; 
	}
	
	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return"/products/new.jsp"; 
		} else {
			prodServ.createProduct(product); 
			return "redirect:/products/" + product.getId(); 
		}
	}
	
	@PostMapping("/categories/new")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "/categories/new.jsp"; 
		} else {
			catServ.createCategory(category); 
			return "redirect:/categories/" + category.getId(); 
		}
	}
	
	@GetMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		model.addAttribute("product", prodServ.findProduct(id)); 
		return "/products/show.jsp"; 
	}
	
	@GetMapping("/categories/{id}")
	public String showCategories(@PathVariable("id") Long id, Model model, @ModelAttribute("product") Product product) {
		model.addAttribute("category", catServ.findCategory(id)); 
		return "/categories/show.jsp"; 
	}
	
	@PostMapping("/categories/{id}")
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "/categories.show.jsp"; 
		} else {
			Category cat = catServ.findCategory(id); 
			List<Product> products = cat.getProducts(); 
			products.add(product); 
			cat.setProducts(products);
			catServ.updateCategory(cat); 
		}
		return "redirect:/categories/show"; 
	}

}
