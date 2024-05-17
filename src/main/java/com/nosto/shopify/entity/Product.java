/*******************************************************************************
 * Copyright (c) 2024 Nosto Solutions Ltd All Rights Reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Nosto Solutions Ltd ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the agreement you entered into with
 * Nosto Solutions Ltd.
 ******************************************************************************/
package com.nosto.shopify.entity;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.nosto.shopify.model.ProductModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;
    private String bodyHtml;
    private String handle;
    private String shopifyId;
    private String productType;
    private OffsetDateTime publishedAt;
    private OffsetDateTime updatedAt;
    private OffsetDateTime createdAt;
    private String title;
    private String vendor;
    private String tags;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Metafield> metafields = new HashSet<>();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private Image image;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Image> images = new HashSet<>();

    public Product(ProductModel productModel) {
        this.setHandle(productModel.getHandle());
        this.setBodyHtml(productModel.getBodyHtml());
        this.setHandle(productModel.getHandle());
        this.setShopifyId(productModel.getId());
        this.setProductType(productModel.getProductType());
        this.setPublishedAt(productModel.getPublishedAt());
        this.setCreatedAt(productModel.getCreatedAt());
        this.setUpdatedAt(productModel.getUpdatedAt());
        this.setTitle(productModel.getTitle());
        this.setVendor(productModel.getVendor());
        this.setTags(productModel.getTags());
        this.setMetafields(productModel.getMetafields().stream().map(m -> Metafield.builder()
                .product(this)
                .key(m.getKey())
                .value(m.getValue())
                .namespace(m.getNamespace())
                .shopifyId(m.getId()).build()).collect(Collectors.toSet()));
        this.setImage(Image.builder()
                .product(this)
                .src(productModel.getImage().getSrc())
                .position(productModel.getImage().getPosition())
                .shopifyId(productModel.getImage().getId())
                .build());
        this.setImages(productModel.getImages().stream().filter(i -> i.getId() != productModel.getImage().getId()).map(i -> Image.builder()
                .product(this)
                .shopifyId(i.getId())
                .src(i.getSrc())
                .position(i.getPosition())
                .build()).collect(Collectors.toSet()));
    }

}
