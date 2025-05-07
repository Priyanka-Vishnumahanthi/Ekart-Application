package com.example.ekartApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ekartApplication.entity.Product;
import com.example.ekartApplication.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepo;
public Product createProduct(Product product) {
	Product result=productRepo.save(product);
	return result;
}
public List<Product> getAllDetails(){
  return productRepo.findAll();	
}
public Optional<Product> getById(Integer id) {
	Optional<Product> result=productRepo.findById(id);
	if(result.isEmpty()) {
		throw new RuntimeException("list is empty");
	}
	return result;
}
}
