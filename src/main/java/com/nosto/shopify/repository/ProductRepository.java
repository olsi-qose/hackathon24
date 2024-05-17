package com.nosto.shopify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nosto.shopify.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
