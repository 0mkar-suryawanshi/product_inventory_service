package com.pis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pis.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
