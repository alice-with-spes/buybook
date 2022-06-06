package com.example.demo.buybook.mapper;

import com.example.demo.buybook.domain.Product;
import com.example.demo.buybook.dto.ProductData;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    Product productDataToProduct(ProductData productData);

    ProductData productToProductData(Product product);
}
