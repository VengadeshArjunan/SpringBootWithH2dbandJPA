package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductJPARepository;

@Service
public class ProductService {
	@Autowired
	ProductJPARepository productJPArepository;
	
	public List<Product> findAll() {
		return productJPArepository.findAll();
	}
	public Product save(Product product) {
		return productJPArepository.save(product);
	}
	public Optional<Product> findById(long id) {
		return productJPArepository.findById(id);
	}
	public Product update(long id, Product product) {
		if(productJPArepository.existsById(id)) {
			return productJPArepository.save(product);
		}else {
			return null;
		}
	}
	public void deleteById(long id) {
		if(productJPArepository.existsById(id)) {
			productJPArepository.deleteById(id);
		}
	}
}
