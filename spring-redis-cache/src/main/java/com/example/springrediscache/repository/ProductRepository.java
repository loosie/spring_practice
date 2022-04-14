package com.example.springrediscache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springrediscache.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
