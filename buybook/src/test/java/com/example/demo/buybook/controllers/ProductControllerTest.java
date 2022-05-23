package com.example.demo.buybook.controllers;

import com.example.demo.buybook.application.ProductService;
import com.example.demo.buybook.domain.Product;
import com.example.demo.buybook.dto.ProductData;
import com.example.demo.buybook.errors.ProductNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;


    @BeforeEach
    void setUp() {
        Product product = Product.builder()
                .id(1L)
                .title("clean code")
                .publisher("insight")
                .build();

        given(productService.getProductList()).willReturn(List.of(product));

        given(productService.getProduct(1L)).willReturn(product);

        given(productService.getProduct(20L)).willThrow(new ProductNotFoundException(20L));

        given(productService.createProduct(any(ProductData.class))).willReturn(product);

        given(productService.updateProduct(eq(1L), any(ProductData.class)))
                .will(invocation -> {
                    Long id = invocation.getArgument(0);

                    ProductData productData = invocation.getArgument(1);

                    return Product.builder()
                            .id(id)
                            .title(productData.getTitle())
                            .publisher(productData.getPublisher())
                            .build();
                });

        given(productService.updateProduct(eq(10L), any(ProductData.class)))
                .willThrow(new ProductNotFoundException(10L));

        given(productService.deleteProduct(10L)).willThrow(new ProductNotFoundException(10L));

    }

    @Test
    void 제품_목록을_가져오는데_성공한다() throws Exception {
        mockMvc.perform(get("/products").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("code")));
    }

    @Test
    void 제품의_상세_정보를_가져온다() throws Exception {
        mockMvc.perform(get("/products/10").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("code")));
    }

}