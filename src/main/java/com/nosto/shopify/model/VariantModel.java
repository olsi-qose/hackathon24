/*******************************************************************************
 * Copyright (c) 2024 Nosto Solutions Ltd All Rights Reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Nosto Solutions Ltd ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the agreement you entered into with
 * Nosto Solutions Ltd.
 ******************************************************************************/
package com.nosto.shopify.model;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.builder.CompareToBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VariantModel implements Comparable<VariantModel> {
    public static final String BACK_ORDERING_INVENTORY_POLICY = "continue";
    private final String barcode;
    private final Double compareAtPrice;
    private final String createdAt;
    private final String id;
    private final String inventoryManagement;
    private final String inventoryPolicy;
    private final Integer position;
    private final Double price;
    private final String productId;
    private final String sku;
    private final String title;
    private final int inventoryQuantity;
    private final Double weight;
    private final String weightUnit;
    private final Long imageId;
    private final String option1;
    private final String option2;
    private final String option3;
    private final String inventoryItemId;
    private final List<PresentmentPriceModel> presentmentPrices;
    private final List<MetafieldModel> metafields;
    private final Integer inventoryQuantityAtAllLocations;

    @Override
    public int compareTo(VariantModel variantModel) {
        return new CompareToBuilder()
                .append(Optional.ofNullable(getPosition()).orElse(Integer.MAX_VALUE),
                        Optional.ofNullable(variantModel.getPosition()).orElse(Integer.MAX_VALUE))
                .toComparison();
    }
}
