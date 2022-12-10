package com.example.demo.buybook.controllers;

import com.example.demo.buybook.application.ProductService;
import com.example.demo.buybook.domain.Product;
import com.example.demo.buybook.dto.ProductData;
import com.example.demo.buybook.mapper.ProductMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

    private final ProductMapper productMapper;
    private final ProductService productService;

    public ProductController(
            ProductMapper productMapper,
            ProductService productService
    ) {
        this.productMapper = productMapper;
        this.productService = productService;
    }

    @GetMapping
    public Stream<ProductData> list() {
        List<Product> products = productService.getProductList();
        return products.stream().map(productMapper::productToProductData);
    }

    @GetMapping("/{id}")
    public Product detail(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody @Valid ProductData productData) {
        return productService.createProduct(productData);
    }

    @PatchMapping("/{id}")
    public Product update(
            @PathVariable Long id,
            @RequestBody @Valid ProductData productData
    ) {
        return productService.updateProduct(id, productData);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
