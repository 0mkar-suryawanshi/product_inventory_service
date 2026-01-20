package com.pis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pis.dao.ProductDao;
import com.pis.entity.Product;
import com.pis.entity.ResponseStructure;
import com.pis.exception.ProductNotFoundException;

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

	// API GET ALL PRODUCT
	public ResponseEntity<ResponseStructure<List<Product>>> getAllProduct() {
		ResponseStructure<List<Product>> structure = new ResponseStructure<>();
		List<Product> recProduct = productDao.getAllProduct();

		if (recProduct.size() > 0) {
			structure.setMessage("Product Found");
			structure.setData(recProduct);
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Product>>>(structure, HttpStatus.OK);
		}
		throw new ProductNotFoundException("Product Not Found");

	}

	// API Find Product By ID
	public ResponseEntity<ResponseStructure<Optional<Product>>> getProductById(Long id) {
		ResponseStructure<Optional<Product>> structure = new ResponseStructure<>();
		Optional<Product> recProduct = productDao.getProductById(id);
		if (recProduct.isPresent()) {
			structure.setMessage("Product Found");
			structure.setData(recProduct);
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Optional<Product>>>(structure, HttpStatus.OK);
		}
		throw new ProductNotFoundException("Id " + id + " Product Not Found");

	}

	// API Update Product By Id
	public ResponseEntity<ResponseStructure<Product>> updateProductById(Product product, Long id) {
		ResponseStructure<Product> structure = new ResponseStructure<>();
		Optional<Product> recProduct = productDao.getProductById(id);
		if (recProduct.isPresent()) {
			Product existProduct = recProduct.get();
			existProduct.setName(product.getName());
			existProduct.setCatogory(product.getCatogory());
			existProduct.setQuantity(product.getQuantity());
			existProduct.setPrice(product.getPrice());
			existProduct.setStatus(product.getStatus());

			Product updateProduct = productDao.createProduct(existProduct);

			structure.setMessage("Product Updated Successfully");
			structure.setData(updateProduct);
			structure.setStatuscode(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.OK);

		}
		throw new ProductNotFoundException("Product Not Found By Id : " + id);

	}

	// API Delete Product BY Id
	public ResponseEntity<ResponseStructure<String>> deleteById(Long id) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<Product> recProduct = productDao.getProductById(id);

		if (recProduct.isPresent()) {
			productDao.deleteById(id);
			structure.setMessage("Product Delete By Id");
			structure.setData("Delete Successfully");
			structure.setStatuscode(HttpStatus.NO_CONTENT.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NO_CONTENT);

		}
		throw new ProductNotFoundException("Prodcut Not Found in the ID Of "+id);
	}

}
