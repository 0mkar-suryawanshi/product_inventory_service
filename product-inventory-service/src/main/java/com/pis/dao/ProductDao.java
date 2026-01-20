package com.pis.dao;

import java.util.List;
import java.util.Optional;

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
	
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	
	// getProductById
	
	public Optional<Product> getProductById(long id)
	{
		return productRepository.findById(id);
	}
	
	// updateProduct
	public Product updateProductById(Product product, long id)
	{
		return productRepository.save(product);
	}
	// deleteById
	public boolean deleteById(long id) {
		Optional<Product>recProduct = getProductById(id);
		if(recProduct.isPresent())
		{
			productRepository.delete(recProduct.get());
			return true;
		}
		return false;
		
	}

}
