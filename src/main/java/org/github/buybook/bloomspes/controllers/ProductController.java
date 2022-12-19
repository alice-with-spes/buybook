package org.github.buybook.bloomspes.controllers;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.modelmapper.ModelMapper;

import org.github.buybook.bloomspes.application.GetProductService;
import org.github.buybook.bloomspes.application.GetProductsService;
import org.github.buybook.bloomspes.domain.Product;
import org.github.buybook.bloomspes.domain.ProductId;
import org.github.buybook.bloomspes.dtos.ProductData;
import org.github.buybook.bloomspes.exceptions.ProductNotFound;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final GetProductsService getProductsService;
    private final GetProductService getProductService;
    private final ModelMapper modelMapper;

    public ProductController(GetProductsService getProductsService,
                             GetProductService getProductService,
                             ModelMapper modelMapper) {
        this.getProductsService = getProductsService;
        this.getProductService = getProductService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public Stream<ProductData> list() {
        List<Product> products = getProductsService.getProducts();

        return products.stream()
                .map(this::productToProductData);
    }

    @GetMapping("/{id}")
    public ProductData detail(@PathVariable Long id) {
        Product product = getProductService.getProduct(new ProductId(id));

        return productToProductData(product);
    }

    @ExceptionHandler(ProductNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound(Throwable exception) {
        return exception.getMessage();
    }

    private ProductData productToProductData(Product product) {
        return modelMapper.map(product, ProductData.class);
    }
}
