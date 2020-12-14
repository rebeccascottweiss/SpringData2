package com.rebecca.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebecca.productsandcategories.models.Category;
import com.rebecca.productsandcategories.repositories.CategoryRepository;

@Service

public class CategoryService {
	@Autowired
	private CategoryRepository catRepo; 
	
	//create
	public Category createCategory(Category category) {
		return catRepo.save(category); 
	}
	//read
	
	public List<Category> allCategories(){
		return catRepo.findAll(); 
	}
	
	public Category findCategory(Long id) {
		Optional<Category> cat = catRepo.findById(id); 
		if (cat.isPresent()) {
			return cat.get();
		} else {
			return null; 
		}
	}
	//update
	
	public Category updateCategory(Category category) {
		return catRepo.save(category); 
	}
	
	//delete
	public void deleteCategory(Long id) {
		catRepo.deleteById(id);
	}

}
