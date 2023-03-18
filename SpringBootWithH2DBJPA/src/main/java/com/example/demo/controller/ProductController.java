package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;


@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public List<Product> findAll(){
		return productService.findAll();
	}
	@PostMapping("/products")
	public ResponseEntity<Product> save(@RequestBody Product product) {
		Product prod = productService.save(product);
		return new ResponseEntity<Product>(product, HttpStatus.CREATED);

	}
	
	@GetMapping("/products/{id}")
	public Optional<Product> findById(@PathVariable("id") long id) {
		return productService.findById(id);

	}
	@PutMapping("/products/{id}")
	public Product update(@PathVariable("id") long id, @RequestBody Product product) {
		return productService.update(id,product);

	}
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") long id) {
		productService.deleteById(id);
		 return new ResponseEntity(HttpStatus.CREATED);
	}
}
