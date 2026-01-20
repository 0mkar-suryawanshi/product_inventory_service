package com.pis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pis.entity.Product;
import com.pis.entity.ResponseStructure;
import com.pis.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService produtService;
	
	@PostMapping(value = "/productCreated")
	public ResponseEntity<ResponseStructure<Product>> createProduct(@RequestBody Product product) {
		return produtService.createProduct(product);
	}
	
}
