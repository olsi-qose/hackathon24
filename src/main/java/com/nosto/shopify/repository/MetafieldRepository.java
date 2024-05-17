package com.nosto.shopify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nosto.shopify.entity.Metafield;

public interface MetafieldRepository extends JpaRepository<Metafield, Long> {

}
