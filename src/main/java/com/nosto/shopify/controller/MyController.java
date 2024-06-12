/*******************************************************************************
 * Copyright (c) 2024 Nosto Solutions Ltd All Rights Reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Nosto Solutions Ltd ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the agreement you entered into with
 * Nosto Solutions Ltd.
 ******************************************************************************/
package com.nosto.shopify.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    private static final Logger log = LoggerFactory.getLogger(MyController.class);

    public static final String NOSTO_HEADER = "X-nosto-header";

    @PostMapping("/endpoint")
    public ResponseEntity<String> bulkQueryShopifyProducts(@RequestHeader(NOSTO_HEADER) String nostoHeader) {
        log.info("Got request, logging X-nosto-header: {}", nostoHeader);
        MDC.put("request-id", "12345");
        MDC.put("merchant", "testMerchant");
        log.info("This is a test log message.");
        MDC.clear();
        return new ResponseEntity<>("Successfully logged requested", HttpStatus.OK);
    }
}