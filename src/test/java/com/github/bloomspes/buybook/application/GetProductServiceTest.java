package com.github.bloomspes.buybook.application;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.bloomspes.buybook.FakeModelFactory;
import com.github.bloomspes.buybook.domain.Product;
import com.github.bloomspes.buybook.domain.ProductId;
import com.github.bloomspes.buybook.exceptions.ProductNotFound;
import com.github.bloomspes.buybook.repositories.ProductRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class GetProductServiceTest {
    GetProductService getProductService;
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);

        getProductService = new GetProductService(productRepository);
    }

    @Test
    @DisplayName("getProduct (when the product exists)")
    void getProductWhenExist() {
        ProductId id = new ProductId(1L);
        Product product = FakeModelFactory.product(id);

        given(productRepository.findById(id)).willReturn(Optional.of(product));

        Product found = getProductService.getProduct(id);

        assertThat(found).isEqualTo(product);
    }

    @Test
    @DisplayName("getProduct (when the product doesn't exist)")
    void getProductWhenNotExist() {
        ProductId id = new ProductId(404L);

        given(productRepository.findById(id)).willReturn(Optional.empty());

        assertThatThrownBy(() -> {
            getProductService.getProduct(id);
        }).isInstanceOf(ProductNotFound.class);
    }
}
