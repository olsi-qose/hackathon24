package com.nosto.shopify.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nosto.shopify.entity.Image;
import com.nosto.shopify.entity.Product;
import com.nosto.shopify.model.ImageModel;
import com.nosto.shopify.model.MetafieldModel;
import com.nosto.shopify.model.ProductModel;
import com.nosto.shopify.repository.ProductRepository;

@Service
public class ProductService implements ProductServiceInterface {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void saveProduct(ProductModel productModel) {
        Product product = new Product(productModel);
        productRepository.save(product);
    }

    @Override
    public ProductModel getProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        Image image = product.getImage();
        return ProductModel.builder()
                .handle(product.getHandle())
                .productType(product.getProductType())
                .bodyHtml(product.getBodyHtml())
                .id(product.getShopifyId())
                .tags(product.getTags())
                .title(product.getTitle())
                .createdAt(product.getCreatedAt())
                .publishedAt(product.getPublishedAt())
                .updatedAt(product.getUpdatedAt())
                .metafields(product.getMetafields() != null ? product.getMetafields().stream().map(m -> MetafieldModel.builder()
                        .key(m.getKey())
                        .value(m.getValue())
                        .namespace(m.getNamespace())
                        .id(m.getShopifyId()).build()).collect(Collectors.toSet()) : null)
                .image(image != null ? new ImageModel(image.getShopifyId(), image.getSrc(), image.getPosition()) : null)
                .images(product.getImages() != null ? product.getImages().stream().map(v -> new ImageModel(v.getShopifyId(), v.getSrc(), v.getPosition())).collect(Collectors.toSet()) : null)
                .build();

    }


}
