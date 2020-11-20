package com.example.demoSpringProj.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContainsIgnoreCase(String name);

    List<Product> findByDescriptionContainsIgnoreCase(String description);
    List<Product> findByNameContainsIgnoreCaseAndDescriptionContainsIgnoreCase(String name,String description);
 }
