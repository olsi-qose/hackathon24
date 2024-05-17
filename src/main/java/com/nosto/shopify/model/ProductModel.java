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

import java.time.OffsetDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductModel {
    private final String bodyHtml;
    private final String handle;
    private final String id;
    private final String productType;
    private final OffsetDateTime publishedAt;
    private final OffsetDateTime updatedAt;
    private final OffsetDateTime createdAt;
    private final String title;
    private final String vendor;
    private final String tags;
    private final Set<VariantModel> variants;
    private final ImageModel image;
    private final Set<ImageModel> images;
    private final Set<VariantOptionModel> options;
    private final Set<MetafieldModel> metafields;
}
