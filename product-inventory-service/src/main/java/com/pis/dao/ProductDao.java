package com.pis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pis.entity.Product;
import com.pis.repository.ProductRepository;

@Repository
public class ProductDao {
	@Autowired
	private ProductRepository productRepository;

	// createProduct

	public  Product createProduct(Product product) {
		return productRepository.save(product);
	}

	// getAllProduct
	// getProductById
	// updateProduct
	// deleteById

}
