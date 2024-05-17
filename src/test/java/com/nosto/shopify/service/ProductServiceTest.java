package com.nosto.shopify.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.nosto.shopify.entity.Product;
import com.nosto.shopify.model.ProductModel;
import com.nosto.shopify.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    ProductRepository productRepository;
    ProductService productService;

    @BeforeEach
    public void before() {
        this.productService = new ProductService(productRepository);
    }

    @Test
    void getProductShouldReturnCorrectModelResponse() {
        Product product = createFakeProduct();
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        ProductModel productModel = productService.getProduct(1L);
        assertEquals(createFakeProductModel(), productModel);
    }

    @Test
    void getProductShouldThrowExceptionIfNotFound() throws NoSuchElementException {
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(NoSuchElementException.class, () -> productService.getProduct(1L));
    }

    Product createFakeProduct() {
        return Product.builder()
                .id(1L)
                .title("Biggy smalls")
                .tags("notorious big").build();
    }

    ProductModel createFakeProductModel() {
        return ProductModel.builder()
                .title("Biggy smalls")
                .tags("notorious big").build();

    }
}