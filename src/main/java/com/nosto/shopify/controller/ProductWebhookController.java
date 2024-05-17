package com.nosto.shopify.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.nosto.shopify.model.ProductModel;
import com.nosto.shopify.service.ProductServiceInterface;


@RestController
public class ProductWebhookController implements ProductWebhookControllerInterface {
    private static final Logger logger = LoggerFactory.getLogger(ProductWebhookController.class);

    private final ProductServiceInterface productServiceInterface;

    @Autowired
    public ProductWebhookController(ProductServiceInterface productServiceInterface) {
        this.productServiceInterface = productServiceInterface;
    }

    @Override
    public void update(ProductModel productModel) {
        logger.info("Product received is:{}", productModel);
        productServiceInterface.saveProduct(productModel);
    }

    @Override
    public ProductModel getProduct(Long id) {
        logger.info("Getting product by id:{}", id);
        return productServiceInterface.getProduct(id);
    }
}
