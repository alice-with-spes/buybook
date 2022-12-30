package com.github.bloomspes.buybook.application;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.bloomspes.buybook.FakeModelFactory;
import com.github.bloomspes.buybook.domain.Product;
import com.github.bloomspes.buybook.repositories.ProductRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class GetProductsServiceTest {
    GetProductsService getProductsService;
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);

        getProductsService = new GetProductsService(productRepository);
    }

    @Test
    void getProducts() {
        Product product = FakeModelFactory.product();

        given(productRepository.findAll()).willReturn(List.of(product));

        List<Product> products = getProductsService.getProducts();

        assertThat(products).isEqualTo(List.of(product));
    }
}
