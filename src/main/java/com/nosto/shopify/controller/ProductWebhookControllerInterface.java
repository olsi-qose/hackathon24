package com.nosto.shopify.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nosto.shopify.model.ProductModel;

@RequestMapping("/hub/shopify/product")
public interface ProductWebhookControllerInterface {

    @PostMapping("/update")
    void update(@RequestBody ProductModel productModel);

    @GetMapping("/{id}")
    ProductModel getProduct(@PathVariable Long id);
}
