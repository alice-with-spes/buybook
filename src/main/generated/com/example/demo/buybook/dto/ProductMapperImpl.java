package com.example.demo.buybook.dto;

import com.example.demo.buybook.domain.Product;
import com.example.demo.buybook.domain.Product.ProductBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-31T14:47:43+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product productDataToProduct(ProductData productData) {
        if ( productData == null ) {
            return null;
        }

        ProductBuilder product = Product.builder();

        product.id( productData.getId() );
        product.title( productData.getTitle() );
        product.publisher( productData.getPublisher() );

        return product.build();
    }
}
