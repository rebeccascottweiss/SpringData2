package com.rebecca.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebecca.productsandcategories.models.Product;
import com.rebecca.productsandcategories.repositories.ProductRepository;

@Service

public class ProductService {
	@Autowired
	private ProductRepository productRepo; 
	
	//create
	public Product createProduct(Product product) {
		return productRepo.save(product); 
	}
	
	//read
	public List<Product> allProducts(){
		return productRepo.findAll(); 
	}
	
	public Product findProduct(Long id) {
		Optional<Product> product = productRepo.findById(id);
		if(product.isPresent()) {
			return product.get(); 
		} else {
			return null; 
		}
	}
	
	//update
	
	public Product updateProduct(Product product) {
		return productRepo.save(product); 
	}
	
	//delete
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}
}
