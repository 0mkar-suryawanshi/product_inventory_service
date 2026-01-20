package com.pis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pis.entity.Product;
import com.pis.entity.ResponseStructure;
import com.pis.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping(value = "/productCreated")
	public ResponseEntity<ResponseStructure<Product>> createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@GetMapping(value = "/getAllProduct")
	public ResponseEntity<ResponseStructure<List<Product>>> getAllProduct() {
		return productService.getAllProduct();
	}

	@GetMapping(value = "/getProduct/{id}")
	public ResponseEntity<ResponseStructure<Optional<Product>>> getProductById(@PathVariable Long id) {

		return productService.getProductById(id);
	}

	@PutMapping(value = "/updateProduct/{id}")
	public ResponseEntity<ResponseStructure<Product>> updateProductById(@RequestBody Product product, @PathVariable Long id) {
		return productService.updateProductById(product, id);

	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable Long id) {
		return productService.deleteById(id);

	}

}
