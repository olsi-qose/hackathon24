package com.nosto.shopify.service;

import com.nosto.shopify.model.ProductModel;

public interface ProductServiceInterface {
    void saveProduct(ProductModel productModel);

    ProductModel getProduct(Long id);
}
