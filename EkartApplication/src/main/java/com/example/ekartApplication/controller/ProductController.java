package com.example.ekartApplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ekartApplication.entity.Product;
import com.example.ekartApplication.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService ps;
@PostMapping("/create")	
public ResponseEntity<Product> create(@RequestBody Product product) {
	Product result=ps.createProduct(product);
	return ResponseEntity.status(HttpStatus.CREATED).body(result);
}
@GetMapping("/getAll")
public ResponseEntity<List<Product>> getAllDetails(){
	List<Product> details=ps.getAllDetails();
	return ResponseEntity.status(HttpStatus.ACCEPTED).body(details);
}
@GetMapping("/getById/{id}")
public Optional<Product> getById(@PathVariable Integer id) {
	Optional<Product> productDetails=ps.getById(id);
	return productDetails;
}
}//github
