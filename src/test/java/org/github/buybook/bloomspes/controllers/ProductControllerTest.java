package org.github.buybook.bloomspes.controllers;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import org.github.buybook.bloomspes.application.GetProductService;
import org.github.buybook.bloomspes.application.GetProductsService;
import org.github.buybook.bloomspes.domain.Product;
import org.github.buybook.bloomspes.domain.ProductId;
import org.github.buybook.bloomspes.exceptions.ProductNotFound;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureRestDocs
@WebMvcTest(ProductController.class)
@ActiveProfiles("test")
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetProductsService getProductsService;

    @MockBean
    private GetProductService getProductService;

    @Test
    @DisplayName("GET /products")
    void list() throws Exception {
        given(getProductsService.getProducts())
                .willReturn(List.of(Product.fake(1L)));

        mockMvc.perform(
                        RestDocumentationRequestBuilders.get("/products")
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("CODE")))
                .andDo(document("get-product-list",
                        responseFields(
                                fieldWithPath("[]")
                                        .type(JsonFieldType.ARRAY)
                                        .description("전체 상품 목록"),
                                fieldWithPath("[].id")
                                        .type(JsonFieldType.NUMBER)
                                        .description("상품 아이디"),
                                fieldWithPath("[].title")
                                        .type(JsonFieldType.STRING)
                                        .description("책 이름"),
                                fieldWithPath("[].publisher")
                                        .type(JsonFieldType.STRING)
                                        .description("출판사 이름")
                        ))
                );
    }

    @Test
    @DisplayName("GET /products/{id} (when product exists)")
    void detail() throws Exception {
        given(getProductService.getProduct(any()))
                .willReturn(Product.fake(1L));

        mockMvc.perform(
                        RestDocumentationRequestBuilders.get("/products/1")
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("CODE")))
                .andDo(document("get-product",
                        responseFields(
                                fieldWithPath("id")
                                        .type(JsonFieldType.NUMBER)
                                        .description("상품 아이디 번호"),
                                fieldWithPath("title")
                                        .type(JsonFieldType.STRING)
                                        .description("책 제목"),
                                fieldWithPath("publisher")
                                        .type(JsonFieldType.STRING)
                                        .description("출판사 이름")
                        )));
    }

    @Test
    @DisplayName("GET /products/{id} (when product doesn't exist)")
    void detailNotFound() throws Exception {
        given(getProductService.getProduct(any()))
                .willThrow(new ProductNotFound(new ProductId(1L)));

        mockMvc.perform(
                        RestDocumentationRequestBuilders.get("/products/404")
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
