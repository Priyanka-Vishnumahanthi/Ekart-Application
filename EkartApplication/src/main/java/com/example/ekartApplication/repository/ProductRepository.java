package com.example.ekartApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ekartApplication.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
