package com.example.demo.buybook.dto;

import com.example.demo.buybook.domain.Product;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class ProductMapperTest {
    @Test
    public void shouldMapDtoToProduct() {
        // given
        ProductData givenProductData = ProductData.builder()
                .id(2L)
                .title("effective")
                .publisher("insight")
                .build();

        // when
        Product product = ProductMapper.INSTANCE.productDataToProduct(givenProductData);

        // then
        assertThat(product.getId()).isNotNull();
        assertThat(product.getTitle()).isEqualTo("effective");
        assertThat(product.getPublisher()).isEqualTo("insight");
    }

}