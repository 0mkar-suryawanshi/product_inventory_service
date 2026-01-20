package com.pis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pis.dao.ProductDao;
import com.pis.entity.Product;
import com.pis.entity.ResponseStructure;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	public ResponseEntity<ResponseStructure<Product>> createProduct(Product product) {
		ResponseStructure<Product> structure = new ResponseStructure<>();
		structure.setData(productDao.createProduct(product));
		structure.setMessage("Product save Successfully");
		structure.setStatuscode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.CREATED);
	}

}
